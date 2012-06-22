(ns com.andrewmcveigh.curriculum-vitae.core
  (:use
    [clojure pprint]
    [clojure.java shell]
    [hiccup core])
  (:require
    [com.andrewmcveigh.curriculum-vitae [info :as info]]
    [clojure [string :as string :only [replace]]]))

(defn render-keyword [k syntax]
  (case k
    :h1 (str "\n" (case syntax :org "* "   :markdown "\n# "))
    :h2 (str "\n" (case syntax :org "** "  :markdown "\n## "))
    :h3 (str "\n" (case syntax :org "*** " :markdown "\n### "))
    :li "\n- "
    :p  "\n"
    nil))

(defn cv->syntax [element syntax]
  (apply str
         (cond 
           (coll? element)    (map #(cv->syntax % syntax) element)
           (keyword? element) (render-keyword element syntax)
           :default           element)))

(defn render-brace [cmd elem]
  (str (apply str \\ cmd "{" elem) "}\n"))

(defn render-tex [elems]
  (case (first elems)
    :doc   {:begin (render-brace "begin" "document")
            :end   (render-brace "end" "document")}
    :title "\\maketitle\n"
    :h1    (render-brace "section*" (rest elems))
    :h2    (render-brace "subsection*" (rest elems))
    :h3    (str (apply str "\\subsubsection*{\\emph{" (rest elems)) "}}\n")
    :ul    {:begin (render-brace "begin" "itemize")
            :end   (render-brace "end" "itemize")}
    :li    (str (apply str "\\item " (rest elems)) "\n")
    :p     (str (apply str (rest elems)) "\n")
    nil))

(defn escape-tex-str [s]
  (string/replace
    (string/replace s #"([&%$#_\{\}~^\\])" "\\\\$1")
    #"\"([^\"]*)\"" "``$1''"))

(defn filter-elems [element]
  (map #(if (string? %) (escape-tex-str %) %)
       (filter #(not (coll? %)) element)))

(defn cv->tex [element]
  (let [level (cond 
                (coll? element)   (apply list
                                         (render-tex (filter-elems element))
                                         (map cv->tex (filter coll? element)))
                (string? element) (escape-tex-str element)
                :default          element)]
    (if (:begin (first level))
      (str (:begin (first level)) (apply str (rest level)) (:end (first level)))
      (apply str level))))

(defn tex->pdf []
  (spit "cv.tex"
        (str
          (slurp "tex-header.tex")
          (cv->tex [:doc [:title] info/cv])))
  (sh "pdflatex" "-interaction=batchmode" "cv.tex"))

(defn -main [& args]
  (spit "README.md" (cv->syntax info/cv :markdown))
  (spit "cv.org" (cv->syntax info/cv :org))
  (tex->pdf))

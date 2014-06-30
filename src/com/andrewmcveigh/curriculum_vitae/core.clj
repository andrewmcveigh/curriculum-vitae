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
    :h1 (str "\n" (case syntax :org "* " :markdown "\n# "))
    :h2 (str "\n" (case syntax :org "** " :markdown "\n## "))
    :h3 (str "\n" (case syntax :org "*** " :markdown "\n### "))
    :h4 (str "\n" (case syntax :org "**** " :markdown "\n#### "))
    :h5 (str "\n" (case syntax :org "***** " :markdown "\n##### "))
    :li "\n- "
    :p  "\n"
    nil))

(defn cv->syntax [element syntax]
  (apply str
         (cond 
          (coll? element) (map #(cv->syntax % syntax) element)
          (keyword? element) (render-keyword element syntax)
          :default element)))

(defn render-brace [cmd elem]
  (str (apply str \\ cmd "{" elem) "}\n"))

(defn render-tex [elems]
  (case (first elems)
    :doc   {:begin (render-brace "begin" "document")
            :end (render-brace "end" "document")}
    :title "\\maketitle\n"
    :h1    (render-brace "section*" (rest elems))
    :h2    (render-brace "subsection*" (rest elems))
    :h3    (str (apply str "\\subsubsection*{\\emph{" (rest elems)) "}}\n")
    :h4    (str (apply str "\\paragraph*{\\emph{" (rest elems)) "}}\n")
    :ul    {:begin (render-brace "begin" "itemize")
            :end (render-brace "end" "itemize")}
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
               (coll? element) (apply list
                                      (render-tex (filter-elems element))
                                      (map cv->tex (filter coll? element)))
               (string? element) (escape-tex-str element)
               :default element)]
    (if (:begin (first level))
      (str (:begin (first level)) (apply str (rest level)) (:end (first level)))
      (apply str level))))

(defn tex->pdf [file]
  (spit file
        (str
         (slurp "tex-header.tex")
         (cv->tex [:doc [:title] info/cv])))
  (sh "pdflatex" "-interaction=batchmode" file))

(defn render-control [start elem end]
  (let [elem (map #(string/replace % #"\s\s+" " ") elem)]
    (str (apply str start elem) end)))

(defn render-rtf [element]
  (case (first element)
    :h1 (render-control "\\s1\\sb480\\sa240\\b\\f0\\fs32" (rest element) "\\b0\\par\n")
    :h2 (render-control "\\s2\\sb320\\sa180\\b\\f0\\fs28" (rest element) "\\b0\\par\n")
    :h3 (render-control "\\s1\\sb240\\sa180\\b\\i\\f0\\fs24" (rest element) "\\i0\\b0\\par\n")
    :ul "\\ls1\\ilvl0\n\\f0\\fs24 \\cf0 \\pard\\tx160\\tx320\\tx1133\\tx1700\\tx2267\\tx2834\\tx3401\\tx3968\\tx4535\\tx5102\\tx5669\\tx6236\\tx6803\\li340\\fi-340\\ql\\qnatural\\pardirnatural\n"
    :li (render-control "\\sb120\\sa0\\f0\\fs22{\\listtext\\tab\\bullet\\tab}" (rest element) "\\\n")
    :p  (render-control "\\pard\\sb0\\sa0\\f0\\fs22" (rest element) "\\par\n")
    nil))

(def rtf-header
  "{\\rtf1\\ansi\\ansicpg1252\\cocoartf1038\\cocoasubrtf360
{\\fonttbl\\f0\\fswiss\\fcharset0 Times New Roman;}
{\\colortbl;\\red255\\green255\\blue255;}
{\\*\\listtable{\\list\\listtemplateid1\\listhybrid{\\listlevel\\levelnfc23\\levelnfcn23\\leveljc0\\leveljcn0\\levelfollow0\\levelstartat1\\levelspace360\\levelindent0{\\*\\levelmarker \\{disc\\}}{\\leveltext\\leveltemplateid1\\'01\\uc0\\u8226 ;}{\\levelnumbers;}\\fi-360\\li720\\lin720 }{\\listname ;}\\listid1}}
{\\*\\listoverridetable{\\listoverride\\listid1\\listoverridecount0\\ls1}}
\\paperw11900\\paperh16960\\margl1440\\margr1440\\margt200\\margb200\\vieww9000\\viewh8400\\viewkind0\n")

(defn cv->rtf [element]
  (cond
   (coll? element) (apply list
                          (render-rtf (filter #(not (coll? %)) element))
                          (map cv->rtf (filter coll? element)))
   :default        element))

(defn -main [& args]
  (spit "README.md" (cv->syntax info/cv :markdown))
  (spit "andrew_mcveigh-cv.org" (cv->syntax info/cv :org))
  (spit "andrew_mcveigh-cv.doc" (str (apply str rtf-header (flatten (cv->rtf info/cv))) \}))
  (tex->pdf "andrew_mcveigh-cv.tex")
  (println "Conversion Complete."))

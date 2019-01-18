(ns com.andrewmcveigh.curriculum-vitae.info)

(def cv
  [:body
   [:h1 "Education"
    [:h2 "University of Huddersfield, UK"
     [:ul [:li "BSc Software Development & Multimedia (1st Class), 2008"]]]
    ;; [:h3 "Huddersfield Technical College"
    ;;  [:ul [:li "Diploma, Access Studies (Computing/Maths/Chemistry), 2004"]]]
    ;; [:h3 "Salendine Nook High School"
    ;;  [:ul [:li "8 GCSEs (Grades A-C), 1998"]]]

    ;; [:h2 "Professional Qualifications"
    ;;  [:h3 "Microsoft Certified Professional (Expired)"
    ;;   [:ul [:li "Networking Essentials, 2000"]]]]
    ]
   [:h1 "Technologies"
    [:h2 "Languages"
     [:p (apply
          str
          (interpose
           ", "
           (sort
            ["Clojure" "ClojureScript" "Haskell" "Java" "Javascript" "Python"
             "Ruby" "Bash" "SQL" "HTML" "CSS" "Idris" "Scheme" "Elm"])))]]
    [:h2 "Other technology"
     [:p (apply
          str
          (interpose
           ", "
           (sort
            (distinct
             ["AWS" "Docker" "Kafka" "RabbitMQ" "Linux" "NixOS" "Git" "Maven"
              "Leiningen" "Apache" "Nginx" "MongoDB" "Riemann" "SQLite" "MySQL"
              "PostgreSQL" "Redis" "React" "ECS" "EC2" "Aurora" "S3" "Kinesis"
              "ELK"]))))]]]

   [:h1 "Talks"
    [:h2 "A Dynamic, Statically Typed Contradiction"
     [:p "
Given at ClojureX, London, Dec 2017 and :clojured, Berlin, Feb 2018. The talk
was about Algorithm-W, how static type-checking (of the Hindley-Milner family)
works, with an implementation of a Hindley-Milner based type-checker for a
growing subset of Clojure. The type-checker included features such as
Haskell-like typeclasses and extensible records."]]

    [:h2 "Speculative Development"
     [:p "
Given at ClojureX, London, Dec 2016 and :clojured, Berlin, Feb 2017. The talk
was on the topic of clojure.spec, a data specification DSL for Clojure, and what
you can do with it if you're willing to bend the rules a bit."]]]

   [:h1 "Experience"
    [:h2 "Developer: GoMore [2017 - 2018]"
     [:p "
GoMore is a peer-to-peer transportation startup based in Copenhagen. The product
is a web and mobile app enabling customers to share car journeys, to share their
car by renting it out, and to lease cars that can then be used on the rental
platform.\\"]

     [:p "\\
My responsibilities are to lead infrastructure projects as part of the backend
team, and building out Clojure APIs as part of the broader product team. The
APIs need to handle many versions at once, as this enables the mobile product to
move quickly with new or improved features, but existing mobile clients still
need to be supported. We can only phase out deprecated versions when they are
seeing little to no traffic, and many users cannot upgrade to new clients due to
restrictions on the handsets.\\"]

     [:p "\\
Recent infrastructure highlights include a move of the whole product and
infrastructure to containers from Elastic Beanstalk, and migrating the main
database load to an Aurora cluster. We can now better distribute the load to
read heads, and scale the database horizontally relatively quickly."]]

    [:h2 "Developer: uSwitch Ltd. [2015 - 2017]"
     [:h4 "Platform"
      [:p "
Looking after the core services running the energy business, including the
central comparison engine powering the energy website, along with various data
APIs, processing pipelines, and data delivery to different teams. Building out
new APIs to support 3rd party integrations for comparison and metadata. Involved
quite a bit of scaling and performance work to cope with 10+ times normal load
spikes of traffic and similar rates of sign-ups and sales, due to TV promotion
of energy switching."]]
     [:h4 "Back office"
      [:p "
Cross-functional team, involving commercial, operations, financial and software
development. The role involved maintenance and development of uSwitch Energy's
backend services responsible for the day-to-day operation of the energy
business. Negotiating with 3rd parties and commercial around specification and
implementation of data exchange. Services involved the integration, delivery and
processing of data to and from 3rd parties, product tracking, financial
reporting and analysis."]]
     [:h4 "Technology"
      [:p "
The majority of services were written in Clojure, with some Ruby and a bit of
tooling in Go. Data was delivered to different teams via Kafka,
Kinesis/Firehose, RabbitMQ, HTTP or FTP as required. The infrastructure was
hosted on EC2, mostly using AWS's Elastic Container Service. Logging/monitoring
with ELK, Cloudwatch (metrics/alarms) and Sensu (alerting)."]]]

    [:h2 "Software Developer: Interel Group, Brussels [2008 - 2015]"
     [:p "
Responsible for the design, development, and maintenance of all the group's
software infrastructure, including the deployment and automation of key
Linux-based services.\\"]
     [:p "\\
Applications ranged from internal financial administration and reporting tools,
project management tools, internal infrastructure monitoring, and data
exporting, to client-facing CMS building and customisation.\\"]
     [:p "\\
The services were deployed on in-house servers, bespoke applications and
services were written mainly in Clojure, with some Java. Web apps were build
using ClojureScript and React(OM) on the front-end."]]

    #_[:h3 "Prior, non-technical work omitted for brevity"
     [:p "Details available upon request"]]

    [:h2 "Sales Assistant"
     [:h3 "Gamestation, Huddersfield [2005 - 2006]"
      #_[:p "Duties/responsibilities: staff training, stock control, cashing up,
          banking, administration, and customer service."]]]

    [:h2 "Shift Manager"
     [:h3 "Allied Leisure, Huddersfield [2001 - 2004]"
      #_[:p "Duties/responsibilities: staff management, staff training, stock
          control, ordering, cashing up, banking, loss control, administration,
          and customer service."]]]

    [:h2 "Insurance Assistant"
     [:h3 "Fartown Insurance, Huddersfield [2000 - 2001]"
      #_[:p "Duties/responsibilities: customer quotations, renewals, developing
          and maintaining the company website, other general administration
          duties."]]]

    [:h2 "Computer Technician"
     [:h3 "Easy Computers, Huddersfield [1998 - 2000]"
      #_[:p "Duties/responsibilities: build, repair, update and install home
          computers, on-site network installation and maintenance."]]]]])

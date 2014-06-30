(ns com.andrewmcveigh.curriculum-vitae.info)

(def cv
  [:body
   [:h1 "Education"
    [:h2 "Academic Qualifications"
     [:h3 "University of Huddersfield, UK"
      [:ul [:li "BSc Software Development & Multimedia (1st Class), 2008"]]]
     ;; [:h3 "Huddersfield Technical College"
     ;;  [:ul [:li "Diploma, Access Studies (Computing/Maths/Chemistry), 2004"]]]
     ;; [:h3 "Salendine Nook High School"
     ;;  [:ul [:li "8 GCSEs (Grades A-C), 1998"]]]
     ]
    ;; [:h2 "Professional Qualifications"
    ;;  [:h3 "Microsoft Certified Professional (Expired)"
    ;;   [:ul [:li "Networking Essentials, 2000"]]]]
    ]
   [:h1 "Technical Summary"
    [:h2 "Languages / Frameworks"
     [:p (apply
          str
          (interpose
           ", "
           (sort
            ["Clojure" "ClojureScript" "C" "C#" "Java"
             "Javascript" "Python" "Bash" "SQL" "HTML" "SVG" "HAML" "CSS"
             "SASS" ".NET" "Silverlight" "jQuery" "Django" "Cocoa"
             "Objective-C" "AppleScript" "Tex"])))]]
    [:h2 "Operating Systems, Software & Technologies"
     [:p (apply 
          str
          (interpose
           ", "
           (sort
            ["Linux" "OS X" "Windows (NT/2000/XP/Server/7)" "Vim"
             "Visual Studio" "Netbeans" "Eclipse" "Emacs" "Git" "Mercurial"
             "Subversion" "Maven" "Leiningen" "Puppet" "Pallet" "OpenStack"
             "Apache" "Jenkins" "IIS" "Lighttpd" "Nginx" "MongoDB" "Riemann"
             "SQLite" "MySQL" "PostgreSQL" "SQL Server" "Flash"
             "Photoshop" "Illustrator" "VMWare" "MS Exchange"])))]]]
   [:h1 "Experience"
    [:h2 "Software Developer"
     [:h3 "Interel Group, Brussels  [2008 - Present]"
      [:p "Hired on an IT helpdesk/software development student placement,
          later offered a full-time position as a software developer. Now
          responsible for the design, development, and maintenance of all the
          group's software infrastructure, including the deployment
          and automation of key Linux-based services."]
      [:h4 "Software/Development"
       [:ul
        [:li "Financial reporting/forecasting/pipeline tool.
             [Clojure/ClojureScript]"]
        [:li "Bespoke app/deploy/automation of software services.
             [Pallet/Clojure]"]
        [:li "Re-design/build of bespoke intranet solution.
             [Clojure/ClojureScript/LDAP]"]
        [:li "Created/Deployed \"Webinars\" system using \"BigBlueButton\" & a
             custom scheduling webapp. [Java/Clojure]"]
        [:li "Delivered a customised implementation of an \"XWiki Farm\".
            [Java/J2EE/Clojure]"]
        [:li "Helpdesk email monitor: Monitors an Exchange mailbox for emails,
            adds an entry in the ticketing system.
            [Clojure/SOAP/Exchange Web Services API (Java)]"]
        [:li "Helpdesk ticketing/inventory webapp.
            [C#/ASP.NET MVC/Javascript/jQuery/T-SQL]"]
        [:li "Inventory tracking: Periodically scans the network for changes,
            integrated with the Intranet, and the ticketing system.
            [C#/WMI/T-SQL]"]
        [:li "TAPI Monitor: Windows Service, monitoring a VOIP extention for
            incoming calls, looks up caller from called id, logs in ticketing
            system. [TAPI/C#/.NET/WCF]"]
        [:li "Building reports on various existing databases.
            [C#/Crystal Reports/Clojure/Incanter]"]
        [:li "Financial report building [Business Objects/Maconomy AnalytiX]"]]]
      [:h4 "Dev/Ops"
       [:ul
        [:li "Automated build/deploy of core Linux-based services.
             [Linux/Pallet/Clojure]"]
        [:li "Basic implementation of Riemann monitoring. [Clojure/Riemann]"]
        [:li "Automated deploy of basic implementation of OpenStack
             [Pallet/Openstack]"]
        [:li "Distributed configuration managment of various *NIX based servers.
             [Puppet/Pallet]"]
        [:li "Implemented Continuous integration/build/deploy system.
             [Jenkins/Maven/Nexus/Pallet]"]
        [:li "Various scripting/sysadmin tasks [Bash/Python/*NIX]"]]]]]
    [:h2 "Sales Assistant"
     [:h3 "Gamestation, Huddersfield [2005 - 2006]"
      [:p "Duties/responsibilities: staff training, stock control, cashing up,
          banking, administration, and customer service."]]]
    [:h2 "Shift Manager"
     [:h3 "Allied Leisure, Huddersfield [2001 - 2004]"
      [:p "Duties/responsibilities: staff management, staff training, stock
          control, ordering, cashing up, banking, loss control, administration,
          and customer service."]]]
    [:h2 "Insurance Assistant"
     [:h3 "Fartown Insurance, Huddersfield [2000 - 2001]"
      [:p "Duties/responsibilities: customer quotations, renewals, developing
          and maintaining the company website, other general administration
          duties."]]]
    [:h2 "Computer Technician"
     [:h3 "Easy Computers, Huddersfield [1998 - 2000]"
      [:p "Duties/responsibilities: build, repair, update and install home
          computers, on-site network installation and maintenance."]]]]])

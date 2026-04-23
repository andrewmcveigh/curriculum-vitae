

# Education

## University of Huddersfield, UK
- BSc Software Development & Multimedia (1st Class), 2008

# Technologies

## Languages
Bash, CSS, Clojure, ClojureScript, Elm, HTML, Haskell, Idris, Java, JavaScript, Python, Ruby, Rust, SPARQL, SQL, Scheme

## Platforms, Tools & Frameworks
AWS, Apache, Aurora, Azure, Docker, EC2, ECS, ELK, Geospatial, Git, Google Cloud, Kafka, Kinesis, Linked Data, Linux, Mapbox Vector Tiles, MongoDB, MySQL, Nginx, NixOS, PostgreSQL, RDF, RabbitMQ, React, Redis, Riemann, S3, SQLite, Shapefiles, Svelte

# Talks

## A Dynamic, Statically Typed Contradiction

Given at ClojureX, London, Dec 2017 and :clojured, Berlin, Feb 2018. The talk
was about Algorithm-W, how static type-checking (of the Hindley-Milner family)
works, with an implementation of a Hindley-Milner based type-checker for a
growing subset of Clojure. The type-checker included features such as
Haskell-like typeclasses and extensible records.

## Speculative Development

Given at ClojureX, London, Dec 2016 and :clojured, Berlin, Feb 2017. The talk
was on the topic of clojure.spec, a data specification DSL for Clojure, and what
you can do with it if you're willing to bend the rules a bit.

# Experience

## Director / Consultant / Product Engineer: Modfacto LTD [2025 - Present]
Working as a Consultant delivering solutions across multiple projects for
      government and public sector clients, using a diverse technology stack
      including Python, Java, Clojure, JavaScript, React, Linked Data, RDF,
      SPARQL. Designed and delivered scalable web-based and geospatial data
      systems.\
Additionally serving as a Product Engineer developing audio applications
      in Rust, contributing to system design and implementation with a focus on
      performance, reliability, and efficient low-level processing.

## Principal Engineer: Swirrl IT LTD ... TPXimpact [2019 - 2024]
Joined Swirrl IT Ltd in 2019; continued in role following acquisition by TPXimpact in 2022.\
Joined as a Senior Software Engineer and progressed to Principal Software
     Engineer, contributing to core platform infrastructure and leading major
     public sector delivery initiatives.\
Worked across a broad range of technologies spanning web and geospatial
      data systems, including JavaScript and React for front-end development,
      and Java and Clojure for backend services. Used SPARQL for querying
      linked data, and PostgreSQL/PostGIS for data storage and geospatial
      processing. Leveraged cloud platforms such as AWS and Google Cloud for
      deployment and scalability. Worked extensively with geospatial linked-data
      formats and tooling, including processing shapefiles and generating Mapbox
      Vector Tiles, supporting the development of data-intensive, map-driven
      applications.

### Core Infrastructure & Platform
Contributed to and evolved Swirrl’s core infrastructure, improving reliability,
      scalability, and operational maturity across cloud-hosted data platforms. Played
      a key role in architectural decisions, deployment automation, and production
      support for business-critical services.

### Environment Agency Programme – Lead Engineer
Acted as Lead Engineer for a long-running programme with the Environment Agency,
     providing technical leadership across multiple concurrent projects spanning
     product development and site reliability.

#### Key contributions included:
- Architectural oversight and engineering direction for several production systems.
- Leading reliability and operational improvements for public-facing data services.
- Rewriting the Catchment Data Explorer to modernise its architecture and improve maintainability and performance.
- Taking the Shoreline Management Plan platform from prototype through to full production, establishing scalable infrastructure and delivery practices.
- Worked closely with client stakeholders to translate complex environmental and policy requirements into robust, production-grade systems.

## Senior Software Engineer: Habito [2018]
Worked primarily on backend systems and a mortgage broker portal using
      Haskell and PureScript, building and maintaining robust, type-safe
      services and user-facing functionality. Focused on improving system
      reliability and correctness within a functional programming paradigm.\
A key achievement was diagnosing and resolving a complex, deep-seated bug
      in the Haskell/PostgreSQL event sourcing persistence layer, restoring data
      consistency and improving the stability and integrity of the platform’s
      broker/customer data workflows.

## Developer: GoMore [2017 - 2018]

GoMore is a peer-to-peer transportation startup based in Copenhagen. The product
is a web and mobile app enabling customers to share car journeys, to share their
car by renting it out, and to lease cars that can then be used on the rental
platform.\
\
My responsibilities were to lead infrastructure projects as part of the backend
team, and build out Clojure APIs as part of the broader product team. The
APIs need to handle many versions at once, as this enables the mobile product to
move quickly with new or improved features, but existing mobile clients still
need to be supported. We can only phase out deprecated versions when they are
seeing little to no traffic, and many users cannot upgrade to new clients due to
restrictions on the handsets.\
\
Recent infrastructure highlights include a move of the whole product and
infrastructure to containers from Elastic Beanstalk, and migrating the main
database load to an Aurora cluster. We can now better distribute the load to
read heads, and scale the database horizontally relatively quickly.

## Developer: uSwitch Ltd. [2015 - 2017]

#### Platform

Looking after the core services running the energy business, including the
central comparison engine powering the energy website, along with various data
APIs, processing pipelines, and data delivery to different teams. Building out
new APIs to support 3rd party integrations for comparison and metadata. Involved
quite a bit of scaling and performance work to cope with 10+ times normal load
spikes of traffic and similar rates of sign-ups and sales, due to TV promotion
of energy switching.

#### Back office

Cross-functional team, involving commercial, operations, financial and software
development. The role involved maintenance and development of uSwitch Energy's
backend services responsible for the day-to-day operation of the energy
business. Negotiating with 3rd parties and commercial around specification and
implementation of data exchange. Services involved the integration, delivery and
processing of data to and from 3rd parties, product tracking, financial
reporting and analysis.

#### Technology

The majority of services were written in Clojure, with some Ruby and a bit of
tooling in Go. Data was delivered to different teams via Kafka,
Kinesis/Firehose, RabbitMQ, HTTP or FTP as required. The infrastructure was
hosted on EC2, mostly using AWS's Elastic Container Service. Logging/monitoring
with ELK, Cloudwatch (metrics/alarms) and Sensu (alerting).

## Software Developer: Interel Group, Brussels [2008 - 2015]

Responsible for the design, development, and maintenance of all the group's
software infrastructure, including the deployment and automation of key
Linux-based services.\
\
Applications ranged from internal financial administration and reporting tools,
project management tools, internal infrastructure monitoring, and data
exporting, to client-facing CMS building and customisation.\
\
The services were deployed on in-house servers, bespoke applications and
services were written mainly in Clojure, with some Java. Web apps were build
using ClojureScript and React(OM) on the front-end.
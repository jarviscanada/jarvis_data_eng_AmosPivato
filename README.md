# Amos Pivato . Jarvis Consulting

My name is Amos Pivato, and I am a Toronto Metropolitan University Computer Science graduate with experience working in Data science and automation.  I then discovered the world of AI and machine learning and decided that I wanted to leverage my skills with these tools to help build solutions that could help improve the way we live our everyday lives.  Since that day, I've worked in Python, Java, and VBA to develop automated reporting and information consolidating tools, such as automated budgeting tools and movie recommenders, to grow and progress my knowledge in AI and machine learning.  All of this practice has also allowed me to grow my skills, proficiencies, and experiences even further to become a confident and reliable back-end developer.

## Skills

**Proficient:** Python, C/C++, Visual Basic, Linux/Bash, RDBMS/SQL, Agile/Scrum, Git

**Competent:** Java, JavaScript/Jquery, HTML/CSS, DAX/M, Power BI/Power Query, SAP, R, Haskel, Erlang/Rust/Prolog, Oracle, PSQL, DOCKER, JUNIT

**Familiar:** React/React Native, Android studio, Selenium, PHP/ASP, Ruby, Perl, Arduino/Raspberry Pi

## Jarvis Projects

Project source code: [https://github.com/jarviscanada/jarvis_data_eng_AmosPivato](https://github.com/jarviscanada/jarvis_data_eng_AmosPivato)


**Cluster Monitor** [[GitHub](https://github.com/jarviscanada/jarvis_data_eng_AmosPivato/tree/master/linux_sql)]:
      
  - Implemented a Linux Cluster monitoring agent, using automated Bash commands, that retrieves and stores local network node hardware spec and usage data into a PSQL docker instance.
  - Designed the database table schemas for host info and host usage node data, and business problem queries that will provide information from this stored data within the RDBMS.

**Core Java Apps** [[GitHub](https://github.com/jarviscanada/jarvis_data_eng_AmosPivato/tree/master/core_java)]:
      
  - Twitter App: Implemented a Twitter CRD app that used a Java DAO to interact with Twitter's REST API to post, show, or delete tweets. Springboot was used to handle app dependencies and to ensure all the app layers functioned accordingly when run from the CLI.   The app was then built using Maven and then deployed through Dockerhub as a Docker image for easy distribution and execution.
  - JDBC App: Implemented and built, using Maven, a JDBC CRUD app using a PSQL docker instance Database that interacts with a DAO Data structure for easy application layer and database management.
  - Grep App: Implemented a GREP application, built using Maven, in Java, using interface implementations that could search for strings recursively within directory files using a user-supplied matching regex pattern. The app was dockerized and deployed on Dockerhub for easy access and distribution.

**Springboot App** [[GitHub](https://github.com/jarviscanada/jarvis_data_eng_AmosPivato/tree/master/springboot)]:
      
  - Implemented a Springboot trading app that allowed users to retrieve quotes from the IEX cloud API and save them to a daily list or make orders for them using funds on their account.  Trader account details and quote details were persisted in the PSQL database using JDBC as the Datasource API.
  - The Application was designed around a microservice architecture to allow for a RESTfull design to take place as the CRUD operations could be run using DTO's and DAOs for each table in the database.  This allowed for the app to handle any HTTP request that the app's endpoints provided without needing to worry about andy state changes within the application.  Swagger was used to create an accessible UI for user and endpoint testing.
  - The final PoC was deployed using Docker images: one to host and initialize the PSQL instance, the other to host the SPringboot app itself after it was dockerized with a docker network to bridge their communications.


## Highlighted Projects
**Text Adventure Python Game**: Implemented a text adventure game with AI-driven NPCs using Python class functionalities.  Designed UML architecture and class diagrams to facilitate implementation within an agile team framework.  We developed the game's story and level to be interactable by the player and kept track of the game's states using a JSON file.  User actions were taken from terminal input strings and parsed to then be sent into the game engine loop to change states and progress the adventure.

**3d Robot Tower Defense Game**: Designed a level-driven 3d modeled tower shooter with textures in C++ using OpenGL libraries.  As a team, Models were implemented with a full hierarchical design for animation-driven gameplay using life and points-based gameplay loop with a UI that displayed the game states.  Controls  were implemented using Keyboard and mouse event handlers, to allow for screen zooming, robot controls, and game state resets.

**Movie Recommender System**: Designed, implemented, and tested two machine learning models to evaluate the accuracy of supervised learning Algorithms for movie recommendations in Python.  Using the features from the Movielense Dataset, I decided to use the BPR, Bayesian personalized ratings pairwise loss, and the WARP, Weighted approximate rank pairwise loss, loss functions to conduct the learning regression steps for training the two approaches.  They were then tested against a testing set that was created beforehand using the same dataset  to check which model had higher results.


## Professional Experiences

**Junior Backend Developer, National Bank of Canada (2022-present)**: Implemented and deployed numerous scripts and endpoints for backend APIs using Springboot, maven, JUnit, Kafka, terraform, Jenkins and proprietary tools within local and cloud-based environments such as AWS EKS.  Assisted in the migration of web applications from Openshift to AWS EKS. Worked with the Atlassian suite list of applications including Bitbucket, Jira and Confluence for task, documentation and application version management. Applied the software development lifecycle concepts to maintain project demands and expectations. Completed unit, manual, mutation and integration testing using Postman, Junit and Sonarlint to ensure code quality and functionality. Combined efforts with my team in an agile scrum framework to complete our task efficiently while maintaining daily meetings and sprint retrospectives.

**Software Developer, Jarvis (2022-present)**: Implemented a series of back-end Java and Linux-based projects using industry-standard tools such as Docker, Maven, Springboot, and Junit. Learned and applied multiple computer science concepts in a software development lifecycle context. Collaborated in a team setting using the agile scrum framework to conduct daily meetings and project retrospectives.

**Underwriting Assistant, Munich Re (2021-2021)**: Designed and implemented queries to pull relevant data from online warehouses into Power BI. Arranged and formatted tables to ensure the information pulled from the data reconciles with department standards. Documented query details, design, and functionality for future development.

**Inspection and Claims Administrative assistant, HSB BII (2016-2020)**: Automated business analysis report using VBA scripts. Helped in sorting and analysis of client company transactions. Worked with a team to analyze and automate accounting data reports using Power Query and Power BI Collaborated in a team to design and implement an automated policy pricing tool in VBA and Power Query, and create respective documentation


## Education
**Toronto Metropolitan University (2017-2022)**, Bachelor of Computer Science (honors), Department of Computer Science

**University of Toronto Scarborough (2015-2016)**, Environmental Science, Department of Physical & Environmental Science
- 3rd place in UTSC's FinanceHacks Hackathon


## Miscellaneous
- Licensed International Taekwondo Federation Black Belt Instructor (2018)
- French Billingual High school Diploma (2015)
- Certified Standard First Aid & CPR/AED Level C (Canadian Red Cross, 2019)
- Fluent in French and knowledgable in Spanish
- Trombone player
- Rock climbing
- Gaming
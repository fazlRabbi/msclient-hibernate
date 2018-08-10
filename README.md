Application for multiple sclerosis
==============

## How to build and run project 
You need an IDE, Tomcat and Maven installed.

Open the project in your favorite IDE (IntelliJ is recommended).

Configure the mssservice application url in the Facade files found under src/no/hib/msapp/RESTCleint.
For example, If the msservice is running in port 9030 the url should be: http://localhost:9030/api/preperation.


Run Maven command "install" to update and generate the .war file.

Setup the Tomcat server and run the application as a Tomcat application.

The MS-application should now be available on localhost:8080.


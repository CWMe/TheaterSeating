# About

This application is a solution to the problem of creating a dynamic pricing capability that can handle different pricing schemes for a movie theater and a live theater, with different 
seating arrangements and pricing methodologies.  

# Compiling

This application is a Maven project and therefore should be built (i.e. compiled) using maven.  You can use maven from the command line (i.e. mvn) if you have it installed separately from
your IDE, or from within your IDE.

If building from the command line, type the following from the root directory of this project:

```mvn clean install```

# Running

This application uses the Maven Shade Plugin to build a shaded jar that contains all of the project's dependencies and making it easy to run the application.

You can either run the application from within your IDE or from the command line by typing the following from the root directory of this project:

```java -jar target/TheaterSeating-1.0-SNAPSHOT.jar```   

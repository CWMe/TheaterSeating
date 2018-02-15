# About

This application is a stubbed version of the fully functioning application.  Your mission is to evaluate the interfaces, abstract class and the builder that's provided and create the 
concrete implementing classes and instantiate them in the builder.

Your ability to complete this will depend on your understanding of inheritance (i.e. parent-class behaviors inherited by child classes) and polymorphism (i.e. declaring and referring to an 
object by a type OTHER THAN its actual type).

# Compiling

This application is a Maven project and therefore should be built (i.e. compiled) using maven.  You can use maven from the command line (i.e. mvn) if you have it installed separately from 
your IDE, or from within your IDE.

If building from the command line, type the following from the root directory of this project:

   mvn clean install

# Running

This application uses the Maven Shade Plugin to build a shaded jar that contains all of the project's dependencies and making it easy to run the application.

You can either run the application from within your IDE or from the command line by typing the following from the root directory of this project:

   java -jar target/TheaterSeating-1.0-SNAPSHOT.jar

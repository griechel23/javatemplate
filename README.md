# Java Server Template

This is a simple Java REST service meant to be a starting point for new
services without dealing with the ~~headache~~ fun of getting a Java server up and running from scratch. 
This repo makes some opinionated choices and comes bundled with a few dependencies:

1. Uses Java17
2. Built on the Dropwizard server framework (which utilizes the Jetty libraries)
2. Gradle for dependency management 
3. Dagger2 dependency injection
3. Immutables annotations for POJOs that de/serialize nicely 
4. JAX-RS APIs 
5. JUnit testing (I will upgrade to Jupiter and AssertJ someday)
7. Pre-wired for SQLite JDBC connections
-----------------------


### Note
This is a work in progress. While it is sufficient to run a server, there
are several unfinished aspects such as gradle tasks and testing upgrades.
--------------------------


## Getting Started

Prereqs: 
- Ensure you have Java 17 installed.
- Installing the Gradle plugin for IntelliJ is a good idea as well

### Running the server:

1. If you wish to run with a database, install and run `sqlite3 data.db`
   2. This creates a file-based database in your project, which will be ignored by git but accessible from the service
   3. To work with the existing code, run the first command in [sql.txt](./src/resources/sql.txt) to create a test table with a simple schema
2. In a new terminal window, run in root directory of this project: `./gradlw run`
3. To test without data, `curl http://localhost:8080/ping`
4. To test with data, `curl http://localhost:8080/ping/<id>`
   5. Note that this will only work if you've created a db and table in step 1, and inserted data with the same ID in the path param

                                        Spring MVC Weather Application
                                        ------------------------------

Pre-Requisites:
--------------

Java 1.7
Tomcat Installation locally preferably 7.x

Note:
----

Gradle build system is used to build this project. The Gradle Wrapper is the preferred way of starting a Gradle build.
The wrapper is a batch script on Windows (gradlew.bat), and a shell script for other operating systems (gradlew). When
you start a Gradle build via the wrapper, Gradle will be automatically downloaded and used to run the build. So there is
no need for local installation of Gradle.

If gradlew is run for the first time on your machine it will take some time to fetch Gradle from the Gradle repository
and add it to your class path and then run your task.

Deployment Instructions:
-----------------------

1. Clone the project to your workspace from Git.

2. Navigate to weather-app/build.gradle and update the tomcat local installation path to the Cargo Local closure. Please
   refer examples provided in the comments and save it.

3. If using windows use (./gradlew.bat or just gradlew.bat) and if other OS, use (./gradlew or gradlew)

4. From the root folder of your project (weather-app) execute the following targets.

   a) gradlew tasks (Lists all the available tasks)

   b) Based on your preferred IDE editor of choice you can run gradlew idea to export the project into Intelli-J or
      gradlew eclipse for eclipse project builds.

   c) gradlew build (compiles sources, test sources and runs all the unit tests and generates the war). Once this target
      completes, a build directory will be created and the war is available at weather-app/build/libs and the Unit test
      results are available at weather-app/build/reports/tests/index.html.

   d) gradlew cargoRunLocal (Deploys the war to your local tomcat instance and starts tomcat). Press Ctrl-C to stop
      the container...

5. Once you see this message on the commandline "Press Ctrl-C to stop the container...", the server is up and running.
   From your browser execute the following URL: http://localhost:8080/weather-app/weather/ or
   http://<hostname>:8080/weather-app/weather/

6. There is also a target to run unit tests alone which is gradlew test
# Automation Testing for swagger UI

This project is aimed at automating API testing using Rest Assured and Cucumber framework with BDD (Behavior-Driven Development) methodology. 
This README file will guide you through setting up and running the tests.

## Prerequisites

- Java Development Kit (JDK) installed
- Maven installed
- Git installed
- Your preferred IDE (IntelliJ IDEA, Eclipse, etc.)

## Steps

open git bash on the project directory then run command 
```
git clone https://github.com/Heba13/API-Swagger-UI.git
```
Run "ChargingRunner" file in path "src/test/java/swagger/test/ChargingRunner.java"

## Project Structure
- src/test/java/swagger/test: Contains Java files for implementing test cases.
- src/test/resources: Contains Schema file written in jSON "schema.json" .
- src/test/java/swagger/endpoint: Contains Api classes and step definition implementation using Rest assured library.
- pom.xml: Maven project configuration file containing dependencies and plugins.
- .github/workflows contains main.yml for run action on git hub and generate test-report.txt
- 

- ## Test Reporting
  Test reports are generated automatically after running "ChargingRunner" file.
  You can find the HTML report in the "reports" directory.
  Open Charging-Report.html in a web browser to view the test report.

- ## Media 
- https://drive.google.com/file/d/13lUfUFDKznwUVgA0jhc_L44jrf3Jm0OT
- 


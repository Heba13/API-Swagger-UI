# Automation Testing for stripe

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
git clone https://gitlab.com/vodafone11/stripe.git
```
Run "TestNG" file in project path

## Project Structure
- src/test/java/stripe/test: Contains Java files for implementing test cases.
- src/test/resources: Contains Schema file writen in jSON "schema.json" .
- src/test/java/stripe/endpoint: Contains Api classes and step definition implementation using Rest assured library.
- src/test/java/stripe/utilities/extentReport: Contains ExtentReport configuration files.
- pom.xml: Maven project configuration file containing dependencies and plugins.
- testNG.xml file : testNg xml file 

- ## Test Reporting
  Test reports are generated automatically after running "testNG" file.
  You can find the HTML report in the "reports" directory.
  Open Charging-Report.html in a web browser to view the test report.

- ## Media 
- orangeHr Report - video.mp4 in path "reports" attached for tests record 


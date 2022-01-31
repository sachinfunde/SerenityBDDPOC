
# Getting started with REST API testing with Serenity and Cucumber 6

This is a simple starter project for Serenity with Cucumber 6 and RestAssured.

Tests are written using a combination of SerenityBDD, RestAssured, Cucumber.
Tests run with  Junit & Maven.



## Technology Stack

- Java
- RestAssured
- Serenity BDD
- Cucumber
- JUnit
- Maven

## Prerequisites

* [Java 1.8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java Dev Kit
* [Maven](https://maven.apache.org/download.cgi) - Dependency Manager
## The Project Directory Structure
The project follows the standard directory structure used in most Serenity projects:

```   
src
  + test
    + java                          
      + ResponseExtraction                  
      + Stepdefinitions             
      + Tests
      + Utils             
    + resources
      + features                  Feature files
      + testData

```



### Installation and Test Execution
Following instructions will help you running the project.

First, clone this project locally on your machine from the "main" branch.

Open the project in any IDE Eclipse/IntelliJ. Run the following command in Terminal and build the project. It will automatically download all the required dependencies.

```
$ mvn clean install
```
### Execute Tests

Run the following command in Terminal to execute tests.

We must connect to VPN of Wizink

```sh
$ mvn clean verify
```
### Test Report

You can find the Serenity reports in the following directory of the Project.

```sh
/target/site/serenity/
```

In the serenity directory, open "index.html" file to view the report.

## Want to learn more?

For more information about Serenity BDD, you can read the [**Serenity BDD Book**](https://serenity-bdd.github.io/theserenitybook/latest/index.html), the official online Serenity documentation source. Other sources include:
* **[Byte-sized Serenity BDD](https://www.youtube.com/channel/UCav6-dPEUiLbnu-rgpy7_bw/featured)** - tips and tricks about Serenity BDD
* [**Serenity BDD Blog**](https://johnfergusonsmart.com/category/serenity-bdd/) - regular articles about Serenity BDD
* [**The Serenity Dojo**](https://www.serenity-dojo.com) - Tailored BDD and Test Automation Training and Mentoring

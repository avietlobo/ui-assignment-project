# seleniumJava
Selenium Startup Project for Java

<img width="960" alt="framework" src="https://user-images.githubusercontent.com/35001674/173242942-4a528519-a633-4240-bae7-cc3a6d2fb4d5.png">

# Introduction
This project is made for anyone who is looking for a starting point for writing functional tests using Selenium WebDriver and Java.

This project was written using IntelliJ IDEA Community Edition.

# Project Packages
*  Pages:
Contains class files for each web page being tested. Page element definitions / mappings, and functions for interacting with page elements.

* Utils:
Contains helper function to read property file, number utils and config loader

* factory:
Contains driver factory to instantiate appropriate browser type.

# Maven Java Project / Maven Wrapper

This project is written in Java and tests can be executed using Maven commands.

`./mvnw clean install`

# Page Object Model

Page object model is used in this framework. Each web page will have its own java.class and within each class contains page element mappings and functions / methods used to interact /verify a specific web page under test.

# Selenium WebDriver
This project is configured to use Firefox & Chrome WebDriver's. The default is set to Chrome.





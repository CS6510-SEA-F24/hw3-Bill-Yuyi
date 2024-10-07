[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/WBsLM5qE)

# Binary Tree Library

A Java implementation of a Binary Tree data structure. This library provides functionality to:

- Validate whether the tree is a Binary Search Tree (BST).
- Calculate the maximum depth of the tree.
- Find the maximum value in the tree.
- Perform basic operations such as inserting nodes to the left or right.

## Table of Contents

1. [Prerequisites](#prerequisites)
2. [Build Instructions](#build-instructions)
3. [Running Tests](#running-tests)
4. [Generating Reports](#generating-reports)
5. [Using the JAR as a Dependency](#using-the-jar-as-a-dependency)

---

## Prerequisites

- **Java 17** or higher
- **Gradle** (or use the provided `./gradlew` wrapper)
- **Git** (for cloning the repository)

---

## Build Instructions

This project uses **Gradle** as the build tool for compiling, packaging, and testing the code.

### Step 1: Clone the Repository

```bash
git clone https://github.com/CS6510-SEA-F24/hw3-Bill-Yuyi.git
```

### Step 2: Build the project
To compile the source code and package it into a JAR file, run:
```bash
./gradlew build
```
The compiled JAR file will be located in the build/libs/ directory.


## Running Tests
To execute all unit tests, run:
```bash
./gradlew test
```

## Generating Reports
### Code Coverage Report(Jacoco)
To generate a code coverage report using Jacoco, run:
```bash
./gradlew jacocoTestReport
```
The report will be available at /build/jacocoHtml/index.html

### Code Style Report(Checkstyle)
To check the code style against the Google Java Style Guide using Checkstyle, run:
```bash
./gradlew checkstyleMain checkstyleTest
```
Reports will be available at:

Main code: build/reports/checkstyle/main.html

Test code: build/reports/checkstyle/test.html

## Using the JAR as a Dependency
### Using with Gradle
Add the following to your `buld.gradle` file
```groovy
repositories {
    mavenCentral()
}

dependencies {
    implementation 'io.github.Bill-Yuyi:binary-tree-library:0.1.0'
}
```

### Using with Maven
```xml
<dependency>
    <groupId>io.github.Bill-Yuyi</groupId>
    <artifactId>binary-tree-library</artifactId>
    <version>0.1.0</version>
</dependency>
```




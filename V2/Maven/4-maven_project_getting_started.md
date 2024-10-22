
# Getting Started with Maven: Project Structure and `pom.xml`

## 1. Maven Project Structure from Scratch

When creating a Maven project, it's essential to follow a standard directory structure. Below are the steps to set up a basic Maven project from scratch:

### Steps to Create the Maven Project Structure:

```bash
mkdir hello-maven
cd hello-maven/
code .                     # Open the project in your preferred code editor
touch pom.xml              # Create the POM file
mkdir -p src/main/java      # Create the source code directory
cd src/main/java/
mkdir -p com/i27academy/devops  # Create the package directories
cd com/i27academy/devops/
touch utils.java helloworld.java  # Create the Java files
```

### Sample Java Files:

1. **`utils.java`:**
    ```java
    package main.java.com.i27academy.devops;

    public class Utils {
        public String getName() {
            return "DevOps with Siva";
        }
    }
    ```

2. **`helloworld.java`:**
    ```java
    package main.java.com.i27academy.devops;

    class HelloWorld {
        public static void main(String[] args) {
            System.out.println("Hello World!!!");
        }
    }
    ```

---

## Maven Project Directory Structure:
Maven enforces a standardized directory structure for projects:

- **Source Code**: `${basedir}/src/main/java`
- **Resources**: `${basedir}/src/main/resources`
- **Test Code**: `${basedir}/src/test`
- **Compiled Classes**: `${basedir}/target/classes`
- **Packaged Artifacts**: `${basedir}/target`

*Note*: `${basedir}` refers to the root directory of your project.

---

## 2. `pom.xml` File: Key Components

The `pom.xml` file (Project Object Model) is the core of a Maven project. It defines the project and handles dependencies, plugins, and configurations required for the build process.

### Sample `pom.xml`:
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.i27academy.devops</groupId>
    <artifactId>hello-maven</artifactId>
    <version>1.0-SNAPSHOT</version>
</project>
```

### Explanation of Key Components:
- **`<project>`**: The root element of the POM file.
- **`<modelVersion>`**: Defines the POM model version. Always set to `4.0.0` for Maven 2+.
- **`<groupId>`**: The group or organization that the project belongs to (e.g., `com.i27academy.devops`).
- **`<artifactId>`**: The project's unique identifier (e.g., `hello-maven`).
- **`<version>`**: The current version of the project (e.g., `1.0-SNAPSHOT` for ongoing development).

---

## 3. Create a Maven Project in Less Than 5 Minutes

Maven allows you to quickly generate a new project using **archetypes**, which are project templates. You can use the Maven command below to create a new project:

### Create a Sample Maven Project Using Archetypes:
```bash
mvn archetype:generate -DgroupId=com.i27academy.app -DartifactId=my-maven-app \
-DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
```

This command will:
- **Generate a new Maven project** based on the quickstart archetype.
- Set the `groupId` to `com.i27academy.app`.
- Create the project with `artifactId` as `my-maven-app`.

### Build and Package the Project:
After generating the project, you can compile and package it with Maven using the following commands:

1. **Compile the project:**
    ```bash
    mvn compile
    ```

2. **Package the project into a JAR file:**
    ```bash
    mvn package
    ```

---

With these steps, you can create and set up a basic Maven project, define the `pom.xml` file, and build your project in under 5 minutes. This guide is a foundation for understanding Maven and its project structure. More advanced configurations, dependencies, and plugins can be explored as you progress.


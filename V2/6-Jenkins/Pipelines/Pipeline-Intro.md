## **Jenkins Pipeline - Introduction**

### What is a Jenkins Pipeline?

A **Jenkins Pipeline** is a suite of plugins that supports **integrating and implementing continuous delivery (CD)** workflows.

* It allows you to define the entire build/test/deploy lifecycle as **code**.
* Uses a **Domain-Specific Language (DSL)** based on **Groovy**.
* Stored in a file named `Jenkinsfile`.

---

### Types of Jenkins Pipelines

1. **Declarative Pipeline**

   * Simplified and structured syntax.
   * Easy to read and maintain.
   * Starts with `pipeline {}` block.

2. **Scripted Pipeline**

   * Uses full Groovy scripting.
   * More flexible and powerful, but harder to maintain.
   * Starts with `node {}` block.

---

### Why Use Pipelines?

* Code versioning of CI/CD process.
* Reusability and modularity.
* Better visibility and traceability.
* Supports complex workflows.

---

### Jenkinsfile

* File used to define the pipeline code.
* Stored in the root directory of the project repository.
* Syntax can be declarative or scripted.

---

### Basic Structure of a Declarative Pipeline

```groovy
pipeline {
  agent any

  stages {
    stage('Build') {
      steps {
        echo 'Building...'
      }
    }

    stage('Test') {
      steps {
        echo 'Testing...'
      }
    }

    stage('Deploy') {
      steps {
        echo 'Deploying...'
      }
    }
  }
}
```

### Basic Structure of a Scripted Pipeline
```groovy
node {
  stage('Build') {
    echo 'Building the application...'
    // build commands go here
  }

  stage('Test') {
    echo 'Running tests...'
    // test commands go here
  }

  stage('Deploy') {
    echo 'Deploying the application...'
    // deploy commands go here
  }
}

```

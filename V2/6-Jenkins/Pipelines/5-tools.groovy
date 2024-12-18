pipeline {
    agent {
        label 'java-slave'
    }
    tools {
        maven 'Maven-3.8.8' // the same name should be configured under tools section
    }
    stages {
        stage ("Maven") {
            steps {
                echo 'Hello, welcome to Maven section'
                sh 'mvn --version'
            }
        }
        stage ("cartmaven") {
            // this tool section , will take presedence
            tools {
                jdk 'JDK-17'
            }
            steps {
                echo 'Hello, welcome to CartMaven section'
                sh 'mvn --version'
            }
        }
    }
}
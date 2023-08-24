// tools will be under manage jenkins > tools 
// configure your packages based on the requirement 
pipeline {
    agent any 
    tools {
        maven 'Maven_AutoInstaller'
    }
    stages {
        stage ("maven") {
            steps {
                echo "Hello !!, welcome to Tools section"
                sh 'mvn --version'
                // mvn > 11 jdk
            }
        }
        stage ('NewMaven') {
            tools {
                jdk 'JDK17'
            }
            steps {
                echo "printing other maven with custom jdk"
                sh "mvn --version"
                // mvn > 17 jdk
            }
        }
    }
}
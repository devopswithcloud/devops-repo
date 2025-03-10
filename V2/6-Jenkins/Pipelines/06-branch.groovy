// syntax 
// Sample Pipeline
pipeline {
    agent any
    stages {
        stage ('Build') {
            steps {
                echo "Build Pipleline"
            }
        }
        stage ('Scans') {
            steps {
                echo "Scans Pipleline"
            }
        }
        stage ('dockerbuild') {
            steps {
                echo "Docker Pipleline"
            }
        }
        stage ('devdeploy') {
            steps {
                echo "dev Pipleline"
            }
        }
    }
}
pipeline {
    agent any
    options {
        timestamps()
    } 
    stages {
        stage ('Build') {
            steps {
                echo "Hello world!!!!"
            }
        }
        stage ('Test') {
            steps {
                echo "Testing stage executing"
            }
        }
    }
}
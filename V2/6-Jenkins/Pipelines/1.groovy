// syntax 
// Sample Pipeline
pipeline {
    agent any
    stages {
        stage ('FirstStage') {
            steps {
                echo "First Pipleline"
            }
        }
    }
}
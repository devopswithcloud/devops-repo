pipeline {
    agent any 
    environment {
        course = "Docker and K8S"
        name = "Siva"
    }
    stages {
        stage ("FirstStage") {
            environment {
                cloud = "GCP"
            }
            steps {
                echo "Welcome ${name}"
                echo "You Enrolled for ${course}"
                echo "You are certified in ${cloud} Cloud"
            }
        }
        stage ('SecondStage') {
            steps {
                echo "Welcome ${name}"
                echo "You Enrolled for ${course}"
                echo "You are certified in ${cloud} Cloud"
            }
        }
    }
}

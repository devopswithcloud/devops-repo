// environemnt values in stage will take presendence compared to pipeline

pipeline {
    agent any 
    environment {
        course = "Docker and K8S"
        name = "Siva"
    }
    stages {
        stage ("FirstStage") {
            environment {
                name = "Krish"
                cloud = "GCP"
            }
            steps {
                echo "Welcome ${name}"
                echo "You Enrolled for ${course}"
                echo "You are certified in ${cloud} Cloud"
                sh 'printenv'
            }
        }
    }
}

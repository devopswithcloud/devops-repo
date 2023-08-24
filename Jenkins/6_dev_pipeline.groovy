pipeline {
    agent none 
    stages {
        stage ('build'){
            steps {
                echo "build"
            }
        }
        stage ('sonar'){
            steps {
                echo "sonar scans"
            }
        }
        stage ('deploy'){
            steps {
                echo "deployed to kubernetes"
            }
        }
    }
}
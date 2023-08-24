// parallel stages
pipeline {
    agent any 
    stages {
        stage ('Build'){
            steps {
                echo "Building maven application"
            }
        }
        stage ('Scans'){
            failFast true
            parallel {
                stage ('Sonar') {
                    steps {
                        echo "***** Performing Sonar Scans*****"
                        sleep 10
                    }
                }
                stage ('Fortify') {
                    steps {
                        echo "***** Performing Fortify Scans"
                        error "Trying to recreate error message"
                        sleep 10
                    }
                }
                stage ('Trivy') {
                    steps {
                        echo "***** Performing container Scans"
                        sleep 10
                    }
                }
            }
        }
        stage ('Deploy') {
            steps {
                echo "Deploying to env"
            }
        }
    }
}
pipeline {
    agent any 
    stages {
        stage ('Build') {
            options {
                retry(3)
            }
            steps {
                echo "Before Setting Current Build to Failure"
                script {
                    currentBuild.result = 'FAILURE'
                }
                echo "After Setting Current Build to Failure"
            }
        }
    }
}
//
pipeline {
    agent any 
    options {
        retry(3)
    }
    stages {
        stage ('Build') {

            tools {

            }
            steps {
                echo "Before Setting Current Build to Failure"
                script {
                    currentBuild.result = 'FAILURE'
                }
                echo "After Setting Current Build to Failure"
            }
        }
    }
}
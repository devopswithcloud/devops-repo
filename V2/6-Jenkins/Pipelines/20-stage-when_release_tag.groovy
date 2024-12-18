//allOf

pipeline {
    agent any 
    environment {
        // our own custom env variables
        DEPLOY_TO = 'xyz'
    }
    stages {
        stage ('DepoyToDev') {
            steps {
                echo "Deploying to Dev Environment"
            }
        }
        stage ('DepoyToTest') {
            steps {
                echo "Deploying to Test Environment"
            }
        }
        stage ('DeployToStage') {
            when {
                branch 'release/*'
            }
            steps {
                echo "Deploying to Stage Env"
            }
        }
        stage ('DeployToProd') {
            when {
                // vx.x.x
                tag pattern: "v\\d{1,2}\\.\\d{1,2}\\.\\d{1,2}", comparator: "REGEXP"
            }
            steps {
                echo "Deploying to Stage Env"
            }
        }
    }
}
// pipleine e2e
pipeline {
    agent any
    stages {
        stage ('Build') {
            steps {
                echo "Building the project"
            }
        }
        stage ('CodeAnalysis') {
            steps {
                echo "Running code analysis"
            }
        }   
        stage ('DockerBuildnPush') {
            steps {
                echo "Building and pushing docker image"
            }
        }
        stage ('DeployToDev') {
            steps {
                echo "Deploying to dev environment"
            }
        }
        stage ('DeployToTest') {
            steps {
                echo "Deploying to test environment"
            }
        }
        stage ('DeployToStage') {
            steps {
                echo "Deploying to stage environment"
            }
        }
        stage ('DeployToProd') {
            options {
                timout (time: 300, unit: 'SECONDS')
            }
            input {
                message "Doing prod Deployments ??????"
                ok 'yes'
                submitter 'i27academy,krishdev'
            }
            steps {
                echo "Deploying to prod environment"
            }
        }
    }
}


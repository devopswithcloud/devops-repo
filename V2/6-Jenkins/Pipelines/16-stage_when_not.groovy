pipeline {
    agent any 
    environment {
        // our own custom env variables
        DEPLOY_TO = 'production'
    }
    stages {
        stage ('ProdDeploy') {
            when {
                not {
                    equals expected:"prod" , actual: "${DEPLOY_TO}"
                }
            }
            steps {
                echo "Deploying to production"
            }
        }
    }
}
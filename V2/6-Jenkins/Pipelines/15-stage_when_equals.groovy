// when condition
// https://www.jenkins.io/doc/book/pipeline/syntax/#when
pipeline {
    agent any 
    environment {
        // our own custom env variables
        DEPLOY_TO = 'production'
    }
    stages {
        stage ('ProdDeploy') {
            when {
                equals expected: 5, actual: currentBuild.number
                // environment name: 'DEPLOY_TO', value: 'production'
            }
            steps {
                echo "Deploying to production"
            }
        }
    }
}


// not condition

// when condition
// https://www.jenkins.io/doc/book/pipeline/syntax/#when
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
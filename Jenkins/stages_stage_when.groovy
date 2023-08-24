// When Condition
pipeline {
    agent any
    environment {
        //course = "GCP"
        DEPLOY_TO = 'productions'
    }
    stages {
        stage("When Example") {
            when {
                environment name: 'DEPLOY_TO', value: 'production'
            }
            steps {
                echo "Deploying in Jenkins"
            }
        }
    }
}

// not condition
pipeline {
    agent any
    environment {
        //course = "GCP"
        DEPLOY_TO = 'productions'
    }
    stages {
        stage("When Example") {
            when {
                not {
                    equals expected: "productions", actual: "${DEPLOY_TO}"
                }    
            }
            steps {
                echo "Deploying in Jenkins"
            }
        }
    }
}

// branches production 
pipeline {
    agent any
    stages {
        stage("When Example") {
            when {  
                expression {
                    BRANCH_NAME ==~ /(production|staging)/
                }
            }
            steps {
                echo "Deploying in Jenkins"
            }
        }
        stage ('SecondStage') {
            steps {
                echo "Execute , irrespsctive of the condition"
            }
        }
    }
}

// when > one conditon, 
// multi conditions with and based ====> allOf
// multiple condition with or based ====> anyOf

pipeline {
    agent any
    environment {
        DEPLOY_TO = 'production'
    }
    stages {
        stage("When Example") {
            when {  
                allOf {
                    branch 'production'
                    environment name: 'DEPLOY_TO', value: 'production'
                }
            }
            steps {
                echo "All conditions satisfied"
            }
        }
        stage ('SecondStage') {
            steps {
                echo "Execute , irrespsctive of the condition"
            }
        }
    }
}
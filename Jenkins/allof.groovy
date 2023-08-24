//allOf
pipeline {
    agent any 
    environment {
        DEPLOY_TO = "siva" // static , hard
    }
    stages {
        stage ('Example Build') {
            steps {
                echo "Build stage!!!!!!"
            }
        }
        stage ('Deploy') {
            when {
                allOf {
                    branch 'production'
                    environment name: 'DEPLOY_TO', value: 'siva'
                }
            }
            steps {
                echo "Deploying in Prod environment"
            }
        }
    }
}

//anyOf
pipeline {
    agent any 
    environment {
        DEPLOY_TO = "siva" // static , hard
    }
    stages {
        stage ('Example Build') {
            steps {
                echo "Build stage!!!!!!"
            }
        }
        stage ('Deploy') {
            when {
                anyOf {
                    expression {
                        BRANCH_NAME ==~ /(production|staging)/
                    }
                    environment name: 'DEPLOY_TO', value: 'siva'
                }
            }
            steps {
                echo "Deploying in Prod environment"
            }
        }
    }
}

//buildingTag
pipeline {
    agent any 
    environment {
        DEPLOY_TO = "siva" // static , hard
    }
    stages {
        stage ('Example Build') {
            steps {
                echo "Build stage!!!!!!"
            }
        }
        stage ('Deploy') {
            when {
                anyOf {
                    expression {
                        BRANCH_NAME ==~ /(production|staging)/
                    }
                    environment name: 'DEPLOY_TO', value: 'siva'
                }
            }
            steps {
                echo "Deploying in nonprod environment"
            }
        }
        stage ('prod'){
            when {
                buildingTag()
            }
            steps {
                echo "Deploying to prod Kubernetes cluster"
            }
        }
    }
}

//tag
pipeline {
    agent any 
    environment {
        DEPLOY_TO = "siva" // static , hard
    }
    stages {
        stage ('Example Build') {
            steps {
                echo "Build stage!!!!!!"
            }
        }
        stage ('Deploy') {
            when {
                anyOf {
                    expression {
                        BRANCH_NAME ==~ /(production|staging)/
                    }
                    environment name: 'DEPLOY_TO', value: 'siva'
                }
            }
            steps {
                echo "Deploying in nonprod environment"
            }
        }
        stage ('prod'){
            when {
                //changeRequest() ===> PR's only
                //buildingTag()
                // buildingTag will execute when we are building a tag
                // tag will execute only when we are executign a specfic pattern
                //tag "release-*"
                //vx.x.x v1.2.3
                tag pattern: "v\\d{1,2}.\\d{1,2}.\\d{1,2}", comparator: "REGEXP"
            }
            steps {
                echo "Deploying to prod Kubernetes cluster"
            }
        }
    }
}


// Docker build and push 
pipeline {
    agent {
        label 'java-slave'
    }
    environment {
        DOCKER_CREDS = credentials('i27devopsb4_dockerhub_creds') // username and passowrd
        DOCKER_REPO = 'i27devopsb4/nginx'
    }
    stages {
        stage('DockerBP'){
            steps {
                //nginx pull, change the name to myownname and push to my registry 
                sh "docker pull nginx"
                echo "********************* Printing images Before changing the tag ******************"
                sh "docker images"
                sh "docker tag nginx i27devopsb4/nginx:b5"
                echo "********************* Printing images After changing the tag ******************"
                sh "docker images"
                echo "********************* Docker Login *********************"
                sh "docker login -u ${DOCKER_CREDS_USR} -p ${DOCKER_CREDS_PSW}"
                echo "********************** Pushing the Image to Repo ******************"
                sh "docker push ${DOCKER_REPO}:b5"
            }
        }
    }
}
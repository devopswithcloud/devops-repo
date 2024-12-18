// any: Execute the pipeline or stage on any avaiable agent 
// label: This is a string, which inform jenkisn to run this pipleline or stage on a particular agent

pipeline {
    agent {
        label 'java-slave' // this should be configured in the slave section
    }
    stages {
        stage ("Build") {
            steps {
                echo "Hello Workd!!!!"
            }
        }
        stage ('Docker') {
            agent 'docker-slave'
            steps {
                echo "Running on Docker slave"
                sh "docker build -t siva:v1 ."
            }
        }
    }

}

// node agent

pipeline {
    agent none 
    stages {
        stage ("Build") {
            agent {
                node {
                    label 'java-slave'
                    customWorkspace "/home/siva/customwork"
                }
            }
            steps {
                echo "Hello World!!!!!"
                sh 'cat siva.txt'
            }
        }
    }
}
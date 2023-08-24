// agent > any 
// agent > none
// agent label

pipeline {
    agent none 
    stages {
        stage ('Welcome'){
            steps {
                echo "Welcome to jenkins Pipleine Mastery"
            }
        }
    }
}

// agent with a specific slave
pipeline {
    agent {
        label 'node-slave'
    } 
    stages {
        stage ('Welcome'){
            steps {
                echo "Welcome to jenkins Pipleine Mastery"
                sh 'hostname -i' // this should print the private ip
            }
        }
        stage ('SecondStage'){
            agent {
                label 'java-slave'
            }
            steps {
                echo "Printing in Java Slave"
                sh 'hostname -i'
            }
        }
    }
}

// agent with node 
pipeline {
    agent {
        node {
            label 'java-slave' // /home/siva/
            customWorkspace '/home/siva/my-custom'
        }
    }
    stages {
        stage ('Welcome to slave'){
            steps {
                echo "Welcome to slave"
                sh 'hostname -i'
            }
        }
        stage ('clone'){
            steps {
                //script 
                git branch: 'main', url: 'https://github.com/devopswithcloud/KubernetesRepo.git'
            }
        }
    }
}
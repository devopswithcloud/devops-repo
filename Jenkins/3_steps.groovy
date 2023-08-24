// steps 
// script allows us to write some cusotm code in groovy 
// it will help us to make some complex environments in the complete pipleline 
// Script block will be considering as a groovy programming language

pipeline {
    agent any 
    stages {
        stage ('hello'){
            steps {
                echo "hello !!!!"
            }
        }
        stage ('sricptstage'){
            steps {
                script {
                    def course = "k8s"
                    if (course == 'k8s')
                      println("Thanks for enrolling to ${course}")
                    else 
                      println ("Do enroll")
                    sleep 60 // seconds
                    echo "Script block ended here"
                }
            }
        }
    }
}
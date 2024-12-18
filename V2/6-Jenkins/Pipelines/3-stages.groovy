// Script block will be under steps block
// script block allows us to write custom code in groovy
// script block will be very helpfull when creating complex envronments
pipeline {
    agent any 
    stages {
        stage ('Build') {
            steps {
               echo "Hello world"
               sh 'hostname -i'
               // sh "dcoker tag siva:v1 siva:v2"
            }
        }
        stage ('groovystage') {
            steps {
                script {
                    // Variable definition
                    def course = "k8s"
                    // if condition
                    if (course == "k8s") 
                    println("Thanks for enrolling to ${course}")
                    else 
                    println("Do learn k8s")
                    sleep 10
                    echo "Script block has been executed"
                }

            }
        }
    }
}
// ${course}
// ${env.course}
// ${params.course}




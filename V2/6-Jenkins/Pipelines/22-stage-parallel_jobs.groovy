pipeline {
    agent any 
    stages {
        stage ('Build') {
            steps {
                echo "Building the application"
            }
        }
        stage ('ParallelStageScans') {
            parallel {
                stage ('Sonar') {
                    steps {
                        echo "Sonar Stage Executing"
                        sleep 10
                    }
                }
                stage ('Fortify') {
                    steps {
                        echo "Sonar Fortify Executing"
                        sleep 10
                    }
                }
                stage ('Prisma') {
                    steps {
                        echo "Sonar Prisma Executing"
                        sleep 10
                    }
                }
            }
        }
    }
}
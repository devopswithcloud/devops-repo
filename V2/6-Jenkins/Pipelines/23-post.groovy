// https://www.jenkins.io/doc/book/pipeline/syntax/#post
pipeline {
    agent any 
    stages {
        stage ('Build') {
            steps {
                 echo "Building the application"
            }

        }
    }
    post {
        // Only Run this , when the currennt pipleline or stage has a success status
        success {
            echo "Post =======> Success is triggered"
        }
        // Only runs when the current pipeline or stage is having a failure status
        failure {
            echo "Post =======> Failure got triggered"
        }
        // This will run irrespective of failure or succes....meaning everytime
        always {
            //block 
            echo "post ========> ALways got triggered"
        }

    }
}
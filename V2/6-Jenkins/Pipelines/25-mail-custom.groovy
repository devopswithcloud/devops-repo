// Send a mail based on the status of the job 

pipeline {
    agent any 
    stages {
        stage ('Build') {
            steps {
                echo "Testing Mail Post job"
            }
        }
    }
    post {
        always {
            script {
                // mail bcc: '', body: 'Build is Success', cc: '', from: '', replyTo: '', subject: 'Jenkins Job Status', to: 'i27k8s10@gmail.com'
                def subject = "Job Status is: ${currentBuild.currentResult}"
                def body = "Build Number is: ${currentBuild.number}\n" + "Status is: ${currentBuild.currentResult}\n" + "Job URL: ${env.BUILD_URL}"
                mail (
                    to 'i27k8s10@gmail.com',
                    subject subject
                    body body
                    )
            }
        }
    }
}

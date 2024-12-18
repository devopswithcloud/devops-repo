// Send a mail based on the status of the job 

pipleline {
    agent any 
    stages {
        stage ('Build') {
            steps {
                echo "Testing Mail Post job"
            }
        }
    }
    post {
        success {
            mail bcc: '', body: 'Build is Success', cc: '', from: '', replyTo: '', subject: 'Jenkins Job Status', to: 'i27k8s10@gmail.com'
        }
    }
}
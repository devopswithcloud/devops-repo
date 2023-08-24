pipeline {
    agent any
    stages {
        stage ('Build') {
            steps {
                timeout (time: 300, unit: 'SECONDS') {
                    input message: "Do you like to build", ok: "yes", submitter: 'maha'
                } //abort
                echo "Building the application"
            }
        }
    }
}
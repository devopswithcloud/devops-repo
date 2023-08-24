pipeline {
    agent any 
    stages {
        stage ('build'){
            steps {
                retry (3) {
                    echo "Welcome to jenkins"
                    // error "testing retry"
                }
                echo "After retry block"
            }
        }
    }
}
// timeout 
pipeline {
    agent any 
    stages {
        stage ('Build') {
            steps {
                timeout (time: 5, unit: 'SECONDS'){
                    echo "Sleeping for 60 seconds" // Minutes is default for timeout
                    sleep 60
                }
            }
        }
    }
}
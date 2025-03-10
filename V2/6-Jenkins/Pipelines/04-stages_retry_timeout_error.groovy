// https://www.jenkins.io/doc/pipeline/steps/workflow-basic-steps/#pipeline-basic-steps
// retry, error, timeout 
pipeline {
    agent any 
    stages {
        stage ('Build') {
            steps {
                retry(3) {
                    echo "Welcome to Jenkins Pipeline"
                    error "Test this for retry block"
                }
            echo "After 3 retrys"
            }
        }
    }
}


// Timeout
pipeline {
    agent any
    stages {
        stage ('Build') {
            steps {
                timeout (time: 5, unit: 'SECONDS') // alues: NANOSECONDS, MICROSECONDS, MILLISECONDS, SECONDS, MINUTES, HOURS, DAYS
                {
                    echo "Sleeping for 60 Seconds"
                    sleep 60
                    // siva input ====. yes | no
                }

            }
        }
    }
}
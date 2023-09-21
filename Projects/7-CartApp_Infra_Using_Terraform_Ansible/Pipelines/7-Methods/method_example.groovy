pipeline {
    agent any 
    stages {
        stage ('Build') {
            steps {
                script {
                    test('Siva').call()
                }
            }
        }
    }
}


def test(name) {
    return {
        echo "Hello Mr ${name}"
    }
}




// Shard Libraries
// src/com/i27/utils/build.groovy

// vars/pipeline.groovy
// Jenkins ===> import the build.groovy
pipeline {
    agent any 
    environment {
        course = "Devops mastery"
        name = "Siva" //rahul
    }
    stages {
        stage ('Build') {
            environment {
                cloud = "GCP"   
            }
            steps {
                echo "Welcome ${name}"
                echo "You enrolled for ${course} course"
                echo "You are certified in ${cloud} course"
            }
        }
    }
}
// second example
pipeline {
    agent any 
    environment {
        course = "Devops mastery"
        name = "Siva" 
    }
    stages {
        stage ('Build') {
            environment {
                cloud = "GCP"   
            }
            steps {
                echo "Welcome ${name}"
                echo "You enrolled for ${course} course"
                echo "You are certified in ${cloud} course"
            }
        }
        stage ('secondstage'){
            steps {
                echo "Welcome ${name}"
                echo "You enrolled for ${course} course"
                echo "You are certified in ${cloud} course"
            }
        }
    }
}

// presedence
pipeline {
    agent any 
    environment {
        course = "Devops mastery"
        name = "Siva" 
    }
    stages {
        stage ('Build') {
            environment {
                name = "maha" // presedence
                cloud = "GCP"
            }
            steps {
                echo "Welcome ${name}"
                echo "You enrolled for ${course} course"
                echo "You are certified in ${cloud} course"
            }
        }
    }
}

//printenv
pipeline {
    agent any 
    environment {
        course = "Devops mastery"
        name = "Siva" 
    }
    stages {
        stage ('Build') {
            environment {
                name = "maha" // presedence
                cloud = "GCP"
            }
            steps {
                echo "Welcome ${name}"
                echo "You enrolled for ${course} course"
                echo "You are certified in ${cloud} course"
                // execute a linux and windows 
                // linux == sh
                // windows === bat
                sh "printenv"
            }
        }
    }
}

// Credentials
pipeline {
    agent any 
    environment {
        course = "Devops mastery"
        name = "Siva" 
    }
    stages {
        stage('Build') {
            environment {
                GITHUB_CREDS = credentials('github_siva_credentials') //id
            }
            steps {
                echo "Github Credentials arr ${GITHUB_CREDS}"
                echo "UserId is: ${GITHUB_CREDS_USR}"
                echo "password is: ${GITHUB_CREDS_PSW}"
            }
        }
    }
}

// Seperated
withCredentials([usernamePassword(credentialsId: 'github_siva_credentials', passwordVariable: 'USER_PASSWORD', usernameVariable: 'USER_NAME')]) {
    // some block
    userename ==> USER_NAME // devopswithcloud
    password ==> USER_PASSWORD //password
    curl -u -v ${USER_NAME}:${USER_PASSWORD} 
}

withCredentials([usernameColonPassword(credentialsId: 'github_siva_credentials', variable: 'CONJ_CREDS')]) {
    // some block
    CONJ_CREDS ==> userid ==> ${CONJ_CREDS_USR}
    CONJ_CREDS ==> password ==> ${CONJ_CREDS_PSW}
}
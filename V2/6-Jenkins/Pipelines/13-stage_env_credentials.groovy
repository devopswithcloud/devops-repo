pipeline {
    agent any 
    stages {
        stage ('Build') {
            environment {
                // This directive supports a special helper method credentials() 
               GITHUB_CREDS = credentials('i27devopsb2_git_creds') // username and passwd
               SONAR_CREDS = credentials('sonar_creds')
            }
            steps {
                echo "My Github Credentials are ${GITHUB_CREDS}"
                echo "My UserName is: ${GITHUB_CREDS_USR}"
                echo "My Password is: ${GITHUB_CREDS_PSW}"
                // mvn sonar:sonar -D ${SONAR_CREDS}
            }
        }
    }
}


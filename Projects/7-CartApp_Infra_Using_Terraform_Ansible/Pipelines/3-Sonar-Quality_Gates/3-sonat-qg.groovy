// Test file
pipeline {
    agent {
        label 'maven-slave'
    } 
    tools {
        maven 'Maven-3.8.8'
        jdk 'JDK-17'
    }
    environment {
        APPLICATION_NAME = "eureka"
        SONAR_URL = "http://34.239.44.34:9000"
        // SONAR_TOKEN = "sqa_6c69015b0cd422333397142a660072ec1f4f7fca"
        SONAR_TOKEN = credentials('sonar_creds')
    }
    stages {
        stage('Build') {
            // Build happens here 
            // Only build should happen, no tests should be available
            steps {
                echo "Building the ${env.APPLICATION_NAME} application"
                // maven build should happpen here 
                sh "mvn clean package -DskipTests=true"
                archiveArtifacts artifacts: 'target/*jar', followSymlinks: false
            }
        }
        stage ('Unit Tests'){
            steps {
                echo "Performing Unit Tests for ${env.APPLICATION_NAME} application"
                sh "mvn test"
            }
        }
        stage ('sonar') {
            steps {
                echo "Starting SonarScan with quality gate"
                withSonarQubeEnv('SonarQube') {
                    sh """
                        mvn clean verify sonar:sonar \
                            -Dsonar.projectKey=i27-${env.APPLICATION_NAME} \
                            -Dsonar.host.url=${env.SONAR_URL} \
                            -Dsonar.login=${env.SONAR_TOKEN}
                    """
                }
                timeout (time: 2, unit: 'MINUTES'){ // NANOSECONDS, ****
                    script {
                        waitForQualityGate abortPipeline: true
                    }
                } 
            }
        }
    }
}


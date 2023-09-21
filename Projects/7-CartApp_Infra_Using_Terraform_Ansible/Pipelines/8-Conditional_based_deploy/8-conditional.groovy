// Test file
pipeline {
    agent {
        label 'maven-slave'
    } 
    tools {
        maven 'Maven-3.8.8'
        jdk 'JDK-17'
    }
    parameters {
        choice(name: 'sonarScans',
            choices: 'no\nyes',
            description: 'This will scan the applicaiton using sonar'
        )
        choice(name: 'buildOnly',
            choices: 'no\nyes',
            description: 'This will only build the application'
        )
        choice(name: 'dockerPush',
            choices: 'no\nyes',
            description: "This will trigger the build, docker build and docker push"
        )
        choice(name: 'deployToDev',
            choices: 'no\nyes',
            description: "This will Deploy my app to Dev env"
        )
        choice(name: 'deployToTest',
            choices: 'no\nyes',
            description: "This will Deploy my app to Test env"
        )
        choice(name: 'deployToStage',
            choices: 'no\nyes',
            description: "This will Deploy my app to Stage env"
        )
        choice(name: 'deployToProd',
            choices: 'no\nyes',
            description: "This will Deploy my app to Prod env"
        )
    }
    environment {
        APPLICATION_NAME = "eureka"
        SONAR_URL = "http://54.161.55.166:9000"
        // SONAR_TOKEN = "sqa_6c69015b0cd422333397142a660072ec1f4f7fca"
        SONAR_TOKEN = credentials('sonar_creds')
        POM_VERSION = readMavenPom().getVersion()
        POM_PACKAGING = readMavenPom().getPackaging()
        DOCKER_HUB = "docker.io/devopswithcloudhub"
        DOCKER_REPO = "i27eurekaproject"
        USER_NAME = "devopswithcloudhub" // UserID for Dockerhub
        DOCKER_CREDS = credentials('dockerhub_creds')
    }
    stages {
        stage ('Build') {
            when {
                anyOf { 
                    expression {
                        params.dockerPush == 'yes'
                        params.buildOnly == 'yes'
                    }
                }
            }
            // Build happens here 
            // Only build should happen, no tests should be available
            steps {
                script {
                    echo "Building the ${env.APPLICATION_NAME} application"
                    // maven build should happpen here 
                    sh "mvn clean package -DskipTests=true"
                    archiveArtifacts artifacts: 'target/*jar', followSymlinks: false
                }

            }
        }
        stage ('Unit Tests'){
            when {
                anyOf {
                    expression {
                        params.buildOnly == 'yes'
                        params.dockerPush == 'yes'
                    }
                }
            }
            steps {
                echo "Performing Unit Tests for ${env.APPLICATION_NAME} application"
                sh "mvn test"
            }
        }
        stage ('sonar') {
            when {
                anyOf {
                    expression {
                        params.sonarScans == 'yes'
                        params.buildOnly == 'yes'
                        params.dockerPush == 'yes'
                    }
                }
            }
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
        stage ('Docker Build and Push') {
            when {
                anyOf {
                    expression {
                        params.dockerPush == 'yes'
                    }
                }
            }
            steps {
                script  {
                    sh """
                        ls -la
                        cp ${workspace}/target/i27-${env.APPLICATION_NAME}-${env.POM_VERSION}.${env.POM_PACKAGING} ./.cicd
                        echo "listing files in .cicd folder"
                        ls -la ./.cicd
                        echo "******************** Building Docker Image ********************"
                        # docker build -t imagename .
                        docker build --force-rm --no-cache --pull --rm=true --build-arg JAR_SOURCE=i27-${env.APPLICATION_NAME}-${env.POM_VERSION}.${env.POM_PACKAGING} --build-arg JAR_DEST=i27-${env.APPLICATION_NAME}-${currentBuild.number}-${BRANCH_NAME}.${env.POM_PACKAGING} \
                            -t ${env.DOCKER_HUB}/${env.DOCKER_REPO}:$GIT_COMMIT ./.cicd
                        # Docker hub, Google Container registry, JFROG 
                        echo "******************** Logging to Docker Registry ********************"
                        docker login -u ${DOCKER_CREDS_USR} -p ${DOCKER_CREDS_PSW}
                        docker push ${env.DOCKER_HUB}/${env.DOCKER_REPO}:$GIT_COMMIT
                    """
                }
            }
        }
        stage ('Deploy to Dev') { //5761
            when {
                anyOf {
                    expression {
                        params.deployToDev == 'yes'
                    }
                }
            }
            steps {
              script {
                dockerDeploy('dev', '5761', '8761').call()
              }
            }
        }
        stage ('Deploy to Test') { //6761
            when {
                anyOf {
                    expression {
                        params.deployToTest == 'yes'
                    }
                }
            }
            steps {
              script {
                dockerDeploy('test', '6761', '8761').call()
              }
            }
        }

    }
}

def dockerDeploy(envDeploy, hostPort, contPort){    
    return {
        echo "******************** Deploying to $envDeploy Environment ********************"
        withCredentials([usernamePassword(credentialsId: 'maha_docker_vm_creds', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
            // some block
            // with this creddentials, i need to connect to dev environment 
            // sshpass
            script {
                // Test to Pull the container on the docker server
                sh "sshpass -p '$PASSWORD' -v ssh -o StrictHostKeyChecking=no $USERNAME@$docker_server_ip \"docker pull ${env.DOCKER_HUB}/${env.DOCKER_REPO}:$GIT_COMMIT\""
                //sh "sshpass -p '$PASSWORD' -v ssh -o StrictHostKeyChecking=no $USERNAME@$docker_server_ip \"***"
                echo "Stop the Container"
                // If we execute the below command it will fail for the first time,, as continers are not availble, stop/remove will cause a issue.
                // we can implement try catch block.
                try {
                    sh "sshpass -p '$PASSWORD' -v ssh -o StrictHostKeyChecking=no $USERNAME@$docker_server_ip \"docker stop ${env.APPLICATION_NAME}-$envDeploy\""
                    echo "Removing the Container"
                    sh "sshpass -p '$PASSWORD' -v ssh -o StrictHostKeyChecking=no $USERNAME@$docker_server_ip \"docker rm ${env.APPLICATION_NAME}-$envDeploy\""
                } catch(err) {
                    echo "Caught the error: $err"
                }
                // Run the container
                sh "sshpass -p '$PASSWORD' -v ssh -o StrictHostKeyChecking=no $USERNAME@$docker_server_ip \"docker run --restart always --name ${env.APPLICATION_NAME}-$envDeploy -p $hostPort:$contPort -d ${env.DOCKER_HUB}/${env.DOCKER_REPO}:$GIT_COMMIT\""
                
            }
        }
    }
}


// 8761 is the container port , we cant change it.
// if we really want to change , we can change it using -Dserver.port=9090, this will be your container port
// but we are considering the below host ports 
    // dev === > 5761
    // test ===> 6761
    // stage ===> 7761
    // prod ====> 8761

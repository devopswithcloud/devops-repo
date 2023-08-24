// 
pipeline {
    agent any
    tools {
        maven 'Maven-3.8.8'
        jdk 'JDK17'
    }
    environment {
        TOMCAT_CREDS = credentials('tomcat_credentials') // jenkins credentials
        NEXUS_VERSION = "nexus3"
        NEXUS_PROTOCOL = "http"
        NEXUS_URL = "34.125.79.139:8081"
        NEXUS_REPO = "new-repo-test"
    }
    stages {
        stage ('clone'){
            steps {
                // clone the repo, go to snippet generator
                git credentialsId: 'github_siva_credentials', url: 'https://github.com/devopswithcloud/spring3-mvc-maven-xml-hello-world.git'
            }
        }
        stage ('Build') {
            steps {
                sh "mvn clean package -Dmaven.test.failure.ignore=true"
                //-Dcheckstyle.skip
            }
            post {
                success {
                    archiveArtifacts artifacts: 'target/*.war', followSymlinks: false
                }
            }
        }
        stage ('Nexus') {
            steps {
                script {
                    pom = readMavenPom file: "pom.xml"
                    files = findFiles(glob: "target/*.${pom.packaging}")
                    // for verification, no use 
                    echo "echo ${files[0].name} ${files[0].path} ${files[0].directory} ${files[0].length} ${files[0].lastModified}"
                    // get he path location
                    artifactPath = files[0].path;
                    // validating if file exists and storing in a variable
                    artifactExists = fileExists artifactPath;
                    // echo "If artifact exists"
                    echo "${artifactExists}"
                    // code 
                    if (artifactExists){
                        // run this piece of code
                        echo "*********** Artifacts is availble, going to deploy to nexus"
                        echo "File is : ${artifactPath} , Package is: ${pom.packaging}, Version is: ${pom.version}, GroupID is: ${pom.groupId}"
                        // We need to deploy to nexus , using a plugin called as nexusArtifactUploader
                        nexusArtifactUploader (
                            nexusVersion: "$env.NEXUS_VERSION",
                            protocol: "${env.NEXUS_PROTOCOL}",
                            nexusUrl: "${env.NEXUS_URL}", // env. | params. | pipelineparams.
                            groupId: "${pom.groupId}",
                            //version: "${pom.version}",
                            version: "${BUILD_NUMBER}",
                            repository: "${env.NEXUS_REPO}",
                            credentialsId: "nexus_creds",
                                        artifacts: [
                                            [
                                                artifactId: pom.artifactId,
                                                classifier: '',
                                                file: artifactPath,
                                                type: pom.packaging
                                            ]
                                        ]
                        )

                        }
                    
                    else {
                        error "*********** ${artifactPath} is not available ***********"
                    }
                }
            }
        }
        stage ('Deploy to tomcat') {
            steps {
                // curl commands
                sh "curl -v -u ${TOMCAT_CREDS_USR}:${TOMCAT_CREDS_PSW} -T /var/lib/jenkins/workspace/allpipeline/target/spring3-mvc-maven-xml-hello-world-1.0-SNAPSHOT.war 'http://34.125.49.107:8080/manager/text/deploy?path=/spring-hello&update=true'"
            }
        }

        
    }

}


8 to add, 0 to change, 0 to destroy.

// shared libraries 
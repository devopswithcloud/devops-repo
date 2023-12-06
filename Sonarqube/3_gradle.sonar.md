## Sonar scan for Gradle Project
```bash
# clone the git repo
git clone https://github.com/GoogleCloudPlatform/cloud-ops-sandbox.git

# Switch to develop branch
git checkout develop

cd cloud-ops-sandbox/src/adservice

# To build and test the app with gradle
./gradlew installDist

# If we want to perform sonar scan for this project,
# Create a project in sonarqube >>> Get the command from there along with the existing token.

# Modify the build gradle file with sonar plugin
vi build.gradle
plugins {
  id "org.sonarqube" version "3.5.0.2730"
}

# Run the below command to perform sonarscan for gradle
./gradlew sonar   -Dsonar.projectKey=adscvc   -Dsonar.host.url=http://PUBLIC_URL_SONAR:9000   -Dsonar.login=YOUR_SONAR_TOKEN

# If we get any errors wrt java version, install jdk 11 on the machine
yum search jdk
yum install java-11-openjdk.i686 -y

# Copy the relevant java path from the below location
alternatives --config java

# Now , we got the java 11 path, passon the java to gradle command
./gradlew sonar   -Dsonar.projectKey=adscvc   -Dsonar.host.url=http://PUBLIC_URL_SONAR:9000   -Dsonar.login=YOUR_SONAR_TOKEN -Dorg.gradle.java.home=/usr/lib/jvm/java-11-openjdk-11.0.21.0.9-1.el7_9.i386

# Once the scan is perfomed , go to sonarurl and verify your results.
```

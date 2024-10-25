# Installing Sonarqube 
## Create a server on gcp 
```
gcloud compute instances create sonarqube  --zone=us-west4-b --machine-type=e2-medium  --create-disk=auto-delete=yes,boot=yes,device-name=sonarqube,image=projects/centos-cloud/global/images/centos-7-v20230615,mode=rw,size=20
```

## Install Openjdk 17, mvn 3.8.8 on Centos:
```bash
# https://techviewleo.com/install-java-openjdk-on-rocky-linux-centos/
# Install Openjdk 17
sudo yum -y install wget curl
cd /opt/
wget https://download.java.net/java/GA/jdk17.0.2/dfd4a8d0985749f896bed50d7138ee7f/8/GPL/openjdk-17.0.2_linux-x64_bin.tar.gz
tar xvf openjdk-17.0.2_linux-x64_bin.tar.gz
sudo mv jdk-17.0.2/ /opt/jdk-17/
vim ~/.bashrc
  export JAVA_HOME=/opt/jdk-17
  export PATH=$PATH:$JAVA_HOME/bin
source ~/.bashrc
echo $JAVA_HOME
java --version

# Install Maven 3.8.8
cd /opt/
# wget https://dlcdn.apache.org/maven/maven-3/3.8.7/binaries/apache-maven-3.8.7-bin.tar.gz
wget https://dlcdn.apache.org/maven/maven-3/3.8.8/binaries/apache-maven-3.8.8-bin.tar.gz
tar -xzvf apache-maven-3.8.8-bin.tar.gz
vi ~/.bashrc
  export PATH=$PATH:/opt/apache-maven-3.8.8/bin
  export M2_HOME=/opt/apache-maven-3.8.8
source ~/.bashrc
mvn --version

# For All Users
---------------------- 
vi /etc/profile
  export JAVA_HOME=/opt/jdk-17
  export PATH=$PATH:$JAVA_HOME/bin
  export PATH=$PATH:/opt/apache-maven-3.8.8/bin
  export M2_HOME=/opt/apache-maven-3.8.8

source /etc/profile
mvn --version
```

## Create a VM
```bash
gcloud compute instances create nexusserver --zone=us-west4-b --machine-type=e2-medium --create-disk=auto-delete=yes,boot=yes,device-name=sonar,image=projects/centos-cloud/global/images/centos-7-v20221206,mode=rw,size=20
```
## Installing Nexus on Centos
```bash

# Install Java 1.8
cd /opt
yum install wget -y
wget -c --header "Cookie: oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/8u131-b11/d54c1d3a095b4ff2b6607d096fa80163/jdk-8u131-linux-x64.rpm

yum install jdk-8u131-linux-x64.rpm -y

# Download Nexus 
# TO get latest version use the below url
# https://help.sonatype.com/repomanager3/product-information/download/download-archives---repository-manager-3
wget https://download.sonatype.com/nexus/3/nexus-3.45.0-01-unix.tar.gz
tar -xzvf nexus-3.45.0-01-unix.tar.gz
mv nexus-3.45.0-01 /opt/nexus

# Create a nexus user.
# Nexus is not advised to run nexus service as a root user.
# So, we are creating a  user called nexus and grant sudo access to manage nexus services.
useradd nexus

#Give the sudo access to nexus user

visudo
nexus ALL=(ALL) NOPASSWD: ALL

#Change the owner and group permissions to /opt/nexus directory
chown -R nexus:nexus /opt/nexus
chmod -R 775 /opt/nexus
#Change the owner and group permissions to /opt/sonatype-work directory.
chown -R nexus:nexus /opt/sonatype-work
chmod -R 775 /opt/sonatype-work

#Open /opt/nexus/bin/nexus.rc file and  uncomment run_as_user parameter and set as nexus user.
vi /opt/nexus/bin/nexus.rc
run_as_user="nexus"

#Create nexus as a service
ln -s /opt/nexus/bin/nexus /etc/init.d/nexus

#Switch as a nexus user and start the nexus service as follows.
sudo su - nexus

#Enable the nexus services
sudo systemctl enable nexus

#Start the nexus service
sudo systemctl start nexus
```
* Access the Nexus server from at `http://IPAddress/Hostname:8081/`

## Installing Nexus on Ubuntu
```bash
# update repo
apt update -y

# Install Java 
apt install openjdk-8-jdk -y

# Downloading java 17
cd /opt
wget https://download.java.net/java/GA/jdk17.0.2/dfd4a8d0985749f896bed50d7138ee7f/8/GPL/openjdk-17.0.2_linux-x64_bin.tar.gz
tar xvf openjdk-17.0.2_linux-x64_bin.tar.gz

# Configure Maven 
cd /opt
wget https://dlcdn.apache.org/maven/maven-3/3.8.8/binaries/apache-maven-3.8.8-bin.tar.gz
tar -xzvf apache-maven-3.8.8-bin.tar.gz

vi /etc/profile.d/maven.sh
export JAVA_HOME=/opt/jdk-17
export PATH=$PATH:$JAVA_HOME/bin
export PATH=$PATH:/opt/apache-maven-3.8.8/bin
export M2_HOME=/opt/apache-maven-3.8.8

chmod +x /etc/profile.d/maven.sh
source /etc/profile.d/maven.sh 

# Install/Configure Nexus 

# Download Nexus 
# TO get latest version use the below url
# https://help.sonatype.com/repomanager3/product-information/download/download-archives---repository-manager-3
wget https://download.sonatype.com/nexus/3/nexus-3.45.0-01-unix.tar.gz
tar -xzvf nexus-3.45.0-01-unix.tar.gz
mv nexus-3.45.0-01 /opt/nexus

# Create a nexus user.
# Nexus is not advised to run nexus service as a root user.
# So, we are creating a  user called nexus and grant sudo access to manage nexus services.
useradd nexus

#Give the sudo access to nexus user

visudo
nexus ALL=(ALL) NOPASSWD: ALL

#Change the owner and group permissions to /opt/nexus directory
chown -R nexus:nexus /opt/nexus
chmod -R 775 /opt/nexus
#Change the owner and group permissions to /opt/sonatype-work directory.
chown -R nexus:nexus /opt/sonatype-work
chmod -R 775 /opt/sonatype-work

#Open /opt/nexus/bin/nexus.rc file and  uncomment run_as_user parameter and set as nexus user.
vi /opt/nexus/bin/nexus.rc
run_as_user="nexus"

#Create nexus as a service
ln -s /opt/nexus/bin/nexus /etc/init.d/nexus

#Switch as a nexus user and start the nexus service as follows.
sudo su - nexus

#Enable the nexus services
sudo systemctl enable nexus

#Start the nexus service
sudo systemctl start nexus


# Access Nexus Repo
```

### Login to Nexus 
```bash
# Admin user password is located in 
/opt/sonatype-work/nexus3/admin.password
```

### Change Port
```bash
# vim  /opt/nexus/etc/nexus-default.properties
change the port
[root@nexusserver etc]# service nexus restart
```
s

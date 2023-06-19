## Create a Centos Machine in GCP
```bash
gcloud compute instances create tomcatnew  --zone=us-west4-b --machine-type=e2-medium  --create-disk=auto-delete=yes,boot=yes,device-name=tomcatnew,image=projects/centos-cloud/global/images/centos-7-v20230615,mode=rw,size=20
```
## Install Java 1.8 on Centos
### Oracle Java
```bash
#Login as a root user
sudo su -

##Change dir to /opt
cd /opt
yum install wget -y
wget -c --header "Cookie: oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/8u131-b11/d54c1d3a095b4ff2b6607d096fa80163/jdk-8u131-linux-x64.rpm
yum install jdk-8u131-linux-x64.rpm -y

java -version
```

## Install Tomcat 9 
* Visit here to [download](https://tomcat.apache.org/download-90.cgi) the distributions.
```bash
# download zip fole for tomcat 9
wget https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.76/bin/apache-tomcat-9.0.76.zip

# Install unzip 
yum install unzip -y

unzip apache-tomcat-9.0.76.zip
mv apache-tomcat-9.0.76/ tomcat9/

# to check the tomcat process u can use either of one 
ps -ef | grep -i java*
or
ps -ef | grep -i apache*

# To start the process, got to bin folder and execute the below command
chmod +x *
sh startup.sh 

# Verify tomcat process
ps -ef | grep -i java*

# to stop the process
sh shutdown.sh


# To start/stop the tomcat from anywhere in machine create a link using the below command 
ln -s /opt/tomcat9/bin/startup.sh /usr/bin/startTomcat
ln -s /opt/tomcat9/bin/shutdown.sh /usr/bin/stopTomcat

#now execute startTomcat to start and stopTomcat to stop from anywhere in the machine

```
* Once the tomcat is started , tomcat can be accessible at `http://ipaddress:8080` 






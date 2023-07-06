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
mv apache-tomcat-9.0.76/ /opt/tomcat9/

# to check the tomcat process u can use either of one 
ps -ef | grep -i java*
or
ps -ef | grep -i apache*

cd /opt/tomcat9/bin/
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


## Accesing tomcat 
* Once the tomcat is started , tomcat can be accessible at `http://ipaddress:8080`
* CLick on Manager, by defualt we will be getting `403`
* If we want to give acces to the manager app, perform the below steps
```bash
cd /opt/tomcat9/webapps/manager/META-INF
vi context.xml
# comment the below line 
 <!--
  <Valve className="org.apache.catalina.valves.RemoteAddrValve"
         allow="127\.\d+\.\d+\.\d+|::1|0:0:0:0:0:0:0:1" />
  -->
# Save the file and come out
```
* Try to access the manager app from ui.
* Few time it might still be havong `403`, clera the cache (ctrl+shift+delete)
* After clicking on Manage app,it is asking for Credentials, which we ahvent created till now.
* Perform the followitng steps to create a user and access through tomcat
```bash
vi /opt/tomcat9/conf/tomcat-users.xml

# add this line at the end of the file
<user username="sivaacademy" password="Devops@12345" roles="manager-gui,admin-gui"/>
```
* `manager-gui` ====> we will be having server status and manager app access
* `admin-gui`   ====> Host Manager 

* CLick on Host- Manager, by defualt we will be getting `403`
* If we want to give acces to the host-manager app, perform the below steps
```bash
cd /opt/tomcat9/webapps/host-manager/META-INF
vi context.xml
# comment the below line 
 <!--
  <Valve className="org.apache.catalina.valves.RemoteAddrValve"
         allow="127\.\d+\.\d+\.\d+|::1|0:0:0:0:0:0:0:1" />
  -->
# Save the file and come out
```
## Change Port:
* If we want to change the port of tomcat, do the following steps:
```bash
vi /opt/tomcat/conf/server.xml

modifyy port to 8085
```
* If we perform any changes in `server.xml` , we need to restart tomcat.





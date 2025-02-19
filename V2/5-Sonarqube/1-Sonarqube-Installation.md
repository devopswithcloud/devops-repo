## 1. Install OpenJDK 17

1. Navigate to the `/opt` directory and download OpenJDK 17:
   ```bash
   cd /opt
   wget https://download.java.net/java/GA/jdk17.0.2/dfd4a8d0985749f896bed50d7138ee7f/8/GPL/openjdk-17.0.2_linux-x64_bin.tar.gz
   ```

2. Extract the downloaded archive:
   ```bash
   tar xvf openjdk-17.0.2_linux-x64_bin.tar.gz
   ```

3. Move the extracted JDK to a more permanent location:
   ```bash
   sudo mv jdk-17.0.2/ /opt/jdk-17
   ```
4. Install Java on Windows [Click Here](https://www.java.com/download/ie_manual.jsp)

---

## 2. Install Maven 3.8.8

1. Download Maven 3.8.8:
   ```bash
   cd /opt
   wget https://dlcdn.apache.org/maven/maven-3/3.8.8/binaries/apache-maven-3.8.8-bin.tar.gz
   ```

2. Extract the Maven archive:
   ```bash
   tar -xzvf apache-maven-3.8.8-bin.tar.gz
   ```
---

## 3. Set Up Environment Variables

To ensure that Java and Maven are available to all users, follow these steps:

1. Open the `/etc/profile` file:
   ```bash
   sudo vi /etc/profile
   ```

2. Add the following lines at the bottom of the file:
   ```bash
   export JAVA_HOME=/opt/jdk-17
   export PATH=$PATH:$JAVA_HOME/bin
   export M2_HOME=/opt/apache-maven-3.8.8
   export PATH=$PATH:$M2_HOME/bin
   ```

3. Save the file and apply the changes:
   ```bash
   source /etc/profile
   ```

---

## 4. Verify the Installation

1. To check if Java is correctly installed, run:
   ```bash
   java -version
   ```

   - You should see output similar to:
   ```
   openjdk version "17.0.2" 2022-01-18
   OpenJDK Runtime Environment (build 17.0.2+8-86)
   OpenJDK 64-Bit Server VM (build 17.0.2+8-86, mixed mode, sharing)
   ```

2. To verify Maven installation, run:
   ```bash
   mvn --version
   ```

   - You should see output similar to:
   ```
   Apache Maven 3.8.8
   Maven home: /opt/apache-maven-3.8.8
   Java version: 17.0.2, vendor: Oracle Corporation, runtime: /opt/jdk-17
   ```

---

## 5 Installing Sonarqube 
* For historical downloads [Refer Here](https://www.sonarsource.com/products/sonarqube/downloads/historical-downloads/)
```bash
wget https://binaries.sonarsource.com/Distribution/sonarqube/sonarqube-9.9.3.79811.zip
apt install unzip -y
unzip sonarqube-9.9.3.79811.zip
mv sonarqube-9.9.3.79811 sonarqube-9.9
```
* Sonar will not be executed with `root` user
* We need to create a user called as `sonar` and start the applicaiton with that user 
```bash
useradd sonar

#visudo
sonar           ALL=(ALL)       NOPASSWD: ALL
chown -R sonar:sonar /opt/sonarqube-9.9
chmod -R 775 /opt/sonarqube-9.9

# Switch user to sonar
su - sonar
cd /opt/sonarqube-9.9
cd bin
cd linux-x86-64/
sh sonar.sh start

# To Verify status of sonarqube
sh sonar.sh status
```
* Once the installation is successful, sonarqube can be acessible at port `9000`
* Make sure your firewalls are opened (if aws its security groups, if gcp its firewalls)
* It will ask for userid/passwd.
  * By default sonarqube has created as userid as `admin` and password as `admin`
  * Popup appears to change the password. Do change it and makesure u remember the password, as its difficult to get it back.

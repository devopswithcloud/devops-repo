
# Maven and Java Installation on Ubuntu

* Follow these steps to install OpenJDK 17 and Maven 3.8.8 on an Ubuntu-based system. 
* The guide includes setting up environment variables and configuring SSH.
* Most important pointer is, for maven to be installed java is mandatory
---

## 1. Create a New User

To create a new user on your system:

```bash
sudo adduser siva
```

---

## 2. Configure SSH for Remote Access

Edit the SSH configuration file to allow password authentication and disable root login:

1. Open the SSH configuration file:
   ```bash
   sudo vi /etc/ssh/sshd_config
   ```

2. Ensure the following lines are configured correctly:
   - Disable root login:
     ```bash
     PermitRootLogin no
     ```
   - Enable password authentication:
     ```bash
     PasswordAuthentication yes
     ```

3. Restart the SSH service to apply the changes:
   ```bash
   sudo service sshd restart
   ```

---

## 3. Install OpenJDK 17

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

## 4. Install Maven 3.8.8

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

## 5. Set Up Environment Variables

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

## 6. Verify the Installation

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

## Apache Directory Structure 
* Maven s/w is not a executable file. 
* `bin` => Binary Files 
* `conf` => Configuration file, min important file called `settings.xml`
* `lib` => it contains all jar files
* `boot` => will help in runtime

## Remote_Repo_Private_jars
* Now , my developer has created a jar called as `gpt` jar, and we need to make sure that jar is been used by team internally going forward. 
* Below are the details about repos:


## Maven Repository
* Repository is a directory where all the projects jar, plugins or any other project artifacts can be stored and used by Maven only
* There are three repository types
    * local repository
    * remote repository
    * central repository

* `Local Repository` :
    * This is the folder location on the machine where maven is installed
    * Default location of local repository is (%HOME-DIR%/.m2/)
    * If we want to change the default local repository, we need to modify the settings.xml in conf folder.
        * <localRepository>/Users/siva/maven_repo_custom/</localRepository>
* `Central Repository` :
    * This is repository maintained by Maven community and it contains large number of common librarues
    * When maven does not find dependencies in the local repository it will start searching in the central repository
    * The path of central repository is: 
    * The central repository contains a lot of common libraries that can be viewed by this [url](http://search.maven.org/)

* `Remote Repository`: 
    * Maven provides a concept of remote repository which is organization own custom repository containing libraries developed and other project jars. 
    * The remote repository location can be specifed in the projects pom.xml or in the settings.xml file

## Create a repo for our org upload multip jar/war files
* Create a repo calld `siva-remoto-repo` in `maven2hosted` with policy as `mixed`


## Download artifact from mvn server to local
* As we are using gcp instances, we dont have password or pem file to get the files copied. 
* For that reason we are creating a user and with the help of scp , we copy files to local.
* Execute below steps on the machine where mvn is available and artifacts are generated
```bash
adduser siva
passwd siva
usermod -aG wheel siva
vi /etc/ssh/sshd_config
service sshd restart
cp target/my-maven-***.jar /home/siva # Change the ***.jar file name with yours
```

## Download the war/jar to local laptop using winscp or filezilla   
* Download the jar to local machine
* Below is the command for scp:
    * `scp username@ipadress:/home/siva/***.jar .`

## Upload to nexus 
* go to siva-remote-repo > upload component > 
* previous there is no option for upload, we used to use this commadn `mvn deploy:deploy-file > used to upload loacl artifact to remo repo`
* GroupID: com.sivaacademy
* ArtifactID: gpt
* Version: v1.0.0

## Sharing the repo with Devs
* Now we need to share the remote url with devs.
    * http://PUBLIC_IP_OF_NEXUS:8081/repository/siva-remoto-repo/
* Use the package in your aplicaiton by using the snippet.
```xml
<dependency>
  <groupId>com.sivaacademy</groupId>
  <artifactId>gpt</artifactId>
  <version>v1.0.0</version>
</dependency>
```
* Update the pom.xml with the above snippet under `<dependencies>` 
* try to run `mvn clean package`
    * we will get this error `[ERROR] Failed to execute goal on project my-maven-app: Could not resolve dependencies for project com.sivaacademy.app:my-maven-app:jar:2.3.1: Could not find artifact com.sivaacademy:gpt:jar:v1.0.0 in central (https://repo.maven.apache.org/maven2) ->`
    * Because it serach in maven local repo, then in maven central repo. But the gpt is not availble in central it fails. 
* we need to configure under `repositories`, before dependencies tag
```xml
<repositories>
    <repository>
        <id>nexus</id>
        <name>Siva Remote Repo</name>
        <url>http://PUBLIC_IP_OF_NEXUS:8081/repository/siva-remoto-repo/</url>
    </repository>
</repositories>
```
* execute `mvn clean package` we will get below error
    * `[ERROR] Failed to execute goal on project my-maven-app: Could not resolve dependencies for project com.sivaacademy.app:my-maven-app:jar:2.3.1: Failed to collect dependencies at com.sivaacademy:gpt:jar:v1.0.0: Failed to read artifact descriptor for com.sivaacademy:gpt:jar:v1.0.0: Could not transfer artifact com.sivaacademy:gpt:pom:v1.0.0 from/to maven-default-http-blocker (http://0.0.0.0/): Blocked mirror for repositories: [nexus (http://PUBLIC_IP_OF_NEXUS:8081/repository/siva-remoto-repo/, default, releases+snapshots)] -> [Help 1]`
* we need to include the `organization repo` in settings.xml . Use the below snippet
* make chnage in `settings.xml` under `/opt/apache-maven-3.8.8/conf/settings.xml`
```xml
<mirrors>
    <mirror>
      <id>nexus</id>
      <mirrorOf>external:http:*</mirrorOf>
      <name>Pseudo repository to mirror external repositories initially using HTTP.</name>
      <url>PUBLIC_IP_OF_NEXUS:8081/repository/siva-remoto-repo/</url>
    </mirror>
  </mirrors>
```
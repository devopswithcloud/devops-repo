## Creating a repositories
* Create a repo called `first-release` in `maven2hosted` with `release` and copy the repo.
* Create a repo called `first-snapshot` in `maven2hosted` with `snapshot` and copy the repo.

## Viewing the content in the repo
* Go to browser > browse > select the repo u want


## Configuring Nexus details 
* login to server where MVN is installed.
* Switch to jave app where you want to package.
* We need to configure nexus details in `pom.xml`
* Below is the tag for pom.xml 
```xml
<distibutionManagement>
</distibutionManagement>
```
* Below is the example to configure nexus details in pom.xml 
```xml
<distributionManagement>
    <repository>
        <id>nexus</id>  
        <name>Release Repos</name>
        <url>http://PUBLIC_IP_OF_NEXUS:8081/repository/spring-release/</url>
     </repository>
    <snapshotRepository>
        <id>nexus</id>
        <name>Snapshot Repos</name>
        <url>PUBLIC_IP_OF_NEXUS:8081/repository/first-snapshot/</url>
    </snapshotRepository>
</distributionManagement>
```


## Configuring Nexus credentials.
* Nexus credentails are stored in settings.xml in maven
* Now configure the nexus creds here `/opt/apache-maven/conf/settings.xml`
* vi `/opt/apache-maven-3.8.8/conf/settings.xml`
* Make sure you place this code snippet under <servers>*** </servers>
```xml
  <server>
    <id>nexus</id>
    <username>admin</username>
    <password>Gcp@2023</password>
  </server>
``
```xml
<servers>
  <server>
    <id>nexus</id>
    <username>admin</username>
    <password>Gcp@2023</password>
  </server>
</servers>
```
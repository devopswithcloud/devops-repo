### Configure Proxy repo in `pom.xml` and `settings.xml`
* vi pom.xml
* Change the remote repo which is already configured with new proxy url
```xml
<repositories>
    <repository>
        <id>nexus</id>
        <name>Siva Proxy Repo</name>
        <url>http://PUBLIC_IP_OF_NEXUS:8081/repository/siva-repo-proxy/</url>
    </repository> 
```
* vi /opt/apache-maven-3.8.8/conf/settings.xml
    * Change the `mirror` tag to be pointed to proxy url
* Remove `junit` jar from `~/.m2/repostittories/` and then test mvn package, we should be seeing it downloaded in to proxy repo.
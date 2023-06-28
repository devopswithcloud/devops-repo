## Maven Group repo:
* Delete the gpt jar we created in early stage. 
* execute `mvn package` , we will get below error
    * `[ERROR] Failed to execute goal on project my-maven-app: Could not resolve dependencies for project com.sivaacademy.app:my-maven-app:jar:2.3.1: com.sivaacademy:gpt:jar:v1.0.0 was not found in http://PUBLIC_IP_OF_NEXUS:8081/repository/siva-repo-proxy/ during a previous attempt. This failure was cached in the local repository and resolution is not reattempted until the update interval of nexus has elapsed or updates are forced -> [Help 1]`
* Because we change the `remote-repo` with `proxy-repo`
* Now we need to add the proxy url again, but its not good to add multiple repos in pom.xml and settings.xml
* Rather we can create a `maven-group` in nexus and configure all the repos which we need to download from include our own org repos as well.
* Create a repo with `siva-repo-proxy` in `maven2group` with `Mixed  and add the repos u want to have
    * Copy the repo
* Modify the `group-repo` in pom.xml and settings.xml
* test `mvn package`
    * gpt should be avalble in .m2 folder
### Deploy to Snapshot
* Go to sample-maven-application
* First Verify , mvn install, mvn package, then go with mvn deploy, so that we can see the difference b/w install, package and deploy
* execute `mvn deploy`
    * by doing this, these goals will be executed.
        * validate, compile, test , package, install.
* We can see artifact got uploaded to Nexus snapshots.
    * Verify in nexus UI
* again execute `mvn clean deploy` > we can see this got deployed again to snapshot. 
* Why does the artifact been available in `Snapshot` , and not in `release`. Because its configured in pom.xml
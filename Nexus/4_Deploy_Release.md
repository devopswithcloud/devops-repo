## Deploy to RELEASE
* To make the artifacts to deploy to Release channael make the change in the pom.xml from `1.0.0-SNAPHOT` remove `SNAPSHOT`
* We can see artifacts getting uploaded to `RELEASE`
*  Now dont change the version and execute `mvn deploy`, it will fail with `400 Repository does not allow updating assets`
* `400 Means bad request`, not sending proper request. 
* Now, change the version in pom.xml and execute `mvn clean deploy` . now the artifact will be upload to Release repo
* If i want to make a small fix and redeploy with same version, ideally it wont allow. but i need to make it allow . How i can do this ????
* Follow below steps
    * go to admin > repositories >  first-release > deployment policy > allow redploy
* Now execute `mvn clean deploy` and see , it should upload

## Creating some errors , so we can learn
* modify the wrng password in settings.xml and then execute `mvn clean deploy` again. 
* we will get `401 unauthorized`
* change to the correct password, and again execute `mvn clean deploy`
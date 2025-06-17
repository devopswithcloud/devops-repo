## Code Coverage 
* As a devleopere, the teams will be writing source code, and we need to tet the source code programatically. 
* To test the src code programatically the developes will write unit test cases. 
* Code Coverage is nothing but how many lines are tested  by the unit test cases written by the developer. 
    * Example: I have a Calculator.java with around 100 lines of code. 
    * Devs wrote the unit test cases called `Calculatortest.java` and the file has 92 line of code, the code coverage is 92%
* Cod Review:
    * We will be validating the code against the standards, to make sure if the devs have written the source code accounding to the standards. 
    * Ideally, your technical Dev Leads will take this up. 
    * As a devops engineer we need to make sure our CICD has this code quality in place , and make sure we implement those standards as mandatory. 
    * To do code review, we are going to use static code analysis

## Sonarqube
* Sonarqube is a third party tool developed by Sonar Source 
* THis is a code analysis tool which is aimed to provide code qulity by identifying the issue upfront rather than waiting the applicaiton to move to production. 
* It will continupusly analyse and measure the code quality, using `Quality Gates and Quality Profiles`
* Its a web based tool and supports multiple languages.

* If dev want not to perform sonar scan, it should skip even if dockerpush / docker build is enabled. 
* Create a step to deploy tags with format (v.x.x.x) to prod only.
    * other branches or other tag formats should not be allowed to prod
    * example: 
        * release/1.2.3 =====> should not deploy
        * master ============> should not deploy
        * v123 tag should also not deploy 
* if the branch is tag, and even if developer has skipped the sonar scans in the first step, scans should happen if its a tag 
* Create a step in each and every stage to send mail notification. 
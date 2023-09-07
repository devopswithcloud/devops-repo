## Terraform with package installations
* Create a Terraform script to provision 3 virtual machines 
    * Make one vm as `JenkinsMaster` 
    * Other as `JenkinsSlave`
    * 3rd vm as `Ansible`
    * 4th vm as `sonar`
* Make sure the number of vms passed are dynamically, along with dynamic data. 
    * For example, jenkinsmaster might have t2.medium , Sonar might work with t2.micro
    * Hint: varibles, count, for_each, terraform.tfvars
* The same terraform script should be helping us to configure ansible contoller setup in the `Ansible` node 
* In output file, i should be having the details of the vm's created along with the port numbers as well.
```bash
jenkins_master = <publicip>:8080
nexus_server = <publivip>:8081
sonar_server = <publicip>:9000
```
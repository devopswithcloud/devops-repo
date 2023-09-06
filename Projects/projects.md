

## Terraform with package installations
* Create a Terraform script to provision 3 virtual machines 
* Make one vm a s `JenkinsMaster` 
* Other as `JenkinsSlave`
* 3rd vm as `Ansible`
* The same terraform script should be helping us to configure ansible contoller setup in the `Ansible` node 

## Install and Deploy node packages with Ansible
* Provision servers manually or using terraform 
* Write ansible playbook to install 
    * node and npm on the server
    * Copy node artifact from controller to node
    * Unpack the artifacts on the respecctive nodes
    * Start the application. 

## Install Nexus On the vm using Ansible 
* Provision server manually or using terraform 
* [Refer Here](https://github.com/devopswithcloud/devops-repo/blob/main/Nexus/1_Nexus_Installtion.md) for installation steps 
## Infra Creation using Terraform and Ansible
* Create terraform manifest file to provision the infrastructure . 
* As we need to provision the vms, create a key-pair called `project-key` from the console of AWS and place in the current folder
### Jenkins Master Setup:
* Create a ansible playbook to install jenkins on `jenkins-master`
### Jenkins Slave Setup:
* Create a ansible playbook to configure slave machine, so that we can deploy our applications.
* Install java on the slave machine 
* Download and configure Maven 
* Download and configure java 17



```bash
[jenkins-master]
10.0.10.26
[jenkins-master:vars]
ansible_user=ubuntu
ansible_ssh_private_key_file=/home/ubuntu/project-key.pem
[jenkins-slave]
10.0.10.186
[jenkins-slave:vars]
ansible_user=ubuntu
ansible_ssh_private_key_file=/home/ubuntu/project-key.pem
[sonarqube]
10.0.10.252
[sonarqube:vars]
ansible_user=ubuntu
ansible_ssh_private_key_file=/home/ubuntu/project-key.pem
```
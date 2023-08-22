## Creating Ansible nodes 
```bash
# Create a Ansible Controller
gcloud compute instances create ansibleserver --zone=us-west4-b --machine-type=e2-medium --create-disk=auto-delete=yes,boot=yes,device-name=sonar,image=projects/centos-cloud/global/images/centos-7-v20221206,mode=rw,size=20

# Create a Ansible node
gcloud compute instances create ansible-host --zone=us-west4-b --machine-type=e2-medium --create-disk=auto-delete=yes,boot=yes,device-name=sonar,image=projects/centos-cloud/global/images/centos-7-v20221206,mode=rw,size=20
```

## Installing Ansible 
```
# Creating a user called as ansible on all the hosts
useradd ansible
passwd ansible

# make the necessary entrys so that ansible user can go with sudo and password less access
visudo
  ansible ALL=(ALL)       NOPASSWD: ALL

# Enable password based authentication
vi /etc/ssh/sshd_config

# Restart the sshd service
service sshd restart

```

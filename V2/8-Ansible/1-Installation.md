## Create Ansible Controller and hosts
* Use the below command to create machines in gcp
* Alternatively you can use console/terraform as well for this
```bash
gcloud compute instances create ansible-controller ansible-host  --zone=us-central1-b \
    --machine-type=e2-medium \
    --create-disk=auto-delete=yes,boot=yes,image=projects/ubuntu-os-cloud/global/images/ubuntu-2004-focal-v20241115,mode=rw,size=10,type=pd-balanced
```
## Installing Ansible on Controller
```bash
# Login with root use and create ansible user and provide sudo acess in all servers.
# Creating a user called as ansible on all the hosts
adduser ansible

# Enable password based authentication
vi /etc/ssh/sshd_config

# Restart the sshd service
service sshd restart


# make the necessary entrys so that ansible user can go with sudo and password less access
visudo
  ansible ALL=(ALL)       NOPASSWD: ALL


# Restart the sshd service
service sshd restart


# Install ansible only on the controller 
sudo apt update
sudo apt install software-properties-common
sudo add-apt-repository --yes --update ppa:ansible/ansible
sudo apt install ansible
```

## Configuring Ansible
```bash
# Switch to ansivle user from controller
su - ansible

# In ansible controller , create a key pair
ssh-keygen

# Copy the keys into the hosts as ansible user
ssh-copy-id ansible@<PRIVAT_IP_ADDRESS_OF_HOST>

# Try to connect to hosts, without password
ssh ansible@<PRIVAT_IP_ADDRESS_OF_HOST> # No password should be asked. 
```

## first ansible adhoc command 
```bash
vi inv
    <PRIVATE_IP_OF_HOST>


# command to ping on all the host machines mentioned in the inv file
ansible -i inv -m ping -all
```



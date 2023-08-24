imperative 
declerative >>>>>> manifest file 

* If we want to have the list of all modules through CLI 
```bash
# to list out all modules avaialble 
ansible-doc -l

# specific to a particular module 
ansible-doc <moduleName>
ansible-doc yum
ansible-doc apt
```

## Ping Module

```bash
ansible all -i inv -m ping # -i can be passed or --inventory

ansible all -i inv -m ping -o

```

## Shell Module
```bash
# /etc/ansible/hosts file will be triggered
ansible all -m shell -a "date"
ansible all -m shell -a "cat /etc/*release*"

```

## apt Module
```bash
# Inform ansible to ensure repo is updated,  apache2 is installed
ansible -b -i ubuntuhost -m apt -a "name=apache2 state=present update_cache=yes" all
```


## Yum Module
* I want to install tree package on all the hosts
* I want to install in a single host
```bash
# syntax for single host installation
ansible private_ip_address -m moduleName

ansible 10.182.0.62 -m yum -a "name=tree"
# the above command will fail, as its executing as a normal user

# use the below command 
ansible 10.182.0.62 -b -m yum -a "name=tree"

```

## Copy module 
```bash
vi siva.txt
ansible all -m copy -a "src=siva.txt dest=/tmp/testing.txt"

# make some modifications to siva.txt on the ansible controller, and execute the above command again
# If there is a change, then only copy module will copy the file
```

## Setup Module
* ansible all -m setup
* ansible -i inv localhost -m setup
* ansible -i inv localhost -m setup | grep -i dist*
    * "ansible_distribution": "CentOS"

    
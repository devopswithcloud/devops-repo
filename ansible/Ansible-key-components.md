## Ansible key terms
* `Inventory`: List of all the nodes to which ansible controller server has to connect and run the desired state. 
    * By ddefault inverntory file `/etc/ansible/hosts`
    * Else we can have our own inventory file and use `-i` option to passit.
* `Module`: Smalluest unit that can be using for automation in Ansible
    * In module, we specify the desired state 
    * In ansible, we cant go below the module.
* `Task`: Task in ansible will consists of Modules.
* `Play`: Play will consists of multiple tasks. 
* `playbooks`: Playbooks consists of one or more plays. 

## Ansible Workflow:
* Ideally we use ansible to deploy applciations.
* Deploying an applications means excecuting a sequence of steps. 
* Firstly, take a note of all the manual steps that are required and get the equivalent `module` from ansible. 
* Mention the desired state in module using playbooks. 


## First Ansible module
* Go to ansible documentation for every module. https://docs.ansible.com/ansible/2.9/modules/list_of_all_modules.html
* Search for a module called as `apt`
* In module the most important thing is `parameters`
* To module, we send `parameters` as `arguments`
* Now, lete try to get the data for our first package called `install apache2` webserver.
```bash
# Manual way
sudo apt update 
sudo apt install apache2  -y


# ansible way 

```
* we need to update the package using apt module
* we need to install apache2 using apt modeule
* So for our apt module, we should be having the below parametes
    * name: apache2
    * state: present 
    * update_cache: yes 
* Now lets make the above parametes into a adhoc ansible command
```bash
# Inform ansible to ensure repo is updated,  apache2 is installed
ansible -b -i ubuntuhost -m apt -a "name=apache2 state=present update_cache=yes" all
```
* If we have to run the same file in yaml format
```yaml
# apache-play.yaml
---
- name: Installing apache server
  become: yes
  hosts: all
  tasks:
  - name: install apache2
    apt:
      name: apache2
      state: present
      update_cache: yes
# ansible-playbook -i hosts apache-play.yaml
```
# Ansible Playbook Structure
* Playbooks are represented in `yaml` files
* A typicall ansible playbook looks like this 
```yaml
---
- name: <name of the play>
  hosts: <On which hosts this playbook has to be executed>
  become: <yes/no> # this will execute as a root privilige
  tasks: 
  - name: <name of the task>
    <module-name>
      <module-parameter-1>: <value-1>
      <module-parameter-2>: <value-2>
      ....
      ....
      ...
      state: <value of the state>
```
* Lets write a playbook to ping all nodess
```yaml
# apache-play.yaml
---
- name: Installing apache server
  become: yes
  hosts: all # /etc/ansible/hosts
  tasks:
  - name: install apache2
    apt:
      name: apache2
      state: present
      update_cache: yes
# ansible-playbook -i hosts apache-play.yaml
```

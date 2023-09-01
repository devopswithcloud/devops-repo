## Create a variable file 
```bash
# vi variable.yaml
courseName: istio
batchNumber: 9
```

## Create a Playbook
```yaml
# vi installhttpd.yaml
---
- hosts: all
  become: true
  vars_files:
  - variable.yaml
  tasks:
  - name: Install Apache httpd
    yum:
      name: httpd
      state: present
  - name: Copy the html file 
    template:  # previously copy
      src: index.html
      dest: /var/www/html/index.html
    notify: 
    - Restart the service 
  handlers:
  - name: Restart the service 
    service: 
      name: httpd
      enabled: true
      state: restarted
# ansible-playbook -i ../inventory installhttpd.yaml --extra-vars courseName=helm -e batchNumber=10

# if we pass the run time variables and varibles are been defined in the yaml using vars_files, runtime varaibles will be taking the presedence. 
```

## Pass the `variable files` dynamically
```bash
# vi dev_vars.yaml 
courseName: openshift
batchNumber: 1-dev
```
```bash
# vi prod_vars.yaml 
courseName: GCP
batchNumber: 1-prod
```
```bash
# vi dynamic.yaml
---
- hosts: all
  become: true
  vars_files:
  - "{{env}}_vars.yaml"
  tasks:
  - name: Install Apache httpd
    yum:
      name: httpd
      state: present
  - name: Copy the html file 
    template:  # previously copy
      src: index.html
      dest: /var/www/html/index.html
    notify: 
    - Restart the service 
  handlers:
  - name: Restart the service 
    service: 
      name: httpd
      enabled: true
      state: restarted
```
```bash
ansible-playbook -i ../inventory dynamicinstall.yaml -e env=prod
ansible-playbook -i ../inventory dynamicinstall.yaml -extra-vars env=prod
```

## Pass the `variable files` dynamically but still with default varibles
```bash
# vi dynamic.yaml
---
- hosts: all
  become: true
  vars:
  - env: dev
  vars_files:
  - "{{env}}_vars.yaml"
  tasks:
  - name: Install Apache httpd
    yum:
      name: httpd
      state: present
  - name: Copy the html file 
    template:  # previously copy
      src: index.html
      dest: /var/www/html/index.html
    notify: 
    - Restart the service 
  handlers:
  - name: Restart the service 
    service: 
      name: httpd
      enabled: true
      state: restarted
```

## Group Variables
* Creata a yaml file in `/etc/ansible/group_vars/GROUPNAME`
* Create a groupname under `/etc/ansible/hosts` file
```bash
[appserver]
10.2.3.5 # this is the ip of the node
```
* `sudo mkdir /etc/ansible/group_vars`
* `vi /etc/ansible/group_vars/appserver.yaml`
```bash
key: value
```
### Create a playbook to install java package
```yaml
# vi install_java.yaml
---
- hosts: all
  become: true
  tasks:
  - name: Install java on node
    yum: 
      name: "{{javaVersion}}" # java package name >>>> java-11-openjdk.x86_64
  - name: Get the java version
    shell: java -version
```
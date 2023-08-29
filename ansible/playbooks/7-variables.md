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
```
* ansible-galaxy init <roleName>
* Segregate the complete playbook into multiple files, like handlers/ , templates/, vars/
* Create a playbook to call the roles
```yaml
---
- hosts: all
  become: true
  roles:
  - <roleName>
```

# User and Group Management in Linux

This guide covers the essential tasks for managing users and groups in Linux, including setting up SSH for remote access and connecting using an SSH client.

---

## 1. Creating Users

To create users, use the `adduser` command.

### Commands:

- **Create user `siva`**:
  ```bash
  sudo adduser siva
  ```

- **Create user `maha`**:
  ```bash
  sudo adduser maha
  ```

Once these users are created, you can perform tasks like switching users, managing groups, and setting passwords.

---

## 2. Setting Up SSH for Remote Access

To allow users to log in via SSH, you need to configure the SSH daemon. Follow the steps below to enable remote access for the users you just created.

### Steps:

1. **Open the SSH configuration file**:
   ```bash
   sudo vi /etc/ssh/sshd_config
   ```

2. **Ensure the following lines are configured (or uncomment them if needed)**:
   ```bash
   PermitRootLogin no
   PasswordAuthentication yes
   ```

3. **For the latest versions of Ubuntu**, make sure the following line is commented:
   ```bash
   # Include /etc/ssh/sshd_config.d/*.conf
   ```

4. **Restart the SSH service**:
   ```bash
   sudo service sshd restart
   ```

This will allow the newly created users, **siva** and **maha**, to log in remotely using SSH.

---

## 3. Connecting via SSH Using an SSH Client

Once SSH is configured, you can connect to the Linux server remotely using an SSH client like **PuTTY** (Windows) or the built-in SSH command (Linux/macOS).

### Steps:

1. **Find the public IP address of the server**:

   - For an **AWS EC2 instance**, you can find the public IP address by going to the **AWS Console**, selecting your **EC2 instance**, and checking the **Public IPv4 address** field under the instance details.

   - For a **Google Cloud GCE instance**, go to the **Google Cloud Console**, select your **GCE instance**, and find the **External IP** under the instance details.

2. **Using the SSH command (Linux/macOS)**:
   On your local machine (Linux or macOS), open a terminal and run the following command to connect to the server:
   ```bash
   ssh siva@<public-ip-address>
   ```
   Example:
   ```bash
   ssh siva@35.232.100.100
   ```

   - You will be prompted to enter the password for the user **siva**.

3. **Using PuTTY (Windows)**:
   - Download and install **PuTTY** from [here](https://www.putty.org/).
   - Open **PuTTY** and in the **Host Name (or IP address)** field, enter the **public IP address** of your EC2 or GCE instance (e.g., `35.232.100.100`).
   - Make sure the **Port** is set to **22** (default SSH port).
   - Click **Open**.

   When prompted, log in with the username **siva** and the password you set during the user creation.

4. **After successful login**, you will be connected to the Linux server as the user **siva**. You can now manage the server remotely.

---

## 4. Switching Users

Once users are created, you can switch between them using the `su` command.

- **Switch to `siva`**:
  ```bash
  su - siva
  ```

- **Switch to `maha`**:
  ```bash
  su - maha
  ```

- **Switch to the root user**:
  ```bash
  su -
  ```

---

## 5. Changing User Passwords

You can change the password for the current user or for another user.

- **Change the password for the current user**:
  ```bash
  passwd
  ```

- **Change the password for another user**:
  ```bash
  sudo passwd maha
  ```

---

## 6. Forcing Password Reset on First Login

If you want a user to reset their password upon their first login, you can expire their current password.

- **Force password reset for `maha`**:
  ```bash
  sudo passwd -e maha
  ```

This will require **maha** to change the password upon the next login.

---

## 7. Deleting Users

You can delete users with or without their home directories.

- **Delete `siva` without removing their home directory**:
  ```bash
  sudo userdel siva
  ```

- **Delete `siva` and remove their home directory**:
  ```bash
  sudo userdel -r siva
  ```

---

## 8. Creating and Managing Groups

Groups in Linux allow you to organize users and manage permissions collectively.

- **Create a group named `developers`**:
  ```bash
  sudo groupadd developers
  ```

- **Add `maha` to the `developers` group**:
  ```bash
  sudo usermod -aG developers maha
  ```

- **Remove `maha` from the `developers` group**:
  ```bash
  sudo gpasswd -d maha developers
  ```

- **Delete the `developers` group**:
  ```bash
  sudo groupdel developers
  ```

---

## 9. Checking Group Membership

You can check which groups a user belongs to.

- **Check groups for `maha`**:
  ```bash
  groups maha
  ```

- **Verify group membership with `id`**:
  ```bash
  id maha
  ```

---

### Summary of Commands

| Command                         | Description                                  | Example                                         |
|----------------------------------|----------------------------------------------|-------------------------------------------------|
| `su - [username]`                | Switch to another user                       | `su - maha`                                     |
| `userdel [username]`             | Delete a user                                | `sudo userdel siva`                             |
| `userdel -r [username]`          | Delete a user and remove their home directory | `sudo userdel -r siva`                          |
| `passwd`                         | Change the password for the current user      | `passwd`                                        |
| `passwd [username]`              | Change the password for another user          | `sudo passwd maha`                              |
| `passwd -e [username]`           | Expire a user’s password (force reset)        | `sudo passwd -e john`                           |
| `groupadd [groupname]`           | Create a new group                           | `sudo groupadd developers`                      |
| `usermod -aG [group] [username]` | Add a user to a group                        | `sudo usermod -aG developers maha`              |
| `gpasswd -d [username] [group]`  | Remove a user from a group                   | `sudo gpasswd -d maha developers`               |
| `groupdel [groupname]`           | Delete a group                               | `sudo groupdel developers`                      |
| `groups [username]`              | List groups for a user                       | `groups maha`                                   |
| `id [username]`                  | Display user’s ID and group membership       | `id maha`                                       |

---

This completes the **User and Group Management** guide in Linux, including SSH setup for remote access and instructions for connecting via an SSH client using a public IP address.

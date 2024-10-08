
# File Permissions in Linux

Linux file permissions allow you to control who can read, write, and execute files or directories. This section will cover the basics of file permissions, followed by specific scenarios for managing access.

---

## 1. Understanding File Permissions

Each file and directory in Linux has three sets of permissions:
- **User (u)**: The owner of the file.
- **Group (g)**: Users in the group associated with the file.
- **Others (o)**: All other users on the system.

Permissions can be for:
- **r**: Read
- **w**: Write
- **x**: Execute

You can view the permissions of a file using the `ls -l` command:
```bash
ls -l /path/to/file
```

Example output:
```
-rwxr-xr-- 1 siva developers 4096 Oct 3 12:00 file1.txt
```

### Breakdown of Permissions:
- `rwx` (for the owner): The owner **siva** has **read, write, and execute** permissions.
- `r-x` (for the group): Members of the **developers** group have **read and execute** permissions.
- `r--` (for others): All other users have **read-only** access.

---

## 2. Changing File Permissions with `chmod`

Use the `chmod` command to change permissions for files and directories.

### **Symbolic Mode**:
- **Add execute permission for the user**:
  ```bash
  chmod u+x file1.txt
  ```

- **Remove write permission for the group**:
  ```bash
  chmod g-w file1.txt
  ```

### **Numeric Mode**:
In numeric mode, permissions are represented as numbers:
- **r = 4**, **w = 2**, **x = 1**

Example:
- **chmod 755**: Gives the owner read, write, execute (`rwx`), and gives the group and others read and execute (`r-x`).

---

## 3. Changing Ownership with `chown`

The `chown` command allows you to change file ownership, including the user and group associated with a file.

- **Change ownership of a file**:
  ```bash
  sudo chown siva:siva file1.txt
  ```

- **Change ownership of all files in a directory recursively**:
  ```bash
  sudo chown -R siva:siva /home/siva/
  ```

---

## 4. File Permission Scenarios

Let’s go through some common scenarios for managing file access.

### **Scenario 1: Restricting File Access**

1. **Create a file**:
   ```bash
   sudo vi /opt/testfile.txt
   ```
   Add some content to the file (e.g., `This is a test file.`).

2. **Change file ownership to `siva`**:
   ```bash
   sudo chown siva:siva /opt/testfile.txt
   ```

3. **Set strict permissions for the owner only (read and write)**:
   ```bash
   sudo chmod 600 /opt/testfile.txt
   ```

4. **Verify the permissions**:
   ```bash
   ls -l /opt/testfile.txt
   ```
   Output:
   ```
   -rw------- 1 siva siva 50 Oct 3 12:00 /opt/testfile.txt
   ```

   - The file is readable and writable only by **siva**. No one else can access the file.

5. **Test access as `maha`**:
   Log in as **maha** and try to read the file:
   ```bash
   cat /opt/testfile.txt
   ```
   Expected output:
   ```
   cat: /opt/testfile.txt: Permission denied
   ```

---

### **Scenario 2: Granting Read-Only Permissions to Others**

1. **Change the file permissions to allow others to read the file**:
   ```bash
   sudo chmod 644 /opt/testfile.txt
   ```

2. **Verify the permissions**:
   ```bash
   ls -l /opt/testfile.txt
   ```
   Output:
   ```
   -rw-r--r-- 1 siva siva 50 Oct 3 12:00 /opt/testfile.txt
   ```

   - **siva** can read and write.
   - Others, including **maha**, can only read the file.

3. **Test access as `maha`**:
   ```bash
   cat /opt/testfile.txt
   ```
   Output:
   ```
   This is a test file.
   ```

4. **Attempt to modify the file as `maha`**:
   ```bash
   echo "New content" >> /opt/testfile.txt
   ```
   Expected output:
   ```
   bash: /opt/testfile.txt: Permission denied
   ```

---

### **Scenario 3: Adding Execute Permission**

1. **Create a script file**:
   ```bash
   sudo vi /opt/myscript.sh
   ```
   Add the following content:
   ```bash
   #!/bin/bash
   echo "This is a script."
   ```

2. **Change the ownership to `siva`**:
   ```bash
   sudo chown siva:siva /opt/myscript.sh
   ```

3. **Set execute permission for the owner and read-only for others**:
   ```bash
   sudo chmod 744 /opt/myscript.sh
   ```

4. **Verify the permissions**:
   ```bash
   ls -l /opt/myscript.sh
   ```
   Output:
   ```
   -rwxr--r-- 1 siva siva 50 Oct 3 12:30 /opt/myscript.sh
   ```

5. **Test execution as `siva`**:
   ```bash
   ./opt/myscript.sh
   ```
   Output:
   ```
   This is a script.
   ```

6. **Test execution as `maha`**:
   ```bash
   su - maha
   ./opt/myscript.sh
   ```
   Expected output:
   ```
   bash: ./myscript.sh: Permission denied
   ```

---

### Summary of Commands

| Command                         | Description                                   | Example                                        |
|----------------------------------|-----------------------------------------------|------------------------------------------------|
| `chmod [permissions] [file]`     | Change the permissions of a file              | `chmod 644 file1.txt`                          |
| `chown [user]:[group] [file]`    | Change the owner and group of a file          | `sudo chown siva:siva file1.txt`               |
| `ls -l`                          | List the files with their permissions         | `ls -l /opt/testfile.txt`                      |
| `chown -R [user]:[group] [dir]`  | Recursively change ownership of a directory   | `sudo chown -R siva:siva /home/siva/`          |
| `chmod +x [file]`                | Add execute permission for a file             | `chmod +x script.sh`                           |
| `chmod u-w [file]`               | Remove write permission for the owner         | `chmod u-w file1.txt`                          |

---

This completes the **File Permissions in Linux** section, including various scenarios for managing access using `chmod` and `chown`.

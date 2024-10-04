
# Working with Directories in Linux

Managing directories is a fundamental aspect of working with the Linux file system. Here are the essential commands for creating, moving, deleting, and listing directories.

---

## 1. `mkdir` (Make Directory)
- **Description**: This command is used to create new directories.
- **Usage**:
  ```bash
  mkdir directory_name   # Create a new directory
  mkdir -p /path/to/new_directory   # Create a directory with parent directories if they don't exist
  ```
- **Example**:
  ```bash
  mkdir i27academy          # Create a directory named 'i27academy'
  mkdir -p /home/siva/devopsmastery # Create 'devopsmastery' directory under '/home/siva', creating missing parent directories
  ```

---

## 2. `ls` (List Directory Contents)
- **Description**: This command lists the contents of a directory, including files and subdirectories.
- **Options**:
  - `ls`: Basic listing of files and directories.
  - `ls -l`: Lists with details like file permissions, ownership, and size.
  - `ls -a`: Lists all files, including hidden ones (starting with `.`).
  - `ls -lh`: Lists contents in a human-readable format (e.g., file sizes in KB, MB).
- **Usage**:
  ```bash
  ls                    # Basic directory listing
  ls -l                 # Detailed listing
  ls -a                 # Include hidden files
  ls -lh                # List with human-readable sizes
  ```

---

## 3. `cd` (Change Directory)
- **Description**: Moves you between directories in the file system.
- **Usage**:
  ```bash
  cd /path/to/directory   # Change to a specific directory
  cd ..                   # Move up one directory
  cd ~                    # Change to the home directory
  cd -                    # Go back to the previous directory
  ```
- **Example**:
  ```bash
  cd /var/jenkins       # Navigate to the 'jenkins' directory under '/var'
  cd ..                 # Move back to '/var'
  cd -                  # Return to the previous directory you were in
  ```

---

## 4. `pwd` (Print Working Directory)
- **Description**: Displays the full path of the current working directory.
- **Usage**:
  ```bash
  pwd   # Show the absolute path of your current directory
  ```
- **Example**:
  ```bash
  pwd   # Output: /home/siva/kubernetes
  ```

---

## 5. `rmdir` (Remove Empty Directory)
- **Description**: Removes an empty directory.
- **Usage**:
  ```bash
  rmdir directory_name   # Remove a directory if it is empty
  ```
- **Example**:
  ```bash
  rmdir devopsmastery   # Removes 'devopsmastery' if it has no files
  ```

---

## 6. `rm` (Remove Files and Directories)
- **Description**: Removes files and directories. You can delete both empty and non-empty directories using this command.
- **Options**:
  - `rm file_name`: Removes a file.
  - `rm -r directory_name`: Removes a directory and its contents recursively.
  - `rm -rf directory_name`: Forcefully removes a directory and all its contents without prompt.
- **Usage**:
  ```bash
  rm file.txt           # Delete a file
  rm -r i27academy      # Recursively delete a directory and its contents
  rm -rf kubernetes     # Forcefully delete a directory without confirmation
  ```
- **Example**:
  ```bash
  rm -rf /tmp/devopsmastery    # Forcefully delete the 'devopsmastery' directory in /tmp without prompt
  ```

---

## 7. `mv` (Move or Rename Directory)
- **Description**: Moves or renames directories.
- **Usage**:
  ```bash
  mv old_directory new_directory   # Rename a directory
  mv directory_name /path/to/destination   # Move a directory to a new location
  ```
- **Example**:
  ```bash
  mv i27academy kubernetes   # Rename 'i27academy' to 'kubernetes'
  mv devopsmastery /home/siva/backup   # Move 'devopsmastery' to the '/home/siva/backup' directory
  ```

---

## 8. `cp` (Copy Files and Directories)
- **Description**: Copies directories and their contents.
- **Options**:
  - `cp -r source_directory destination_directory`: Copies directories recursively.
- **Usage**:
  ```bash
  cp -r source_directory destination   # Copy a directory and its contents
  ```
- **Example**:
  ```bash
  cp -r /var/jenkins /backup/jenkins_backup   # Copy the 'jenkins' directory to '/backup/jenkins_backup'
  ```

---

## Summary of Commands for Directory Management:

| Command       | Description                                | Example                              |
|---------------|--------------------------------------------|--------------------------------------|
| `mkdir`       | Create a new directory                     | `mkdir i27academy`                   |
| `ls`          | List directory contents                    | `ls -l`                              |
| `cd`          | Change to another directory                | `cd /var/jenkins`                    |
| `pwd`         | Show the current directory path            | `pwd`                                |
| `rmdir`       | Remove an empty directory                  | `rmdir devopsmastery`                |
| `rm -r`       | Remove a directory and its contents        | `rm -r kubernetes`                   |
| `mv`          | Move or rename a directory                 | `mv i27academy kubernetes`           |
| `cp -r`       | Copy a directory and its contents          | `cp -r /var/jenkins /backup/jenkins_backup` |

---


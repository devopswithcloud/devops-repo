
# Copy Command (`cp`)

The `cp` command in Linux is used to copy files and directories. Below are various ways you can use the `cp` command.

### **1. Copy a File to Another File**
```bash
cp source_file destination_file
```
- **Description**: This command copies the contents of `source_file` to `destination_file`.
- If `destination_file` does not exist, it will be created.
- If `destination_file` exists, its contents will be overwritten by the contents of `source_file`.

**Example**:
```bash
cp file1.txt file2.txt   # Copy the content of file1.txt to file2.txt
```

### **2. Copy Files to a Directory**
```bash
cp file1 file2 directory_name
```
- **Description**: Copies `file1` and `file2` into `directory_name`.
- You can copy multiple files, but the last argument must be the target directory, which must exist.

**Example**:
```bash
cp file1.txt file2.txt /home/siva/output   # Copy file1.txt and file2.txt to the 'output' directory
```

### **3. Copy All Files of One Directory to Another Directory**
```bash
cp dir1/* dir2
```
- **Description**: Copies all files from `dir1` to `dir2`.
- `dir2` must already exist. Only the files inside `dir1` will be copied.

**Example**:
```bash
cp /home/siva/dir1/* /home/siva/dir2   # Copy all files from 'dir1' to 'dir2'
```

### **4. Copy an Entire Directory**
```bash
cp -r dir1 dir2
```
- **Description**: Copies the entire contents of `dir1` (including all files and subdirectories) into `dir2`. The `-r` option stands for **recursive**, meaning all levels of subdirectories are copied.
- **Important**: You must use the `-r` option when copying directories.

**Example**:
```bash
cp -r /home/siva/dir1 /home/siva/dir2   # Copy 'dir1' and all its contents to 'dir2'
```

### **5. Copy Multiple Directories into Another Directory**
```bash
cp -r dir1 dir2 dir3 destination_directory
```
- **Description**: Copies multiple directories (`dir1`, `dir2`, `dir3`) into `destination_directory`.
- The destination directory must exist.

**Example**:
```bash
cp -r dir1 dir2 dir3 /home/siva/backup   # Copy 'dir1', 'dir2', and 'dir3' into the 'backup' directory
```

---

# Moving and Renaming Files and Directories (`mv`)

The `mv` command is used for both moving and renaming files or directories.

### **1. Renaming a File**
```bash
mv oldname newname
```
- **Description**: Renames `oldname` to `newname`.

**Example**:
```bash
mv file1.txt file2.txt   # Rename 'file1.txt' to 'file2.txt'
```

### **2. Renaming a Directory**
```bash
mv dir1 dir2
```
- **Description**: Renames `dir1` to `dir2`.

**Example**:
```bash
mv /home/siva/dir1 /home/siva/dir2   # Rename 'dir1' to 'dir2'
```

### **3. Move Files to a Directory**
```bash
mv file1 file2 directory_name
```
- **Description**: Moves `file1` and `file2` to `directory_name`.
- The target directory must exist.

**Example**:
```bash
mv a.txt b.txt /home/siva/output   # Move 'a.txt' and 'b.txt' into the 'output' directory
```

### **4. Move All Files from One Directory to Another**
```bash
mv dir1/* dir2
```
- **Description**: Moves all files from `dir1` to `dir2`. After this command, `dir1` will be empty.
- `dir2` must already exist.

**Example**:
```bash
mv /home/siva/dir1/* /home/siva/dir2   # Move all files from 'dir1' to 'dir2'
```

### **5. Move an Entire Directory**
```bash
mv dir1 dir2
```
- **Description**: Moves `dir1` into `dir2` if `dir2` exists. If `dir2` does not exist, it will rename `dir1` to `dir2`.

**Example**:
```bash
mv /home/siva/dir1 /home/siva/dir2   # If 'dir2' exists, move 'dir1' into 'dir2'; otherwise, rename 'dir1' to 'dir2'
```

---

### Notes:
- **Overwrite without Prompt**: When using `cp` or `mv`, if the target file or directory already exists, the command will overwrite the contents without asking for confirmation.
  - To get a confirmation prompt before overwriting, use the `-i` option with both `cp` and `mv`:
    ```bash
    cp -i file1.txt file2.txt    # Prompts for confirmation before overwriting
    mv -i file1.txt /backup      # Prompts before overwriting if 'file1.txt' already exists in '/backup'
    ```
  
- **Preserving File Attributes**: To preserve file attributes like timestamps, permissions, and ownership while copying, use the `-p` option with `cp`:
  ```bash
  cp -p file1.txt /backup/file1.txt   # Preserve attributes while copying
  ```



# Links in Linux

In Linux, **links** are pointers that reference files or directories. There are two main types of links:
1. **Hard Links**
2. **Soft Links (Symbolic Links)**

This is different from Windows, where we primarily use shortcuts (which are equivalent to symbolic links in Linux). One of the unique features of Linux is **hard links**, which are not commonly found in other operating systems.

---

## 1. Hard Links

A **hard link** is essentially another name for an existing file. It points to the same inode (index node) as the original file, meaning both files share the same physical data on the disk.

### **Creating a Hard Link**
To create a hard link, use the `ln` command without the `-s` option:
```bash
ln originalfile hardlinkfile
```

### **Example**:
```bash
ln file1.txt file1-hardlink.txt
```
- Here, `file1.txt` is the original file, and `file1-hardlink.txt` is the hard link file. Both files now point to the same data on disk.

### **Real Example**:
```bash
vi file1.txt
# Add content: "Hello"

ln file1.txt file1-hardlink.txt
ls -l
# Both files will have the same inode number, size, and timestamps.

# Modify the original file:
vi file1.txt
# Add or change content in file1.txt.

# Check the hard link:
cat file1-hardlink.txt
# The changes are reflected in both the original and the hard link file.
```

### **Important Points about Hard Links**:
- **Same Inode**: Both the original file and the hard link share the same inode, meaning they point to the same physical file on the disk.
- **File Deletion**: If you delete the original file, the hard link will still contain the data. The data will only be deleted if all links to the file are removed.
- **Multiple Links**: You can have multiple hard links pointing to the same file.

### **Creating Hard Links Across Directories**:
```bash
ln file1.txt ../file1-hardlink-new.txt
# The hard link can be created in a different directory, and changes reflect across both.
```

---

## 2. Soft Links (Symbolic Links)

A **soft link** (also known as a **symbolic link**) is similar to a Windows shortcut. Unlike hard links, soft links point to the path of the file rather than the file itself. They have a different inode number from the original file.

### **Creating a Soft Link**
To create a soft link, use the `ln` command with the `-s` option:
```bash
ln -s originalfile softlinkfile
```

### **Example**:
```bash
ln -s file1.txt file1-softlink.txt
```
- Here, `file1.txt` is the original file, and `file1-softlink.txt` is the symbolic link.

### **Real Example**:
```bash
ln -s file1.txt file1-softlink.txt
ls -l
# You will notice the soft link file points to the original file, with a different inode number.

cat file1-softlink.txt
# This will display the content of the original file via the symbolic link.
```

### **Important Points about Soft Links**:
1. **Different Inode**: The original file and the soft link have different inode numbers, file sizes, and timestamps.
2. **Size**: Soft links usually have a smaller size, as they only store the path to the file, not the actual data.
3. **Broken Links**: If the original file is deleted, the soft link becomes a **broken link**, as it points to a non-existent file.

---

## 3. Linking Directories

In Linux, you cannot create hard links for directories because it could break the filesystem structure. However, **soft links** for directories are allowed.

### **Example of Soft Link for Directories**:
```bash
ln -s dir1 dir2
```
- `dir2` will now be a symbolic link to `dir1`, and any changes made in `dir1` will be reflected in `dir2`.

### **Real Example**:
```bash
mkdir build-0501602023
cd build-0501602023
vi log.txt
# Add some content

cd ..
ln -s build-0501602023 prod
ls -l
# prod will point to the build-0501602023 directory

cat prod/log.txt
# Access the log file through the symbolic link

# Switch the prod link to a new directory
mkdir build-0501702023
ln -sfn build-0501702023 prod
# Now prod points to the new directory, build-0501702023

ln: This is the command to create a link (either hard or symbolic).
-s: This option tells ln to create a symbolic link (as opposed to a hard link).
-f: This option forces the creation of the link by removing any existing destination file or symbolic link named prod. If prod already exists, it will be replaced by the new symbolic link.
-n: This option is used to treat the destination (prod) as a regular file, even if it is a symbolic link. This is useful when you are replacing an existing symbolic link with a new one.


# Alternatively we can unlink and then link the new dir
unlink prod
ln -s build-0501702023 prod
```

- **Soft Link for Directories**: Soft links are commonly used for switching environments like production directories, log files, or versioned builds.

---

## Summary of Link Types:

| **Feature**            | **Hard Link**                             | **Soft Link (Symbolic Link)**                     |
|------------------------|-------------------------------------------|--------------------------------------------------|
| **Inode**              | Same as the original file                 | Different from the original file                 |
| **File Size**          | Same as the original file                 | Typically smaller (stores only the path)         |
| **Effect of Deletion** | Original file can be deleted without affecting the hard link | Deleting the original file breaks the soft link |
| **Directories**        | Cannot create hard links for directories  | Can create soft links for directories            |
| **Cross Filesystems**  | Cannot span across different filesystems  | Can span across different filesystems            |

---

## Key Takeaways:
- **Hard Links**: Essentially another name for the same file. Changes in one affect the other. Deleting the original file doesn't affect the hard link.
- **Soft Links**: Similar to shortcuts. They reference the path of the file. If the original file is deleted, the soft link becomes useless.


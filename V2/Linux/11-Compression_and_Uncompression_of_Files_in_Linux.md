
# Compression and Uncompression of Files in Linux

In this section, we cover compression and uncompression using tools like `tar`, `gzip`, `gunzip`, `bzip2`, and `bunzip2`.

---

## Why Use Compression?

- Compression reduces the size of files, improving memory utilization.
- It makes file transportation easier, especially for sending multiple files via email.
- Compression reduces network traffic during file transfers.

As a system administrator, it's common to compress and package files. This process involves two main activities:
1. **Creating an Archive File**
2. **Applying Compression Algorithms to the Archive**

---

## 1. Creating Archive Files with `tar`

The `tar` command (short for **tape archive**) is used to create archive files by grouping multiple files and directories into a single file. It doesn't compress by itself but is often combined with compression tools.

### **Basic Tar Usage**:

- **Create a tar archive**:
  ```bash
  tar -cvf demo.tar test1.txt test2.txt
  ```

- **Display contents of a tar file**:
  ```bash
  tar -tvf demo.tar
  ```

- **Extract contents of a tar file**:
  ```bash
  tar -xvf demo.tar
  ```

---

## 2. Applying Compression Algorithms to the Archive File

Once an archive file is created, you can apply various compression algorithms.

### **Compression Tools**:

- **`gzip`**: Fast but with lower compression efficiency.
- **`bzip2`**: Slower but provides better compression.
- **`xz`**: A newer compression tool with even better efficiency.

---

## 3. Compression and Decompression with `gzip`

- **Compress a tar file using `gzip`**:
  ```bash
  gzip demo.tar
  ```
  This creates a compressed file named `demo.tar.gz`.

- **Decompress a `.gz` file**:
  ```bash
  gzip -d demo.tar.gz
  # or
  gunzip demo.tar.gz
  ```
  This uncompresses the file back to `demo.tar`.

---

## 4. Compression and Decompression with `bzip2`

- **Compress a tar file using `bzip2`**:
  ```bash
  bzip2 demo.tar
  ```
  This creates a compressed file named `demo.tar.bz2`.

- **Decompress a `.bz2` file**:
  ```bash
  bunzip2 demo.tar.bz2
  ```
  This uncompresses the file back to `demo.tar`.

---

## 5. Combining `tar` and Compression in a Single Command

You can create a compressed archive directly by combining `tar` with a compression algorithm.

### **Using `gzip`**:
```bash
tar -cvzf demo.tar.gz *.txt
```
- The `-z` option applies `gzip` compression.
- This creates `demo.tar.gz` and compresses the files.

To extract and decompress:
```bash
tar -xvzf demo.tar.gz
```

### **Using `bzip2`**:
```bash
tar -cvjf demo.tar.bz2 *.txt
```
- The `-j` option applies `bzip2` compression.
- This creates `demo.tar.bz2` and compresses the files.

To extract and decompress:
```bash
tar -xvjf demo.tar.bz2
```

---

## 6. Reading Compressed Files Without Decompressing

Sometimes you want to read the contents of compressed files without decompressing them. You can use specialized commands like `zcat`, `bzcat`, and `xzcat`.

### **Using `gzip`**:
```bash
tar -cvzf passwd.tar.gz /etc/passwd
zcat passwd.tar.gz
```

### **Using `bzip2`**:
```bash
tar -cvjf passwd.tar.bz2 /etc/passwd
bzcat passwd.tar.bz2
```

### **Using `xz`**:
```bash
tar -cvJf passwd.tar.xz /etc/passwd
xzcat passwd.tar.xz
```


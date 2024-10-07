
# Command Line Utilities in Linux

In this section, we cover the following topics:
1. `wc` Command (Word Count)
2. Sorting Files (`sort` Command)
3. Piping in Linux
4. Executing Multiple Commands in a Single Line

---

## 1. `wc` Command (Word Count)
The `wc` command is used to count lines, words, and characters in a file or from standard input.

- **Options**:
  - `wc -l`: Count the number of lines.
  - `wc -w`: Count the number of words.
  - `wc -c`: Count the number of bytes/characters.

  **Example**:
  ```bash
  wc -l file.txt  # Count the number of lines in file.txt
  ```

---

## 2. Sorting (`sort` Command)

- The `sort` command is used to sort lines of text in a file. By default, it sorts alphabetically.

  **Basic Usage**:
  ```bash
  sort filename
  ```

### Example:

```bash
vi sort.txt
root@linuxvm:~/rem# cat sort.txt 
Jenkins
Maven
Ansible
Terraform
Docker
Kubernetes

# Now use the sort command
root@linuxvm:~/rem# sort sort.txt 
Ansible
Docker
Jenkins
Kubernetes
Maven
Terraform
```

- **Sorting in Reverse**: To sort in reverse alphabetical order, use the `-r` option:
  
  **Example**:
  ```bash
  root@linuxvm:~/rem# sort -r sort.txt 
  Terraform
  Maven
  Kubernetes
  Jenkins
  Docker
  Ansible
  ```

- **Sorting Alphanumeric Data**: If the file contains a mix of numbers and text, numbers will be sorted first, followed by text in alphabetical order.

  **Example**:
  ```bash
  root@linuxvm:~/rem# cat sort.txt 
  Jenkins
  Maven
  4
  Ansible
  Terraform
  Docker
  2
  Kubernetes
  
  root@linuxvm:~/rem# sort sort.txt 
  2
  4
  Ansible
  Docker
  Jenkins
  Kubernetes
  Maven
  Terraform
  ```

---

## 3. Piping in Linux

- The pipe (`|`) is used to pass the output of one command as input to another command.
  
  **Example**:
  ```bash
  cat file.txt | wc -l  # Count the lines of file.txt using piping
  ```
  This combines the `cat` and `wc` commands to count the number of lines in `file.txt`.

---

## 4. Multi Commands in a Single Line

We can execute multiple independent commands in a single line by using the following two methods:

### 1st Way: Using Semicolon (`;`)

- **Syntax**:
  ```bash
  cmd1; cmd2; cmd3; ... ; cmdn
  ```
  - First, `cmd1` will be executed, followed by `cmd2`, and so on.
  - Even if one of the commands fails, the rest of the commands will still execute.

### 2nd Way: Using `&&` (Logical AND)

- **Syntax**:
  ```bash
  cmd1 && cmd2 && cmd3 && ... && cmdn
  ```
  - First, `cmd1` will be executed, followed by `cmd2`, and so on.
  - If any command fails, the subsequent commands **will not** be executed.

### Example:

**Scenario**:
- Create a directory `dir1`.
- Create two files `date.txt` and `cal.txt` inside `dir1`.
- Write the current system date and time to `date.txt`.
- Write the current month calendar to `cal.txt`.

**Using Semicolon (`;`)**:
```bash
mkdir dir1; touch dir1/{date,cal}.txt; date > dir1/date.txt; cal > dir1/cal.txt
rm -rf dir1
```
- Even if one of the commands fails, the subsequent commands will still execute.

**Using `&&`**:
```bash
mkdir dir1 && touch dir1/{date,cal}.txt && date > dir1/date.txt && cal > dir1/cal.txt
rm -rf dir1
```
- If any command fails, the remaining commands will not be executed.

#### **Example of Failure**:

- **Semicolon (`;`)**: 
  ```bash
  mkdir dir1; touch dir1/{date,cal}.txt; Date > dir1/date.txt; cal > dir1/cal.txt
  rm -rf dir1
  ```
  - Here, the third command (`Date`) will fail because `Date` is an invalid command. However, the fourth command (`cal > dir1/cal.txt`) and the `rm -rf dir1` will still execute.

- **Using `&&`**:
  ```bash
  mkdir dir1 && touch dir1/{date,cal}.txt && Date > dir1/date.txt && cal > dir1/cal.txt
  ```
  - Here, the third command (`Date`) will fail, and the fourth command (`cal > dir1/cal.txt`) will **not** be executed.


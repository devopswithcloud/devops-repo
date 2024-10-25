
# GREP and EGREP in Linux with Practical Examples

The `grep` command is used to search text using patterns. Below are some practical examples using realistic data.

---

## 1. Basic `grep` Usage

### Example Setup:
```bash
cat > log.txt << EOF
[INFO] System started
[ERROR] Disk space low
[WARNING] High memory usage
[INFO] Process completed
[ERROR] Failed to start service
EOF
```

### Search for a Word:
```bash
grep "ERROR" log.txt
```
**Output**:
```
[ERROR] Disk space low
[ERROR] Failed to start service
```

---

## 2. Case Insensitive Search (`-i` option)

### Example Setup:
```bash
cat > config.txt << EOF
hostname: DEV-SERVER
OsType: Linux
version: Ubuntu 20.04
HOSTNAME: PROD-SERVER
EOF
```

### Search Ignoring Case:
```bash
grep -i "hostname" config.txt
```
**Output**:
```
hostname: DEV-SERVER
HOSTNAME: PROD-SERVER
```

---

## 3. Display Line Numbers (`-n` option)

### Example Setup:
```bash
cat > app.log << EOF
[INFO] Application started
[ERROR] Missing configuration
[INFO] Initializing modules
[ERROR] Failed to load module
EOF
```

### Search with Line Numbers:
```bash
grep -n "ERROR" app.log
```
**Output**:
```
2:[ERROR] Missing configuration
4:[ERROR] Failed to load module
```

---

## 4. Search Recursively (`-r` option)

### Example Setup:
```bash
mkdir logs
echo "Server started" > logs/server.log
echo "Disk full error" > logs/disk.log
echo "Network issue" > logs/network.log
```

### Recursive Search in a Directory:
```bash
grep -r "error" logs/
```
**Output**:
```
logs/disk.log:Disk full error
```

---

## 5. Display Only Matching Words (`-o` option)

### Example Setup:
```bash
cat > file.txt << EOF
The server is running at port 8080.
The application is accessible at port 3000.
EOF
```

### Search for the Word "port":
```bash
grep -o "port [0-9]*" file.txt
```
**Output**:
```
port 8080
port 3000
```

---

## 6. Search for Whole Words (`-w` option)

### Example Setup:
```bash
cat > users.txt << EOF
dev
developer
devops
system_admin
EOF
```

### Search for Whole Word "dev":
```bash
grep -w "dev" users.txt
```
**Output**:
```
dev
```

---

## 7. Invert Match (`-v` option)

### Example Setup:
```bash
cat > list.txt << EOF
apple
banana
cherry
apple_pie
EOF
```

### Display Lines that Do Not Contain "apple":
```bash
grep -v "apple" list.txt
```
**Output**:
```
banana
cherry
```

---

## 8. Count the Number of Matches (`-c` option)

### Example Setup:
```bash
cat > access.log << EOF
GET /index.html
POST /login
GET /about.html
POST /logout
GET /contact.html
EOF
```

### Count Occurrences of "GET":
```bash
grep -c "GET" access.log
```
**Output**:
```
3
```

---

## 9. Grep Multiple Patterns (`-e` option)

### Example Setup:
```bash
cat > services.txt << EOF
nginx
mysql
mongodb
redis
EOF
```

### Search for Multiple Patterns:
```bash
grep -e "nginx" -e "mysql" services.txt
```
**Output**:
```
nginx
mysql
```

---

# EGREP (Extended Grep)

`egrep` (Extended GREP) allows more powerful pattern matching without needing to escape special characters like `+`, `|`, or `()`. Although `egrep` is deprecated, you can use `grep -E` instead.

---

## 1. Using `egrep` or `grep -E`

### Example Setup:
```bash
cat > test.txt << EOF
apple
banana
orange
grape
apricot
EOF
```

### Search for Multiple Patterns with `egrep`:
```bash
egrep "apple|banana" test.txt
# or
grep -E "apple|banana" test.txt
```
**Output**:
```
apple
banana
```

---

## 2. Use Regular Expressions with `egrep`

### Search for Patterns Ending with "e" or Containing "ap":
```bash
egrep "e$|ap" test.txt
# or
grep -E "e$|ap" test.txt
```
**Output**:
```
apple
grape
apricot
```


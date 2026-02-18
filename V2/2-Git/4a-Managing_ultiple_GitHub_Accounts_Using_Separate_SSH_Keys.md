
---

# 🔐 Managing Multiple GitHub Accounts Using Separate SSH Keys (RSA)

---

#  Real-World Use Case (What We Are Doing)

In i27Academy ecosystem, we have:

| Account Type                       | Purpose                             |
| ---------------------------------- | ----------------------------------- |
| `i27academy`                       | Permanent main organization account |
| `i27devopsb8`, `i27devopsb9`, etc. | Batch-specific DevOps accounts      |

### ❗ Problem

If we use only **one SSH key**, then:

* We must keep replacing keys
* Authentication conflicts happen
* Push/pull fails
* Cloud Shell & Windows confusion starts

### ✅ Solution

We create **separate SSH key pairs** and configure them using SSH aliases.

---

# 🎯 Goal Architecture

| Account        | SSH Alias           | Private Key         |
| -------------- | ------------------- | ------------------- |
| i27academy     | `github-i27academy` | `id_rsa_i27academy` |
| DevOps batches | `github-devops`     | `id_rsa_devops`     |

So Git automatically knows which key to use.

---

# 🛠️ Step 1 – Generate Two RSA Key Pairs

Open **Git Bash (Windows)** or Linux terminal.

---

## 🔐 Key 1 – i27academy (Permanent Account)

```bash
ssh-keygen -t rsa -b 4096 -f ~/.ssh/id_rsa_i27academy -C "i27academy-rsa-key"
```

### Explanation

* `-t rsa` → RSA algorithm
* `-b 4096` → 4096-bit strong encryption
* `-f` → file name
* `-C` → comment label

Creates:

```
~/.ssh/id_rsa_i27academy
~/.ssh/id_rsa_i27academy.pub
```

---

## 🔐 Key 2 – DevOps Batch Accounts

```bash
ssh-keygen -t rsa -b 4096 -f ~/.ssh/id_rsa_devops -C "devops-batch-rsa-key"
```

Creates:

```
~/.ssh/id_rsa_devops
~/.ssh/id_rsa_devops.pub
```

⚠️ This key will be reused for future batch accounts.

---

# 🧩 Step 2 – Add Public Keys to Correct GitHub Accounts

---

## 🔹 Add to i27academy Account

```bash
cat ~/.ssh/id_rsa_i27academy.pub
```

Copy output →
Login to **GitHub (i27academy)** →
Settings → SSH & GPG Keys → New SSH Key → Paste → Save

---

## 🔹 Add to DevOps Batch Account

```bash
cat ~/.ssh/id_rsa_devops.pub
```

Login to batch account → Add SSH Key → Save

For future:

* Reuse same `id_rsa_devops.pub`

---

# ⚙️ Step 3 – Configure SSH Config File (Most Important)

Edit:

```bash
vi ~/.ssh/config
```

Add:

```ssh
# i27academy (Permanent)
Host github-i27academy
  HostName github.com
  User git
  IdentityFile ~/.ssh/id_rsa_i27academy
  IdentitiesOnly yes

# DevOps Batch Accounts
Host github-devops
  HostName github.com
  User git
  IdentityFile ~/.ssh/id_rsa_devops
  IdentitiesOnly yes
```

---

# 🧠 What Is Happening Here?

When you run:

```bash
ssh git@github-i27academy
```

SSH internally maps:

```
github-i27academy → github.com
Uses → id_rsa_i27academy
```

This prevents key confusion.

---

# 🧪 Step 4 – Test Both Accounts

---

### Test i27academy

```bash
ssh -T git@github-i27academy
```

Expected:

```
Hi i27academy! You've successfully authenticated...
```

---

### Test DevOps

```bash
ssh -T git@github-devops
```

Expected:

```
Hi i27devopsb8! You've successfully authenticated...
```

---

# 📦 Step 5 – Clone Using Correct Alias

---

## Clone i27academy Repo

```bash
git clone git@github-i27academy:i27academy/first-repo.git
```

---

## Clone DevOps Repo

```bash
git clone git@github-devops:i27devopsb8/i27-eureka.git
```

Future batch:

```bash
git clone git@github-devops:i27devopsb9/i27-eureka.git
```

---

# 🔄 Step 6 – Change Remote for Existing Repo

Inside repo:

---

### For i27academy

```bash
git remote set-url origin git@github-i27academy:i27academy/first-repo.git
```

---

### For DevOps

```bash
git remote set-url origin git@github-devops:i27devopsb8/i27-eureka.git
```

---

# 🔐 Permission Fix (If Needed)

If SSH gives error like:

```
bad permissions
```

Run:

```bash
chmod 600 ~/.ssh/id_rsa_i27academy
chmod 600 ~/.ssh/id_rsa_devops
```

---

# 📊 Visual Architecture

```
Your Machine
│
├── id_rsa_i27academy  → github-i27academy → github.com → i27academy account
│
└── id_rsa_devops      → github-devops     → github.com → devops batch accounts
```

No key replacement
No manual switching
No conflicts

---

#  Why This Is Enterprise Practice

This is exactly how:

* DevOps engineers manage personal + company GitHub
* Consultants manage multiple clients
* Cloud engineers manage production + staging accounts

---
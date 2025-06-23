## Job 1: Hello World – Basic Shell Execution

**Goal:** Show how Jenkins executes a simple shell command.

### Steps:

1. **New Item** → Name: `job-1-hello-world`
2. Select **Freestyle project** → Click **OK**
3. Under **Build Steps** → Add "Execute shell"
4. Paste the command:

   ```bash
   echo "Hello from Jenkins!"
   ```
5. **Save** → Click **Build Now**
6. View **Console Output**

> 🧠 Explains: Jenkins job basics + shell script section.

---

## Job 2: Git Clone via Shell – Manual Git Usage

**Goal:** Demonstrate running real commands (like `git clone`) and highlight that **Jenkins agents must have the required software installed.**

### Steps:

1. **New Item** → Name: `job-2-git-clone-shell`
2. Select **Freestyle project** → OK
3. Under **Build Steps** → Add "Execute shell"
4. Paste:

   ```bash
   echo "Cloning sample repo"
   git clone https://github.com/GoogleCloudPlatform/microservices-demo.git
   echo "Done!"
   ls -l
   ```
5. **Save** → **Build Now**

### ⚠️ Prerequisite:

Ensure `git` is installed on the Jenkins VM:

```bash
sudo apt install git -y
```

> 🧠 Explains: Jenkins is not magic — it depends on what's installed on the system.

---

## Job 3: GitHub Integration via Source Code Management (SCM)

**Goal:** Show how Jenkins can directly pull from GitHub without needing `git clone` manually in shell.

### Steps:

1. **New Item** → Name: `job-3-github-scm`
2. Select **Freestyle project** → OK
3. Scroll to **Source Code Management**
4. Choose **Git** and enter:

   ```
   https://github.com/GoogleCloudPlatform/microservices-demo.git
   ```
5. Leave credentials empty for public repo.
6. Under **Build Steps** → Add "Execute shell":

   ```bash
   echo "Code pulled from GitHub repo"
   ls -l
   ```
7. **Save** → **Build Now**

> 🧠 Explains: Real-world GitHub CI/CD pipelines begin here.

---

### Summary Table

| Job # | Name                  | Purpose                       | Key Learning                            |
| ----- | --------------------- | ----------------------------- | --------------------------------------- |
| 1     | job-1-hello-world     | Run basic shell command       | Jenkins job basics                      |
| 2     | job-2-git-clone-shell | Clone repo via shell manually | System dependency awareness (e.g., git) |
| 3     | job-3-github-scm      | Use GitHub as SCM source      | Jenkins + GitHub integration basics     |


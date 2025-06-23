
## Manage Jenkins – The Admin Control Center

> “Manage Jenkins” is the **backend dashboard** used to configure, maintain, and secure your Jenkins installation.

You can access it via:

```
http://<your-ip>:8080/manage
```

---


## ⚙️ Manage Jenkins – System Configuration

The **System Configuration** section is where administrators define the core setup of Jenkins. These settings impact how Jenkins behaves, looks, and integrates with your tools and infrastructure.

---

### 1. **System**

> **Purpose:** Configure global settings and essential paths used by Jenkins.

* Set **Jenkins URL**, which is used for links in emails and webhooks.
* Configure **email notifications** (SMTP).
* Define **environment variables** and shell paths.
* Add **system messages** to appear on the Jenkins home page (e.g., maintenance alerts).

---

### 2. **Tools**

> **Purpose:** Define the tools required by your jobs (e.g., Maven, Git, JDK).

* You can install tools automatically or specify custom installation paths.
* Most commonly configured tools:

  * JDK / Java
  * Git
  * Maven / Gradle
  * Docker CLI

---

### 3. **Plugins**

> **Purpose:** Extend Jenkins with additional features and integrations.

* Browse **Available Plugins**, **Installed**, **Updates**, and **Advanced** tabs.
* Use it to install:

  * GitHub Integration
  * Docker Plugin
  * Pipeline Plugin
  * Blue Ocean UI
* Some plugins may require a restart after installation.

---

### 4. **Nodes**

> **Purpose:** Manage Jenkins master and agent nodes (for distributed builds).

* Add or remove **agent machines** (physical or virtual).
* Monitor node status: online/offline, idle, or busy.
* Assign jobs to specific nodes using **labels**.


---

###  5. **Clouds**

> **Purpose:** Dynamically provision build agents from cloud providers.

* Connect Jenkins to **GCP, AWS, Azure**, Docker, or Kubernetes.
* Automatically launch agents when demand increases and shut down when idle.
* Requires plugins (e.g., Kubernetes, EC2, GCE agent plugins).


---

### 6. **Appearance**

> **Purpose:** Customize Jenkins’ UI/UX for a better experience.

* Change Jenkins branding, theme, or styling.
* Install plugins like **Simple Theme Plugin** for custom CSS.
* Update favicon, logos, etc., for a branded Jenkins setup.


## Manage Jenkins – Security Configuration

The **Security** section in Jenkins ensures that **only authorized users** can access, configure, and trigger builds. It also helps secure sensitive data like API tokens, credentials, and access keys.

---

### 1. **Security**

> **Purpose:** Configure how users authenticate and what they are allowed to do.

#### Key Features:

* **Security Realm**: Who can log in?

  * Jenkins’ own user database (default)
  * LDAP, Active Directory, GitHub, Google SSO, etc.
* **Authorization**: What can users do?

  * Matrix-based security (role-level control)
  * Project-based matrix
  * Logged-in users vs. anonymous

> 🧠 Remember: Without proper authorization, anyone can access Jenkins if left open.

---

###  2. **Credentials**

> **Purpose:** Securely store secrets like passwords, tokens, and SSH keys.

#### Credential Types:

* **Username & Password**
* **SSH Private Key**
* **Secret Text** (API tokens, webhook secrets)
* **Certificates**, **AWS/GCP access keys**, etc.

#### Scope Options:

* **Global**: Visible to all jobs
* **Folder/Project**: Scoped to a specific folder or job

---

### 3. **Credential Providers**

> **Purpose:** Decide which parts of Jenkins can **provide** or use credentials.

* Plugins may define credential providers (e.g., cloud plugins, SCM plugins).
* Controls visibility and scope of credentials in **pipelines, jobs, agents, plugins**.
* Helps secure external system integrations (e.g., GCP plugin using service account JSON).

💡 *Advanced Use:* Only needed when customizing security per integration/plugin.

---

### 4. **Users**

> **Purpose:** View and manage user accounts.

#### What You Can Do:

* View the list of registered users
* Add new users (if using Jenkins' own database)
* Reset or remove users
* See login activity and roles

---
## Manage Jenkins – Status Information

The **Status Information** section provides key insights into Jenkins’ current state — useful for **troubleshooting, system health monitoring, and debugging issues**.

---

### Why It Matters:

* Helps Jenkins admins **diagnose problems**
* Shows logs, thread dumps, environment variables, and more
* Critical for maintaining **CI/CD uptime and stability**

### 📋 1. **System Information**

> **Purpose:** Displays all environment variables, system properties, and JVM settings.

* Jenkins home directory
* OS details
* Java version
* Memory stats
* Environment variables
* Path to tools (e.g., Maven, Git)

---

### 2. **System Log**

> **Purpose:** View Jenkins logs for real-time error/debug information.

* Useful to **trace job failures**, plugin errors, permission issues
* Can add custom log recorders (e.g., for pipeline logs, Git plugin logs)
* Similar to checking `/var/log/jenkins/jenkins.log` on Linux

---

### 3. **Load Statistics**

> **Purpose:** Monitor how busy Jenkins is over time.

* Shows # of builds running, waiting, executing on agents
* Helps detect **bottlenecks or overloads**
* Useful when scaling Jenkins with multiple agents

💡 *Insight:* If queue keeps increasing, you may need more build agents.

---

### 4. **About Jenkins**

> **Purpose:** Gives information about jenkins versions


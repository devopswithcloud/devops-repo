
# Git Tags – Marking Important Milestones in Your Project

## What You Will Learn

1. What is a tag in Git?
2. Why and when tags are used
3. Types of tags: lightweight vs annotated
4. Commands: create, view, delete, push
5. Full hands-on demo: Tagging current & older commits
6. Real-world DevOps use of tags (release versions)

---

## What Is a Git Tag?

A **tag** in Git is like putting a **bookmark** on a specific commit.

> 📚 Example: You're studying a book. You place a sticky note on “Chapter 5 – Important Topic” so you can jump back to it later.
> 📌 Git tags let you mark versions like `v1.0`, `v2.0`, `release-jan`, etc.

---

## ✅ Why Use Tags?

* Mark **releases** (v1.0, v2.0)
* Highlight **milestones** (first stable version, beta release, bugfix)
* Create reference points for **deployments**
* Tags don’t change like branches — they are **static and permanent**

---

## 🧪 Types of Git Tags

| Tag Type        | Description                                          |
| --------------- | ---------------------------------------------------- |
| **Lightweight** | Just a label on a commit (like a branch name)        |
| **Annotated**   | Includes metadata: tagger name, email, date, message |

✅ **Use annotated tags** for any professional use like release tagging.

---

## 🔧 Common Git Tag Commands

| Action                   | Command                                         |
| ------------------------ | ----------------------------------------------- |
| Create lightweight tag   | `git tag v1.0`                                  |
| Create annotated tag     | `git tag -a v1.0 -m "Version 1.0 release"`      |
| View all tags            | `git tag`                                       |
| View tag details         | `git show v1.0`                                 |
| Tag an older commit      | `git tag -a v1.0 <commit-hash> -m "v1 release"` |
| Delete a local tag       | `git tag -d v1.0`                               |
| Push a single tag        | `git push origin v1.0`                          |
| Push all tags            | `git push origin --tags`                        |
| Delete a tag from remote | `git push origin --delete tag v1.0`             |

---

## 🧪 Hands-On Demo: Tagging in Real Life

### Step 1: Set Up a Sample Project with Multiple Commits

```bash
mkdir git-tag-demo
cd git-tag-demo
git init

echo "v1 - Initial feature" > app.txt
git add . && git commit -m "Initial commit - v1"

echo "v2 - Feature updated" >> app.txt
git add . && git commit -m "Added update - v2"

echo "v3 - Ready for release" >> app.txt
git add . && git commit -m "Final changes - v3"
```

---

### Step 2: View Commit History

```bash
git log --oneline
```

Sample Output:

```
e8f7c4d (HEAD -> main) Final changes - v3
a1d2b3f Added update - v2
3c4d5e6 Initial commit - v1
```

---

### Step 3: Tag the Latest Commit (v2.0)

```bash
git tag -a v3.0 -m "Version 3.0 release"
```

✅ This tags the current commit (`v3`).

---

### Step 4: Tag an Older Commit (v1.0)

```bash
git tag -a v1.0 3c4d5e6 -m "Version 1.0 release"
```

(Replace `3c4d5e6` with your actual commit ID from `git log`)

---

### Step 5: List and View Tag Info

```bash
git tag
git show v1.0
```

You’ll see:

* The commit message
* Tag message
* Author info and timestamp

---

### Step 6: Push Tags to Remote (Optional)

```bash
git push origin v1.0
git push origin v2.0
# or all at once
git push origin --tags
```

To delete a tag local
```bash
git tag -d v1.0
```
To delete a tag from remote:

```bash
git push origin --delete tag v1.0
```

---

##  Tag Comparison: Lightweight vs Annotated

| Feature       | Lightweight        | Annotated               |
| ------------- | ------------------ | ----------------------- |
| Metadata      | ❌ No               | ✅ Yes (name, date, msg) |
| Message       | ❌ No               | ✅ Yes                   |
| Git Usage     | Personal bookmarks | Releases, shared refs   |
| Best Practice | ❌ Avoid in teams   | ✅ Preferred for DevOps  |

---

## 🎓 Final Summary

| Concept               | Meaning                                     |
| --------------------- | ------------------------------------------- |
| Git Tag               | A label pointing to a specific commit       |
| Annotated Tag         | Tag with message and metadata (recommended) |
| Tagging Older Commits | Useful to mark earlier releases             |
| Tags are static       | You don’t edit them like branches           |
| Push tags manually    | Tags are not pushed by default to remotes   |

---

## 🚀 Real DevOps Use Cases

* Tag `v1.0` before your production deployment
* CI/CD pipelines can pick code based on tag
* Rollback easily by checking out a tagged commit:

  ```bash
  git checkout v1.0
  ```



#  Merge Conflicts in Git (And How to Fix Them)

---

## What You Will Learn

1. What is a merge conflict?
2. Why do conflicts happen?
3. What do conflict markers look like?
4. How to resolve a conflict manually
5. Commands: `git status`, `git add`, `git commit`, `git merge`
6. Full hands-on practice with a clear scenario

---

## What Is a Merge Conflict?

> Imagine two students editing the same sentence in a shared Google Doc — one writes "Hello world" and the other writes "Hi Earth" at the same spot. When they try to combine their versions… BOOM! ⚠️ Conflict.

Git doesn’t know **whose change to keep**, so it stops and asks **you** to fix it.

---

## When Do Merge Conflicts Happen?

* You try to merge one branch into another
* Both branches **modified the same line** in the same file

---

## Hands-On Demo – Triggering a Conflict

### Step 1: Set up project

```bash
mkdir merge-conflict-demo
cd merge-conflict-demo
git init

echo "Welcome to Git training." > index.txt
git add . && git commit -m "Initial commit"
```

---

### Step 2: Create and switch to a new branch

```bash
git switch -c feature-x
echo "This is a feature branch." > index.txt
git add . && git commit -m "Update in feature-x"
```

---

### Step 3: Go back to main and make a conflicting change

```bash
git switch main
echo "This is the main branch." > index.txt
git add . && git commit -m "Update in main branch"
```

---

### Step 4: Merge the feature branch into main

```bash
git merge feature-x
```

⚠️ Boom! You’ll see something like:

```
Auto-merging index.txt
CONFLICT (content): Merge conflict in index.txt
Automatic merge failed; fix conflicts and then commit the result.
```

---

## Step 5: Open the conflicted file

```bash
cat index.txt
```

You'll see:

```
<<<<<<< HEAD
This is the main branch.
=======
This is a feature branch.
>>>>>>> feature-x
```

---

##  What Does This Mean?

| Symbol         | Meaning                              |
| -------------- | ------------------------------------ |
| `<<<<<<< HEAD` | Your current branch's change (main)  |
| `=======`      | Divider between both changes         |
| `>>>>>>>`      | Incoming branch's change (feature-x) |

---

## Step 6: Manually Resolve the Conflict

Choose one of the versions, or combine them:

Example (merged version):

```
This is the main branch and also has a feature.
```

Then:

```bash
git add index.txt
git commit -m "Resolved conflict between main and feature-x"
```

✅ Conflict resolved and changes merged!

---

## Helpful Commands During Merge Conflicts

| Command             | Purpose                             |
| ------------------- | ----------------------------------- |
| `git status`        | See which files are in conflict     |
| `git diff`          | Compare conflicted files (optional) |
| `git log`           | See recent commits                  |
| `git merge --abort` | Cancel the merge and go back        |

---

##  Optional: Abort the Merge (Undo Everything)

```bash
git merge --abort
```

This cancels the merge and restores your files to how they were before the merge attempt.

---

## Real-World Merge Conflict Tips

* Conflicts are normal — don't panic!
* Communicate with your team when editing the same files
* Use smaller, focused branches to reduce conflicts
* Merge frequently to avoid large, messy conflicts

---

## 🎓 Final Summary

| Concept            | Explanation                                    |
| ------------------ | ---------------------------------------------- |
| Merge Conflict     | Happens when Git can't auto-combine changes    |
| Conflict Markers   | `<<<<<<<`, `=======`, `>>>>>>>` in the file    |
| Manual Resolution  | You edit the file and decide what to keep      |
| Complete the Merge | After resolving, do `git add` and `git commit` |
| Abort Merge        | Use `git merge --abort` to cancel the merge    |

---

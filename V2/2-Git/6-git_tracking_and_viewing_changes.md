
# Tracking and Viewing Changes in Git

In this section, we will cover how to track and view changes in a Git repository using three key commands: `git log`, `git diff`, and `git blame`. These tools help you inspect the history of changes in your project and understand who made what changes and when.

---

## 1. **git log**

`git log` is used to view the commit history of a repository. It shows details like the commit hash, author, date, and commit message.

### Common Usage:
- Basic commit history:
  ```bash
  git log
  ```

- Limit the number of commits shown:
  ```bash
  git log -n 5  # Shows the last 5 commits
  ```

- Display history in a one-line format:
  ```bash
  git log --oneline
  ```

---

## 2. **git diff**

`git diff` shows the differences between various Git objects, such as working directory changes, staged changes, or differences between commits.

### Common Usage:
- View unstaged changes:
  ```bash
  git diff
  ```

- View staged changes ready for commit:
  ```bash
  git diff --staged
  ```

- Compare two commits:
  ```bash
  git diff commit1 commit2
  ```

---

## 3. **git blame**

`git blame` allows you to see who last modified each line in a file. This is useful for tracking down when and why a particular change was made.

### Common Usage:
- View changes for a specific file:
  ```bash
  git blame filename
  ```

---

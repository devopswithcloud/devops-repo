
# Absolute Path vs Relative Path in Linux

Understanding the difference between absolute and relative paths is crucial when navigating and managing files in Linux. These concepts help you specify the location of files and directories.

---

## 1. Absolute Path

- **Definition**: An absolute path is a complete path from the root directory (`/`) to the target file or directory. It always starts with `/`, which represents the root.
- **Usage**: The absolute path remains the same regardless of your current working directory.
- **Example**:
  - `/home/siva/devopsmastery/project1`
  - `/var/jenkins/jobs/build_pipeline`

**Example command**:
```bash
cd /home/siva/devopsmastery   # Navigate to the 'devopsmastery' directory using the absolute path
ls /var/jenkins               # List the contents of the 'jenkins' directory using the absolute path
```

---

## 2. Relative Path

- **Definition**: A relative path specifies the location of a file or directory in relation to the current directory. It does not start with `/`, and the path can change based on the current directory.
- **Usage**: It is a more flexible and shorter way to navigate the file system when you know your current directory.
- **Symbols**:
  - `.`: Represents the current directory.
  - `..`: Represents the parent directory.
  
- **Example**:
  - If you're in `/home/siva`, a relative path to `devopsmastery` would be `./devopsmastery`.
  - To move up one directory and into `backup`: `../backup`.

**Example command**:
```bash
cd devopsmastery          # Change to the 'devopsmastery' directory relative to the current path
cd ../jenkins             # Move up one level, then navigate to the 'jenkins' directory
ls ./                     # List the contents of the current directory
```

---

## Differences Between Absolute and Relative Paths

| **Absolute Path**                                | **Relative Path**                                |
|--------------------------------------------------|--------------------------------------------------|
| Starts from the root directory `/`.              | Starts from the current directory.               |
| Always starts with a `/` (e.g., `/home/siva`).   | Does not start with `/` (e.g., `devopsmastery`). |
| Works the same, no matter where you are in the system. | Changes based on your current location in the file system. |
| Example: `/home/siva/devopsmastery`.             | Example: `./devopsmastery` or `../devopsmastery`. |

---

## Tips for Using Absolute and Relative Paths:

- **Absolute paths** are best for scripts or automation tasks where you want to avoid ambiguity and ensure consistency.
- **Relative paths** are useful for quick navigation when you’re working within a directory structure and want to avoid typing long paths.


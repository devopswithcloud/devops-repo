
# SSH Key Generation in Linux

SSH keys provide a secure way of logging into remote servers without needing a password. The keys are created in pairs: a **private key** (kept secret) and a **public key** (shared with the server).

---

### Using `ssh-keygen` to Generate SSH Keys

#### Basic Command to Generate SSH Keys:
```bash
ssh-keygen
```

This will generate a pair of SSH keys (`id_rsa` and `id_rsa.pub`) in the `~/.ssh` directory.

---

### Step-by-Step Guide

1. **Run the `ssh-keygen` Command**:
   ```bash
   ssh-keygen
   ```

   When prompted:
   - **Enter the file in which to save the key**: Press `Enter` to use the default location (`~/.ssh/id_rsa`).
   - **Enter a passphrase (optional)**: You can press `Enter` to skip creating a passphrase, but it’s recommended for additional security.

   Example output:
   ```
   Generating public/private rsa key pair.
   Enter file in which to save the key (/home/username/.ssh/id_rsa):
   Enter passphrase (empty for no passphrase):
   Enter same passphrase again:
   Your identification has been saved in /home/username/.ssh/id_rsa.
   Your public key has been saved in /home/username/.ssh/id_rsa.pub.
   The key fingerprint is:
   SHA256:ABC1234... username@hostname
   ```

2. **Verify the Keys**:
   After generation, you’ll find the following two files in the `~/.ssh/` directory:
   - **Private Key**: `id_rsa` (This file should be kept secure and private).
   - **Public Key**: `id_rsa.pub` (This file can be shared with the remote server).

3. **Copy the Public Key to the Remote Server**:
   To enable key-based SSH access to a remote server, you need to copy the public key (`id_rsa.pub`) to the server.

   Use the `ssh-copy-id` command:
   ```bash
   ssh-copy-id username@remote_host
   ```

   Example:
   ```bash
   ssh-copy-id siva@35.232.100.100
   ```

   If `ssh-copy-id` is not available, you can manually copy the public key:
   ```bash
   scp ~/.ssh/id_rsa.pub siva@35.232.100.100:/home/siva/.ssh/authorized_keys
   ```

4. **Login to the Remote Server Using SSH Key**:
   Once the public key is copied to the server, you can log in without needing a password:
   ```bash
   ssh siva@35.232.100.100
   ```

---

### Specifying Key Type and Bit Length

You can also specify the key type (e.g., RSA, DSA, ECDSA) and the bit length (e.g., 2048, 4096) during key generation:

- **Generate a 4096-bit RSA key**:
  ```bash
  ssh-keygen -t rsa -b 4096
  ```

- **Generate an ECDSA key**:
  ```bash
  ssh-keygen -t ecdsa
  ```

---

### Custom Key Name and Location

By default, the key is saved in the `~/.ssh/` directory. You can specify a custom file name and location for the key:

```bash
ssh-keygen -f /path/to/custom_key
```

This will save the private key as `custom_key` and the public key as `custom_key.pub`.

---

### Summary of `ssh-keygen` and Related Commands

| Command                              | Description                                          | Example                                          |
|--------------------------------------|------------------------------------------------------|--------------------------------------------------|
| `ssh-keygen`                         | Generate a new SSH key pair                          | `ssh-keygen`                                     |
| `ssh-copy-id user@host`              | Copy public key to the remote server                 | `ssh-copy-id siva@35.232.100.100`                |
| `ssh siva@host`                      | Log in to the remote server using the SSH key        | `ssh siva@35.232.100.100`                        |
| `ssh-keygen -t rsa -b 4096`          | Generate a 4096-bit RSA key                          | `ssh-keygen -t rsa -b 4096`                      |
| `ssh-keygen -f /path/to/custom_key`  | Generate a custom key pair at the specified location | `ssh-keygen -f /home/user/.ssh/my_custom_key`    |

---

This guide covers the usage of `ssh-keygen` for generating keys and securely connecting to remote servers.

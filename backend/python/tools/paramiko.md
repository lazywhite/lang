```
pip install -U pip setuptools
pip install paramiko cryptography
```

```
#!/usr/bin/python 
import paramiko
 
ssh = paramiko.SSHClient()
ssh.set_missing_host_key_policy(paramiko.AutoAddPolicy()) # host不在.ssh/known_hosts中的处理方法
ssh.connect("某IP地址",22,"用户名", "口令")
stdin, stdout, stderr = ssh.exec_command("你的命令")
print stdout.readlines()
ssh.close()


sftp = ssh.open_sftp()
sftp.listdir()
sftp.chdir()
```

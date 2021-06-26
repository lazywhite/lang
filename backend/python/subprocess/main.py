import subprocess

# 不需要输出
subprocess.call(["ls", "-al"], shell=False)
subprocess.call("ls -al", shell=True)

# 如果报错，会raise Exception
subprocess.check_call("ls -al", shell=True)
# 需要返回输出
output = subprocess.check_output("ls -al", shell=True)

out_string = output.decode("utf-8")

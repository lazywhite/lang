import subprocess
out = subprocess.check_output(['ls','-h'])
out_text = out.decode('utf-8')
print(out_text)

text = b'hello world'

p = subprocess.Popen(['wc'],stdout=subprocess.PIPE,stdin=subprocess.PIPE)
stdout, stderr = p.communicate(text)

print(stdout, stderr)

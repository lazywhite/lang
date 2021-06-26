# Devpi-server
## install devpi-server
```
pip install devpi-server
pip install devpi-web  # web interface plugin for devpi-server
```
## start devpi-server
```
devpi-server --start  ##generate devpi-server command
```
## stop devpi-server
```
devpi-server --stop
```
## check status
```
devpi-server --status
```
## recreate search index
```
devpi-server --stop
devpi-server --recreate-search-index
```
## multi-index
```
group/user multi-index
```
# Devpi-client
## install devpi
```
pip install devpi-client	#generate  devpi command
```
## use devpi-server
```
devpi use http://localhost:3141
devpi login root --password=''  #default password is None
devpi user -m root password=verysecurepassword
devpi list
devpi logoff
```
## create user
```
devpi user -c test password=test
```  
## delete user
```
devpi user --delete test
```
## create and use new index
```
devpi index -c dev [bases=root/pypi] 
#use the root/pypi cache as a base so that all of pypi.python.org packages will appear on that index
devpi use root/dev

```
## show using index
```
devpi use
```
## upload python module source code as pkg
```
cd example
devpi upload --no-vsc
```
## install module from current index
```
devpi install example
```
## test an uploaded module
```
devpi test example 
tox test tool
``` 
## stage a release to another index
```
devpi index -c staging volatile=False
devpi push example==1.0 testuser/staging
```

## index-configuration for pip
```
# $HOME/.pip/pip.conf
[global]
index-url = http://localhost:3141/root/pypi/+simple/

[search]
index = http://localhost:3141/root/pypi/
```

## install package in venv using devpi
devpi install --venv=v1 pytest

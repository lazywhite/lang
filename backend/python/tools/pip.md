## update pip
```
pip install -U pip setuptools
python -m pip install --upgrade pip
```

## update package
```
pip install -U <package> # 升级到最新版
pip install Django==1.5 # 安装指定版本

```
## output installed packages in requirements format
```
pip freeze > requirements.txt 
```

## requirements.txt
```
kubnernetes==10.0.0
pyramid>=1.4,<1.5
```

## cache requirements in local and install from local
```
alias pipcache='pip install --download ${HOME}/.pip-packages'
alias pipinstall='pip install --no-index --find-links=file://${HOME}/.pip-packages/'

pipcache Django==1.5 # Put Django-1.5.tar.gz in ~/.pip-packages
pipinstall Django==1.5 # Install ~/.pip-packages/Django-1.5.tar.gz
 
pipcache -r requirements.txt # Cache all the requirements of a project
pipinstall -r requirements.txt # Install all requirements from the cache
```

## virtualenv
```
virtualenv --always-copy --relocatable
```

## ~/.pip/pip.conf
```
[global]
index-url =  http://pypi.mirrors.ustc.edu.cn/simple
format = columns
[install]
trusted-host = pypi.mirrors.ustc.edu.cn
```

## install no clean
```
pip install --no-clean <>
pip install <> 失败后会默认执行clean，导致失败的日志被删除
```

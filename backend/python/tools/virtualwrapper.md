## Introduction
可配合pyenv使用, 需要为每个版本安装virtualenvwrapper包, 并source对应的virtualenvwrapper.sh

## Installation
```
pip install virtualwrapper
mkdir ~/.virtualenvs
cat >> .zshrc<<EOF
export WORKON_HOME=~/.virtualenvs
source /usr/local/bin/virtualenvwrapper.sh
EOF


lsvirtualenv
allvirtualenv

mkvirtualenv test
workon test
deactive

rmvirtualenv

cpvirtualenv <origin> <new>
<env> cdvirtualenv  cd ~/.virtualenvs/env
```

## Automaticlly activate venv

```
# ~/.zshrc

_virtualenv_auto_activate() {
    PWD=`pwd`
    if [ "$PWD" != "$MYOLDPWD" ]; then
        MYOLDPWD="$PWD"
        test -e '.venv' && workon `cat .venv`
    fi
}

precmd_functions+=(_virtualenv_auto_activate)

```

## 将virtualenv打包
```
(env)cdvirtualenv
virtualenv --relocatable .
env目录可直接拷贝使用

不能relocate env, 最好做出一个copy再relocate
```


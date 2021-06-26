## Installation

```
git clone https://github.com/yyuu/pyenv.git ~/.pyenv
echo 'export PYENV_ROOT="$HOME/.pyenv"' >> ~/.bash_profile
echo 'export PATH="$PYENV_ROOT/bin:$PATH"' >> ~/.bash_profile
echo 'eval "$(pyenv init -)"' >> ~/.bash_profile

source ~/.bash_profile

规定当前python版本
    /root/.pyenv/version
        2.7.9

```
## Usage
```
wget http://mirrors.sohu.com/python/2.7.9/Python-2.7.9.tar.xz
mv Python-2.7.9.tar.xz ~/.pyenv/cache/

yum -y install sqlite-devel # 防止no module named "_sqlite3"
pyenv install 2.7.9
pyenv global 2.7.9

pyenv install --list
```

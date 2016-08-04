## Installation
```
git clone git://github.com/sstephenson/rbenv.git ~/.rbenv
git clone https://github.com/sstephenson/ruby-build.git ~/.rbenv/plugins/ruby-build
git clone https://github.com/andorchen/rbenv-china-mirror.git ~/.rbenv/plugins/rbenv-china-mirror

# /root/.bash_profile
export PATH="$HOME/.rbenv/bin:$PATH"
eval "$(rbenv init -)"
```
## Usage
```
rbenv install --list
rbenv install 1.9.3-p392
rbenv global 1.9.3-p392

rbenv versions
rbenv version
rbenv local <version>  # set which version to use
```

## Gem sources
```
gem sources --add https://ruby.taobao.org/ --remove https://rubygems.org/
```

## compile
```
./configure --prefix=/usr/local/ruby-2.3.1 --with-openssl-dir=/usr --with-zlib-dir=/usr
```

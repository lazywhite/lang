## rbenv ##
git clone git://github.com/sstephenson/rbenv.git ~/.rbenv

export PATH="$HOME/.rbenv/bin:$PATH"
eval "$(rbenv init -)"

rbenv install --list
rbenv install 1.9.3-p392
rbenv global 1.9.3-p392

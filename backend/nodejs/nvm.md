## Installation
```
curl -o- https://raw.githubusercontent.com/creationix/nvm/v0.31.4/install.sh | bash
```

## Usage
```
nvm ls-remote # list remote version
NVM_NODEJS_ORG_MIRROR=https://npm.taobao.org/mirrors/node 

nvm install v6.2.1
nvm use v6.2.1
```

## Speed up npm install
```
npm install <package> --registry=https://registry.npm.taobao.org

~/.npmrc
    registry = https://registry.npm.taobao.org
```


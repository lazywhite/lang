npm update v-charts # 更新某个package
npm i -S v-charts # 安装包并添加依赖
npm install #fix missing package
npm install npm@latest -g # 升级npm

国内源
    npm install <package> --registry=https://registry.npm.taobao.org

    ~/.npmrc
        registry = https://registry.npm.taobao.org
设置代理

    ~/.npmrc
        proxy = http://ip:port
        https-proxy = http://ip:port

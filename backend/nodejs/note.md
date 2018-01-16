## 语法
```
全局对象
    console
    process
    setTimeout(cb, ms)
    clearTimeout(t)
    setInterval(cb, ms)
    __dirname
    __filename
    console
        dir(obj)
        log()
        clear()
        计时
            console.time('100-elements');
            for (let i = 0; i < 100; i++) {}
            console.timeEnd('100-elements');

        count([label])
            维护一个计数器, 不带参数为default, 带参数为相应label
数据类型
    typeof obj
        'string'
        'number'
        'object'
        'function'
循环
    for(var i=0;i<10;i++){}
    for(var key in row){}

常用模块
    os
        
    http
        get(url, response=>{})
    path
        resolve(__dirname, 'dist/index.html')
    fs
        readFile('./file.txt', function(err, data){})
        var str = readFileSync('./file.txt', 'utf-8').toString()
        writeFile('dest', data, callback)
        writeFileSync('dest', data)
    url
        parse() --> Url

类型检查
    typeof(object)
    object instanceof Class


匿名函数
    fs.readFile('src', (err, data)=>{console.log(data.toString())})
```
## Topic
```
inspector
    npm install -g node-inspector
    node-debug script.js
node debug script.js # 内置debug工具

process.argv # 访问命令行参数, 为list

事件跟踪
    node --trace-events-enabled --trace-event-categories v8,node server.js
```

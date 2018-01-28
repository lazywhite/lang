## 语法
```
全局对象
    console
    process
    module
    require
    setTimeout(cb, ms)
    clearTimeout(t)
    setInterval(cb, ms)
    setImmediate(cb,[...args])
    __dirname
    __filename
    console
        dir(obj)
        log()
        clear()
        assert(value[,message][,args])
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

模块系统
    circle.js
        第一种用法
            exports.PI = 3.14
            exports.getSize = function(){}

            var circle = require("circle");
            console.log(circle.PI)
        第二种用法
            module.exports = () =>{
                return {
                    area: (width)=> width ** 2,
                }
            }

            const Circle = require("circle");
            var circle = Circle()
            circle.area(100)

    检测是否为主程序
        require.main === module

    可以直接使用exports代替module.exports
    require.cache 存储被加载的模块映射, 删除key将会导致模块重新加载
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
函数变长参数
    function m(){console.log(arguments)}
    m(1, 2, 3)
```

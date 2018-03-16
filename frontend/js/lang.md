## Document
javascript是单线程的, 任何阻塞的操作将会阻塞整个页面  
JavaScript 拥有动态类型。这意味着相同的变量可用作不同的类型  
JavaScript 只有一种数字类型。数字可以带小数点，也可以不带  
JavaScript 变量均为对象。当您声明一个变量时，就创建了一个新的对象  
如果您把值赋给尚未声明的变量，该变量将被自动作为全局变量声明  
如果把数字与字符串相加，结果将成为字符串  
  
JavaScript 不会到 ```<style> ```标签或者 ```<link>``` 文件去获取相应的样式，只能获取 style 属性定义的样式  

## Map and method
```
javascript对象的属性必须是字符串, map的key可以是任意类型(包含object)

var m = new Map()
m.set("key", "value")
m.set(0, 1000)
m.size
m.get("key")


var b = new Map([
    ["k1", "v1"],
    ["k2", "v2"],
])
b.has("k1") # in test
b.clear()
b.delete("k1")

b.forEach(function(value, key){  // value在前
    console.log("key: %s, value: %s", key, value);
})
```
## Set and method
```
var s = new Set();
var s = new Set([1, 2, 3]);
s.size
s.add(10) # 添加成员
s.has(10) # 成员检测
s.forEach(function(){}) # 遍历
s.delete(10) # 删除成员
s.clear() # 清空set
```

## String and method
  
```
1.length
    var txt = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    var len = txt.length;
2. find index 
    var str = "Please locate where 'locate' occurs!";
    var pos = str.indexOf("locate");
    var lastpos = str.lastIndexOf("locate");
    var searchpos = str.search("locate");
    
3. slice
    var str = "Apple, Banana, Kiwi";
    var res = str.slice(7,13);
    var res = str.slice(-12,-6);
    var res = str.slice(7);
4. substring  (just like slice, but can't accept neative arguments)
    var str = "Apple, Banana, Kiwi";
    var res = str.substring(7,13);
5. substr(second parameter specifies the length of the extracted part)
    var str = "Apple, Banana, Kiwi";
    var res = str.substr(7,6);
6. replace 
    str = "Please visit Microsoft!";
    var n = str.replace("Microsoft","W3Schools");
7. case convert
    var text1 = "Hello World!";       // String
    var text2 = text1.toUpperCase();
    var text3 = text1.toLowerCase();
8. concat 
    var text1 = "Hello";
    var text2 = "World";
    text3 = text1.concat("  ",text2);
9. charAt (return the character at a specified index)
    var str = "HELLO WORLD";
    str.charAt(0);  --> 'H'
10. split (convert a string into an array)
    var txt = "a,b,c,d,e";   // String
    txt.split(",");  // ['a', 'b', 'c', 'd', 'e']
```
  
## Number method
  
```
1. toString (convert a number to string)
    var x = 123;
    x.toString();
2. toPrecision 
    var x = 9.123;
    x.toPrecision(2)  --> 9.12
3. Convert variables to Numbers
    # using Number
    x = true;
    Number(x);        // returns 1
    x = false;     
    Number(x);        // returns 0
    x = new Date();
    Number(x);        // returns 1404568027739
    x = "10"
    Number(x);        // returns 10
    x = "10 20"
    Number(x);        // returns NaN
    # using parseInt
    parseInt("10");         // returns 10
    parseInt("10.33");      // returns 10
    parseInt("10 20 30");   // returns 10
    parseInt("10 years");   // returns 10
    parseInt("years 10");   // returns NaN 

    # using parseFlaot
    parseFloat("10");        // returns 10
    parseFloat("10.33");     // returns 10.33
    parseFloat("10 20 30");  // returns 10
    parseFloat("10 years");  // returns 10
    parseFloat("years 10");  // returns NaN
4. Number Property
    MAX_VALUE   Returns the largest number possible in JavaScript
    MIN_VALUE   Returns the smallest number possible in JavaScript
    NEGATIVE_INFINITY   Represents negative infinity (returned on overflow)
    NaN Represents a "Not-a-Number" value
    POSITIVE_INFINITY   Represents infinity (returned on overflow)
5. Math
    1. Math.random()
    2. Math.min(), Math.max()
    3. Math.round(4.7) --> round a number to the nearest integer
    4. Math.ceil(), Math.floor()
    5. Math.E, Math.PI
```
  
## Date and method
  
```
1. Date
    var d = new Date()
    d.toString()
    d.toUTCString()
    d.toDateString()
    var d = new Date('2015-03-24')
    var d = new Date('2015-03')
    var d = new Date("2015-03-25T12:00:00");  
    var d = new Date("03/25/2015");
    var d = new Date("2015/03/25");
    
2. Date method
    getDate()
    getDay() --> get weekday 
    getFullYear() -->  yyyy
    getHours() --> 0-23
    getMinutes() --> 0-59
    getMonth() --> 0-11
    getSeconds() --> 0-59
    getTime() --> timestamp (number)
```
      
## Array and method
  
```
1. Array (can store differente type of variables in same array)
    1. declare an array
        var cars = ["Saab", "Volvo", "BMW"];
        var cars = new Array("Saab", "Volvo", "BMW"); 
        console.log(cars[0]) --> array variables can be accessed by index
    2. properties and methods
        var x = cars.length
        var y = cars.sort()
    3. convert to string
        cars.toString()
    4. pop element from last
        cars.pop()
    5. pop element from start
        cars.shift()
    6. add element from start
        cars.unshift('element')
    7. add element at last
        cars.push("lemon");
    8. del element
        delete cars[3] --> cars[3] become undefined
    9. splice
        cars.splice(<start position><number of removed elementn> [<new1> <new2>])
    10. sort (sort values as strings by default, can't sort number correctly)
        cars.sort()
        1. how to sort an array of number 
            var points = [40, 100, 1, 5, 25, 10];
            points.sort(function(a, b){return a>b});
    11. join arrays
        var myGirls = ["Cecilie", "Lone"];
        var myBoys = ["Emil", "Tobias","Linus"];
        var myChildren = myGirls.concat(myBoys); 
```
  
## Boolean        
  
```
var x = 0
Boolean(x) --> false
var x = null
Boolean(x) --> false
var x = ""
Boolean(x) --> false
var x = NaN
Boolean(x) --> false
```
  
## RegExp
  
```
var str = "Visit W3Schools";
var n = str.search(/w3schools/i);
```
  
## Topics    
  
```
1. tips
    All JavaScript objects have the valueOf() and toString() methods.
    var x = 10;
    x.constructor
    x instanceof  Number
    === equal value and equal type
    !== not equal value or not equal type

2. Avoid Global Variables Always Declare Local Variables  
3. Initialize Variables 
4. Never Declare Number, String, or Boolean Objects 
5. Don't Use new Object()
    Use {} instead of new Object()
    Use "" instead of new String()
    Use 0 instead of new Number()
    Use false instead of new Boolean()
    Use [] instead of new Array()
    Use /()/ instead of new RegExp()
    Use function (){} instead of new Function()
6. Beware of automatic type conversion
    var x = 5 + 7;       // x.valueOf() is 12,  typeof x is a number
    var x = 5 + "7";     // x.valueOf() is 57,  typeof x is a string
    var x = "5" + 7;     // x.valueOf() is 57,  typeof x is a string
    var x = 5 - 7;       // x.valueOf() is -2,  typeof x is a number
    var x = 5 - "7";     // x.valueOf() is -2,  typeof x is a number
    var x = "5" - 7;     // x.valueOf() is -2,  typeof x is a number
    var x = 5 - "x";     // x.valueOf() is NaN, typeof x is a number
7. Use Parameter Defaults 
    If a function is called with a missing argument, the value of the missing argument is set to undefined.
8. End your switch with defaults
9. Avoid using eval()
```
  
# BOM(browser object model)

## Timing
  
```
1. setTimeout(callback, <time in milliseconds>) 
    var myVar = setInterval(function(){ myTimer() }, 1000);
    clearInterval(myVar);

2. setInterval(callback, <time>) 
3. scrollTo(xPos, yPos)
4. var person = prompt("Please enter your name", "Harry Potter");
5. confirm("press a button")
```
  
## Navigator object
  
```
navigator.platform
navigator.userAgent
navigator.geolocation
```
  
## Screen
  
```
screen.height
screen.width
```
  
## History
  
```
history.back()
history.forward()
history.go()
```
  
## Location
  
```
location object contains information about the current URL
location.href --> <protocol>+<hostname>+<path>
location.hostname --> www.demo.com
location.pathname --> /js/demo.asp
location.protocol --> http, https
location.assign --> load a new document in current window
```

## Object
```
Object.keys(obj) --> [key1, key2]
Object.values(obj) --> [value, value2]
Object.assign(target, ...source) -> 将source内的所有属性复制给目标对象
Object.entries()
Object.freeze(obj) -> 对象所有属性都不能被更改
Object.defineProperty(obj, 'key', descriptor)
Object.defineProperties()
```
  
## Cookie
  
```
var x = document.cookie
document.cookie = "username=John Doe; expires=Thu, 18 Dec 2013 12:00:00 UTC; path=/";
```
  

## Prototype
  
All JavaScript objects inherit their properties and methods from their prototype.
  
```
function Person(first, last, age, eyecolor) {
    this.firstName = first;
    this.lastName = last;
    this.name = function() {return this.firstName + " " + this.lastName;};
}
var myFather = new Person("John", "Doe", 50, "blue");
var myMother = new Person("Sally", "Rally", 48, "green");
Person.nationality = "English";

```


## Topic
### 1. 闭包
```
定义在函数内部的函数, 用来读取内部变量

function f1(){
　　var n=999;
　　nAdd=function(){n+=1}
　　function f2(){
　　　　alert(n);
　　}
　　return f2;
}
var result=f1();
result(); // 999
nAdd();
result(); // 1000
```
### 2. set break point
```
debugger;
```
### 3. change current url
```
window.location.href = url;
```
### 4. get element attribute
```
ele.getAttribute("attr_name");
btn.value
```
### 5. call printer
```
onclick="window.print()"
```

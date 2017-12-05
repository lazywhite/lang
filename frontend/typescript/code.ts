enum Color{
    RED, GREEN, BLUE
}
class Student{
    fullName: string;
    // 构造函数
    constructor(public firstName:string, public middleName:string, public lastName:string){
        this.fullName = firstName + " " + middleName + " " + lastName;
    }
    greet(){
        return "Hello, this is " + this.fullName; 
    }
}
interface Person{
    firstName?: string; // 可选属性
    readonly lastName: string; //只读属性
}
//类型注释
function greeter(person:Person){
    return "Hello " + person.firstName + " " + person.lastName;
}
//let user = {firstName: "Jane", lastName: "Mollld"};
let user = new Student("Jane", "M.", "Molled");
console.log(user.greet());

//只要类型的内部结构兼容某个接口即可, 不必显式使用implements 
document.body.innerHTML = greeter(user)


//数据类型
let  isDone:boolean = false;
let decimalNum: number = 6;
let hexNum: number = 0x182;
let octalNum: number = 0o744;
//let binNum: number = 0b744;
//数组
let list: Array<number> = [1, 2, 3];
let list1: number[] = [1, 2, 3];
let list2: any[] = [1, 2, 3];
//元组
let x: [string, number];   
x = ['hello', 0]
console.log(x[0])
console.log(x[1])

// 枚举
let color: Color = Color.RED


let notSure: any = 4;
console.log(notSure)
notSure = "string "
console.log(notSure)
notSure = false;
console.log(notSure)

// Object类型的变量可以赋任意值, 但不能调用任何方法
//let prettySure: Object = 4;
//prettySure.toFixed();

// void 类型的变量只能赋值undefined , null
// undefined , null可以被赋值给任意类型
function warnUser():void{
    alert("this is a warning message");
}

let unusable: void = undefined;
let unusable2: void = null;
//never, 永远不会有返回值
function error(message: string): never{
    throw new Error(message);
}
function fail(){ //自动推断为never
    return error("error occured");
}
function infinitLoop():never{
    while(true){

    }
}

//类型断言只在编译时起作用, 类似于类型转换
let someValue: any = "this is string"
console.log(typeof someValue);
let strLen: number = (someValue as string).length

//let 实现变量的块级作用域
// const  定义常量
const a:boolean = true;

console.log(a);

interface SearchFunc{
    (source: string, subString: string): boolean;
}
let mySearch : SearchFunc;
mySearch = function(source:string, subString:string){
    let result = source.search(subString);
    return result > -1;
}

interface Shape{
    color: string;
}
interface PenStroke{
    penWidth: number;
}
//接口支持多重继承
interface Square extends Shape, PenStroke{
    sideLength: number;
}
let square = <Square>{};
square.color = "blue";
square.sideLength = 10;
square.penWidth = 10;

interface Counter{
    (start: number):string;
    interval: number;
    reset():void;
}
function getCounter():Counter{
    //let counter = <Counter>function(start:number){}
    let counter = (function(start:number){} as Counter);
    counter.interval = 32;
    counter.reset = function(){};
    return counter;
}
let c = getCounter()
c(10)
c.reset()
c.interval = 5.0;

//迭代元素
for (let i in list){
    console.log(i);
}
for (let i of list){
    console.log(i);
}

//导出
/*
模块使用模块加载器导入其他模块,
没用export导出的成员在外部默认是不可见的
export声明和export语句(可以重命名)

export class Test{}
export {ZipCodeValidator as RegExpBasedZCV} from './ZipCodeValidator';

export * from './StringValidator';
export * from './LetterValidator';
export * from './NumberValidator';


exports对象, 包含一个模块所有的导出内容
*/

//导入 /*
import {ZipCodeValidator} from "./ZipCodeValidator";
let myV = new ZipCodeValidator()
import {ZipCodeValidator as ZCV} from "./ZipCodeValidator";
let myV = new ZCV()
import * as validator from "./ZipCodeValidator";
let myV = new validator.ZipCodeValidator()

import "./my-module.ts"; // 使用模块的side effect

*/
/*
/// <reference path="..."/> 
仅可放在文件的最顶端, 注释的内容被作为编译器指令使用
*/
/*
// 默认导出, 可以是一个值, function, class等
export default function(s:string):void{}
// 默认导入 ,无需加{}
import testFunc from "./module";
*/
/*
export = ZipCodeValidator;
import zip = require("./ZipCodeValidator");
*/

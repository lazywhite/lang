//3 basic types in typescript
let isDone: boolean = false;
let lines: number = 42;
let test_name: string = "anders";

// define a letiable may in 'any' type
let notSure: any = 4;

notSure = "maybe a string instead";
notSure = false;

console.log(isDone);
console.log(lines);
console.log(test_name);
console.log(notSure);
// collections
// 1. typed array
let typed_list: number[] = [1, 2, 3];

// 2. generic array
let generic_list: Array<number> = [1, 2, 3];

console.log(typed_list);
console.log(generic_list);

// Enumeration
enum Color { 
    Red, 
    Green, 
    Blue,
}
var test_color: Color = Color.Green;
console.log(test_color);

// void
function return_nothing(): void {
    console.log("I'm a little annoying box!");
}
return_nothing()


// Functions 
var f1 = function(i: number): number{
    return i * i;
}

var f2 = function(i: number) {
    return i * i;
}
var f3 = (i: number): number => { return i * i;}
var f4 = (i: number) => { return i * i;}

var f5 = (i: number) => i * i;

console.log(f1(100));
console.log(f2(200));
console.log(f3(300));
console.log(f4(400));
console.log(f5(500));


// Interface, properties is seperated by ";"
interface Person {
    name: string;
    age?: number; // optional property
    move(): void;
}

// actual interface  is an "object", properties seperated by ","
var p: Person = {
    name: 'Bob',
    move: () => {}, 
}

var validPerson: Person = {
    name: "volidPerson", 
    age: 42,
    move: () => {},
}

/*
var invalidPerson: Person = {
    name: "invalidPerson",
    age: true, //will get an error: boolean is not assignable to number
}
*/

// interfaces can alse describe a function type
// only the parameters' type are important, name are no important
interface SearchFunc {
    (source: string, subString: string): boolean;
}

var mySearch: SearchFunc;
mySearch = function(src: string, sub: string) {
    return src.search(sub) != -1;
}

// Class
class Point {
    x: number;
    constructor(x: number, public y: number = 1){
        this.x = x;
        this.y = y;
    }
    dist() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }
    static origin = new Point(0, 0);
}

var point01: Point = new Point(10, 20)
var point02: Point = new Point(10)
console.log(point01.y)
console.log(point02.y)

class Point3D extends Point {
    constructor(x: number, y: number, public z: number = 0){
        super(x, y)
    }
    dist() {
        var d = super.dist();
        return Math.sqrt(d * d + this.z * this.z);
    }
}

// Internal Module
module Geometry {
    export class Square {
        constructor(public sideLength: number = 0) {
        }
        area() {
            return Math.pow(this.sideLength, 2);
        }
    }
}
var s1 = new Geometry.Square(5)
console.log(s1.area());
import G = Geometry;
var s2 = new G.Square(10)
console.log(s2.area());


// Generics Class
class Tuple<T1, T2> {
    constructor(public item1: T1, public item2: T2){
    }
}

interface Pair<T> {
    item1: T;
    item2: T;
}

var my_pair: Pair<number>  = {
    item1: 10,
    item2: 20
}
console.log(my_pair.item1)

var another_pair: Pair<string>  = {
    item1: 'hello',
    item2: 'world',
}
console.log(another_pair.item2)
var point03: Point3D = new Point3D(3, 4, 5)
console.log(point03.z)
console.log(point03.dist())

console.log(mySearch('hello', 'll'));
console.log(p.name)
console.log(validPerson.name)
//console.log(invalidPerson.name)
import * as local from "./test";
console.log(local.local_var)

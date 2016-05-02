"use strict";
var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
//3 basic types in typescript
var isDone = false;
var lines = 42;
var test_name = "anders";
// define a letiable may in 'any' type
var notSure = 4;
notSure = "maybe a string instead";
notSure = false;
console.log(isDone);
console.log(lines);
console.log(test_name);
console.log(notSure);
// collections
// 1. typed array
var typed_list = [1, 2, 3];
// 2. generic array
var generic_list = [1, 2, 3];
console.log(typed_list);
console.log(generic_list);
// Enumeration
var Color;
(function (Color) {
    Color[Color["Red"] = 0] = "Red";
    Color[Color["Green"] = 1] = "Green";
    Color[Color["Blue"] = 2] = "Blue";
})(Color || (Color = {}));
var test_color = Color.Green;
console.log(test_color);
// void
function return_nothing() {
    console.log("I'm a little annoying box!");
}
return_nothing();
// Functions 
var f1 = function (i) {
    return i * i;
};
var f2 = function (i) {
    return i * i;
};
var f3 = function (i) { return i * i; };
var f4 = function (i) { return i * i; };
var f5 = function (i) { return i * i; };
console.log(f1(100));
console.log(f2(200));
console.log(f3(300));
console.log(f4(400));
console.log(f5(500));
// actual interface  is an "object", properties seperated by ","
var p = {
    name: 'Bob',
    move: function () { }
};
var validPerson = {
    name: "volidPerson",
    age: 42,
    move: function () { }
};
var mySearch;
mySearch = function (src, sub) {
    return src.search(sub) != -1;
};
// Class
var Point = (function () {
    function Point(x, y) {
        if (y === void 0) { y = 1; }
        this.y = y;
        this.x = x;
        this.y = y;
    }
    Point.prototype.dist = function () {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    };
    Point.origin = new Point(0, 0);
    return Point;
}());
var point01 = new Point(10, 20);
var point02 = new Point(10);
console.log(point01.y);
console.log(point02.y);
var Point3D = (function (_super) {
    __extends(Point3D, _super);
    function Point3D(x, y, z) {
        if (z === void 0) { z = 0; }
        _super.call(this, x, y);
        this.z = z;
    }
    Point3D.prototype.dist = function () {
        var d = _super.prototype.dist.call(this);
        return Math.sqrt(d * d + this.z * this.z);
    };
    return Point3D;
}(Point));
// Internal Module
var Geometry;
(function (Geometry) {
    var Square = (function () {
        function Square(sideLength) {
            if (sideLength === void 0) { sideLength = 0; }
            this.sideLength = sideLength;
        }
        Square.prototype.area = function () {
            return Math.pow(this.sideLength, 2);
        };
        return Square;
    }());
    Geometry.Square = Square;
})(Geometry || (Geometry = {}));
var s1 = new Geometry.Square(5);
console.log(s1.area());
var G = Geometry;
var s2 = new G.Square(10);
console.log(s2.area());
// Generics Class
var Tuple = (function () {
    function Tuple(item1, item2) {
        this.item1 = item1;
        this.item2 = item2;
    }
    return Tuple;
}());
var my_pair = {
    item1: 10,
    item2: 20
};
console.log(my_pair.item1);
var another_pair = {
    item1: 'hello',
    item2: 'world'
};
console.log(another_pair.item2);
var point03 = new Point3D(3, 4, 5);
console.log(point03.z);
console.log(point03.dist());
console.log(mySearch('hello', 'll'));
console.log(p.name);
console.log(validPerson.name);
//console.log(invalidPerson.name)
var local = require("./test");
console.log(local.local_var);

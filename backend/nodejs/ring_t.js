var ring = require('ring')
/*
//class defination 
var A = ring.create({
    constructor: function(name) {
        this.name = name;
    },
});
var a = new A("Nicolas");
console.log(a.name); // prints "Nicolas"

//inherit 
var A = ring.create({
    x: function() {
        return "x";
    },
});
var B = ring.create({
    y: function() {
        return "y";
    },
});

var C = ring.create([A, B], {});

var c = new C();
console.log(c.x()); // prints "x";
console.log(c.y()); // prints "y";
*/
//super method
var A = ring.create({
    sayHello: function(name) {
        return "Hello " + name;
    },
});
var B = ring.create([A], {
    sayHello: function(name) {
        return this.$super(name) + ", nice to meet you";
    },
});

var b = new B();
console.log(b.sayHello("Nicolas")); // prints "Hello Nicolas,nice to meet you"

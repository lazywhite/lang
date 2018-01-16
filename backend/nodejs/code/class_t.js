/*
ES6 类与继承
*/
class People{
    constructor(code, data){
        this.code  = code;
        this.data  = data;
    }
    getData(){
        return this.data;
    }
    setData(data){
        this.data = data;
    }
}

class Human extends People{
    constructor(name, code, data){
        super(code, data);
        this.name = name;
    }

}
var p = new People('t1', 't2')
console.log(p)

var h = new Human('bob', 't1', 't2')
console.log(h)

/*
 * 经典类
 */
var User = function(){
    name: null;
    age: null;
    this.setName = function(name){
        this.name = name;
    };
}

User.prototype.category = 'people'
User.prototype.greet = function(){
    console.log('this is ' + this.name);
}

var u = new User()
u.name = 'bob'
u.age = 10
u.setName('alex')
u.greet()

console.log(u);
console.log(u.category);
console.log(u instanceof User)
console.log(typeof(u))


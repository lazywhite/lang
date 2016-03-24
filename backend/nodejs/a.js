function User(name, age){
    this.name = name;
    this.age = age;
}
var u1 = new User('bob', 123)
var u2 = new User('wb', 123)
for (value in u1){
    console.log(value + ': ' + u1[value])
}

var users = [u1,u2];
console.log(users);
for (index  in users){
    user = users[index];
    console.log(user.name);
//    console.log(user.name);
}



function test(obj, name){
    obj.name = name
}
test(u1, 'bbbbbb')
console.log(u1.name)


var fs = require('fs')

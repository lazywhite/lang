function hello(){
    console.log('hello')
}

function world(){
    console.log('world')
}

var MyModule = exports
MyModule.hello = hello
MyModule.world = world


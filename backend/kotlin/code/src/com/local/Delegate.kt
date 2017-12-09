package com.local

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class Example{
    // 属性托管
    var p:String by Delegate()
    override fun toString():String{
        return "com.local.Example class"
    }

    // 属性onchange handler
    var name: String by Delegates.observable("no name") {
        d, old, new ->
        println("$d: $old - $new")
    }

    // 通过返回boolean来决定是否否决新的属性值
    var finalName: String by Delegates.vetoable("no name"){
        d, old, new ->
        if (new == "good"){
            false
        }
        true
    }

    // not null property
    var age:Int by Delegates.notNull()
    fun init(age:Int){
        this.age = age
    }
}

class Delegate(){
    operator fun getValue(thisRef: Any?, prop: KProperty<*>):String{
        return "$thisRef, thank you for delegating ${prop.name} to me!"
    }

    operator fun setValue(thisRef: Any?, prop: KProperty<*>, value:String){
        println("${value} has been assigned to ${prop.name} in $thisRef")
    }
}
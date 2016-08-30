#!/usr/bin/env scala

object HelloWorld extends App {
    println("Hello, world!")

    println(2 + 1)
    val three = 2 + 1 // variable 
    println(three)
    val name = "John"
    println(three)
    println(addOne(3))
    println(((x: Int) => x+1)(10)) //anonymous function
    println(timesTwo(10))
    val calc = new Calculator
    println(calc.add(1, 2))
}

// fucntion
def addOne(m: Int): Int = m + 1

// function with multi phrase
def timesTwo(i: Int): Int = {
  println("return number times 2")
  i * 2
}

// class
class Calculator {
  val brand: String = "HP"
  def add(m: Int, n: Int): Int = m + n
}

HelloWorld.main(args)

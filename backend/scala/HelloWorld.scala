class Greeter(prefix:String, suffix:String){
  def greet(name:String){
    println(prefix + name + suffix)
  }
}

case class Point(x:Int, y:Int)

val p1 = Point(1, 2)
val p2 = Point(2, 4)

println(p1 == p2)

val greeter = new Greeter("hello ", "!");
greeter.greet("bob")

object IdFactory{
  private var counter = 0
  def create():Int = {
      counter += 1
      counter

  }
}

var id1 = IdFactory.create()
var id2 = IdFactory.create()
println(id1 )
println(id2 )

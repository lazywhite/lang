import java.util.{Date, Random}
object Main{
  def ct(value:Int):String = {
    value match {
      case 1 => "hehe"
      case 2 => "haha"
      case _ => "default"
    }

  }
  case class Person(name:String, age:Int)

  trait General{
    val share: String = "shared"
    def alive: Unit
    def move(x:Int, y:Int):Unit = {
      println(s"moving to $x:$y")
    }
  }
  trait Bark{
      def bark: Unit = {println("woo woo")}
  }
  trait Hear{
      def hear: Unit = {println("heared something")}
  }
  class Dog(name:String) extends Bark with Hear with General{
    def greet:Unit = {
      println(s"I'm $name")
    }
    def alive:Unit = {
      println("I'm is alive")
    }
  }
  def main(args: Array[String]){
    val p = Person("bob", 10);
    val p1 = p.copy()
    val p2 = p.copy(name = "alice")
    println (p2.age)
    println(s"p1 equals p: ${p1 == p}")
    val parts = Person.unapply(p1).get
    println (parts)

    var dog = new Dog("coco")
    dog.bark
    dog.move(10, 20)
    dog.greet
    dog.hear
    println(dog.share)
    dog.alive

    println(ct(1))

    val tuple = (1, "hello", Some)
    val tuple3 = new Tuple3(1, "hello", Some)
    println(tuple._1)
    println(tuple3._2)
    val tuple2 = ("bob", 20)
    println(tuple2.swap) //只能Tuple2才能使用swap

    val myMap = Map("x"->"bob", "y"->"alice", 100 -> "test")
    println(myMap("x"))
    println(myMap(100)) // key的类型不必一致
    val newMap = myMap - "x"
    //val newMap = myMap -- List("x", "y")
    //val newMap = myMap - ("x", 100) 
    println(newMap.contains("x"))

    val mySet = Set("Michigan", "Ohio", "Wisconsin", 12)
    println(mySet.size)
    println(mySet.contains("Ohio"))
    val newSet = mySet - "Ohio"

    var name = "bob"
    var greeting = "hello %s"
    println(greeting.format(name))

    val a = Array("hello", "to", "you", "again")
    val filtered = a.filter(_.length > 3)
    println(filtered.size)

    val s = {for(v <- 1 to 3) yield v}.toArray
    println(s.size)

    val d = new Date()
    println(d)
    val r = new Random()
    println(r.nextInt())
  }

}


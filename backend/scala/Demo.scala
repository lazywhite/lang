object Demo{
  def main(args: Array[String]){
    var myVar: Int = 10;
    val myVal: String = "greeting";
    println(myVar)
    println(test("blb"))
    test2(10, 20)
    var greeter = new Greeter("hello", "!")
    greeter.greet("bob")
  }

  def test(a:String): String = {
    return a + "test";
  }
  def test2(a:Int, b:Int) = {
    println(a + b)
  }
}

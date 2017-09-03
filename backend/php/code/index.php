<?php
/**
 * Short description for index.php
 *
 * @package index
 * @author white <white@Whites-Mac-Air.local>
 * @version 0.1
 * @copyright (C) 2017 white <white@Whites-Mac-Air.local>
 * @license MIT
 */
namespace ns\foo;

require("ns.php");
use \ns\foo\sub\A as B;

$a1 = new B("good");
echo $a1->name;

$a2 = new sub\A("bad");
echo $a1->name;


interface CanRead{
    public function read();
}
interface Alive{
    const VAR = 200;
    public static function do();
}

class People{
    public $name;
    protected $age;
    public static $cls = "people";
    public function __construct($name, $age){
        $this->name = $name;
        $this->age = $age;
    }

    public static function info(){
        echo "this is static function";
    }
    public function greet(){
        echo "my name is $this->name", "<br />";
        echo "method name is, ", __METHOD__, "<br />";
        echo "class name is ", __CLASS__, "<br />";
    }
}


class Student extends People implements CanRead, Alive{
    private $birthday;
    public function __construct($name, $age, $birthday){
        parent::__construct($name, $age);
        $this->birthday = $birthday;
    }

    /*
    public function __destruct(){
        echo "instance of Student is destroied" , "<br />";
    }
     */

    public function setBirthday($birthday){
        $this->birthday = $birthday;
    }
    public function getBirthday(){
        return $this->birthday;
    }

    public function read(){
        echo "Student is reading";
    }

    public function greet(){
        parent::greet();
        echo "hello, I'm a student";
    }

    public static function do(){
        echo "Student is doing";
    }

    public function __call($method, $args){
        echo $method . "<br />";
        print_r($args);
    }
    public function __toString(){
        return "Student: " . $this->name;
    }

}


Student::info();

$s1 = new Student("bob", 1234, "1921-01-01");
var_dump($s1);
echo "<br />";
echo $s1::VAR;
echo "<br />";

$s1->read();
$s1->greet();
$s1->talk(1, 2);
$s1::do();
echo "<br />";
echo $s1;
echo "<br />";

if($s1 instanceof Student){
    echo "s1 is instance of Student";
}
if(is_subclass_of('Student', 'People')){
    echo "Student is subclass of People";
}


function sum($name, ...$args){
    echo $name;
    return array_sum($args);
}

echo "<br />";
echo sum("bob", 1, 2, 3);

echo __LINE__;
echo __FILE__;


abstract class Animal{
    public static $var = 100;
    public abstract function move();
}

class Dog extends Animal{
    public function move(){
        echo "dog is moving";
        echo self::$var;
        echo Dog::$var;
    }
}

$d1 = new Dog();
$d1->move();
echo "<br />";

$multi = array(
    "dict1"=>array(
        "k1"=>"v1",
        "k2"=>"v2",
    ), 
    "dict2"=>array(
        "k1"=>"v1",
        "k2"=>"v2",
    )
);
echo $multi["dict1"]["k1"];
echo number_format(10.23241, 2);

setcookie("cookie-key", "value");

echo $_COOKIE["cookie-key"];
echo date('Y-m-d H:i:s');


$str = "hello";

function reverseStr($str){
    if(strlen($str) == 1){
        return $str;
    }
    return reverseStr(substr($str, 1, strlen($str))) . $str[0] ;
}

echo reverseStr($str);
?>






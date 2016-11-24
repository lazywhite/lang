## Topic
### 1. 接口与抽象类的区别
1. 接口里面所有的方法均为public
2. 接口中的成员变量默认为public static final
3. 接口中不存在已实现的方法
4. 实现接口的非抽象类必须实现所有方法, 抽象类可以不用实现
5. 接口用implements实现, 抽象类用extends实现
6. 抽象类可以有构造器, 接口没有构造器
7. 抽象方法可以有main方法并且可以运行, 接口没有
8. 抽象类可以继承一个类并实现多个接口  


### 2. Override与Overload

override: 重写父类方法   
overload: 重载 相同方法名, 不同参数    

### 3. Java8
1. lambda expression
2. method references
3. default method
4. stream api
5. new date time api
6. Optional Class
7. Javascript engine: Nashorn   interactive mode or as java class
8. support for base64 encode and decode


1. Virtual extension methods, or as they are often called defender methods(default method)  
2. You cannot implement multiple interfaces having same signature of Java 8 default methods 
3. Abstract class can hold state of object. It can have constructors and member variables. Whereas interfaces with Java 8 default methods cannot hold state. It cannot have constructors and member variables.   

### 4. Lifecycle of thread
thread priorities: help system to determine the executing order of threads

1. New state: 新建状态, 直到调用start()
2. 就绪状态: 线程处于就绪队列中, 等待jvm线程调度器进行调度
3. 运行状态: 如果一个线程拿到CPU资源, 可以执行run()之后处于运行状态
4. 阻塞状态: 执行sleep(), suspend(), wait()之后, 进入此状态, 三种类别
        等待阻塞
        同步阻塞
        其他阻塞
5. 死亡: 线程执行完毕或者被终止后, 进入死亡状态  


### 5. how to use multiThread
1. 实现Runnable 接口
2. 继承Thread类
3. 通过Callable或者Future创建


### 6. 常识
1. 一个类可以有多个构造函数  
2. java8 接口可以有default method, 可以有实现体  
3. 一个类可以实现多个接口, 但不能多重继承  
4. synchronized: 多线程编程中用来修饰方法或者一段代码, 确保线程安全  
5. volatile: 轻量级并发保证, 用来修饰变量, 不具备原子性
6. transient: indicate that one field should not be serialized
7. strictfp: 精确浮点数, 可以修饰类或者接口
8. assert \<cond\> [: "error message"];
9. ```if (p instanceof Parent){}```

### 7.手动垃圾回收
```
p = null; # del object
System.gc();
```


## Operator
1. arithmatic operator: + -
2. relational operator: == 
3. bitwise operator: >>>
4. logical operator:   && || !
5. instanceof operator 
6. assignment operator  +=
7. conditional operator    ?:

## Loop control
while   
for  
do while  

## Decision making
if  
else  
switch  

## 异常处理
```
try{}
catch(\<exception_name\>){}
finally{}
throw new Exception("输入的字符不能为空！"); //手动抛出异常
throws  \<exception01>,\<exception02>  // 规定可能抛出异常的种类
```  

## Number methods
```
xxxValue()
compareTo()
equals()
valueOf()
Integer.toString()
Integer.parseInt()
Math.abs()
Math.random()
```

## ArrayList method
```
add(index, object)
add(object) # append element to end of list
addAll(collection)
addAll(index, collection)
clear() # remove all element from list
clone()
contains(object)
ensureCapacity(int mainCapacity)
get(index)
indexOf(object)
remove(index)
removeRange(fromIndex, toIndex)
set(index, object)
size() # return the number of elements
toArray()
trimToSize() # trim the capacity of the arrayList instance to be current size of list
```

## HashSet
```
HashSet(collection) # initialize the hashset by using the elements of collection 
HashSet(int capacity)  
HashSet(int capacity, float fillRatio)

add(object)
clear()
contains(object)
isEmpty() # return true if hashset contains no elements
iterator() # return an iterator over the elements in this list
remove(object) # remove the specified element from this set if present
int size() 
```

## HashMap
```
HashMap() # default implementation
HashMap(Map m) # initialize the hash map by using the element of given map object
HashMap(int capacity)
HashMap(int capacity, float fillRatio)

void clear() # remove all mapping from this map
Object clone() # return shallow copy of this HashMap
boolean containsKey(Object key) # return true if this map contains specified key
boolean containValue(Object value)
Set entrySet() # return a collection view of the mappings contained in this map
Object get(Object key) 
boolean isEmpty()
Set keySet()
Object put(Object key, Object value) # associate the specified value with specified key in this map
putAll(Map m)  # copy all of the mappings from the specified map to this map
Object remove(Object key) # remote the mappings for this key from this map if present
int size() # return the number of key-value mappings in this ap
Collection values() # return a collection view of the values contained in this map
```

## Jar包构成
```
jar xf /path/to/jar
    META-INFO
        MANIFEST.MF
            Main-Class 
            Build-Jdk
```

## JDK目录结构
```
jdk1.8.0
     bin
          java*
          javac*
          javap*
          javah*
          javadoc*
     lib
          tools.jar
          dt.jar
     jre
          bin
               java*
          lib
               applet
               ext
                    jfxrt.jar
                    localdata.jar
               fonts
               security
               sparc
                    server
                    client
               rt.jar
               charsets.jar
```

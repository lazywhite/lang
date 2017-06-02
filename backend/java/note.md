### 1. 接口与抽象类的区别
    1. 接口里面所有的方法均为public
    2. 接口中的成员变量默认为public static final
    3. 接口中不存在已实现的方法
    4. 实现接口的非抽象类必须实现所有方法, 抽象类可以不用全部实现
    5. 接口用implements实现, 抽象类用extends实现
    6. 抽象类可以有构造器, 接口没有构造器
    7. 抽象方法可以有main方法并且可以运行, 接口没有
    8. 抽象类可以继承一个类并实现多个接口  


### Lifecycle of thread

1. New state: 新建状态, 直到调用start()
2. 就绪状态: 线程处于就绪队列中, 等待jvm线程调度器进行调度
3. 运行状态: 如果一个线程拿到CPU资源, 可以执行run()之后处于运行状态
4. 阻塞状态: 执行sleep(), suspend(), wait()之后, 进入此状态, 三种类别
        等待阻塞
        同步阻塞
        其他阻塞
5. 死亡: 线程执行完毕或者被终止后, 进入死亡状态  


### 7.手动垃圾回收
    p = null;
    System.gc();


## Number methods
```
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
boolean containsValue(Object value)
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

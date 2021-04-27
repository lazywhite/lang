## 名词
```
JPA: Java Persistence API
POJO: Plain Ordinary Java Object
PO: POJO + Annotation

ajp: apache jserv protocol
jre: java runtime environment
jdk: java development kit
jndi: java namespace and directory interface
jdbc: java database connectivity
jpa: java persistence api
jmx: java management extensions
apr: apache portable runtime(support for openssl, epoll, sendfile)
```


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
jar xf /path/to/jar // 无法设置解压路径
unzip /path/to/jar -d <dir>
    META-INF
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

## 创建可执行jar包
```
├── classes
│   ├── MANIFEST.ini
│   └── com
│       └── local
│           └── test
│               ├── Test.class
│               └── User.class
└── src
    └── com
        └── local
            └── test
                ├── Test.java
                └── User.java


javac -d classes  src/com/local/test/*.java

touch classes/MANIFEST.MF
    Sealed: true  #包密封， 不允许出现包顶替
    Manifest-Version: 1.0
    Main-Class: com.local.test.Test  #必须有换行

cd classes
jar -cvmf MANIFEST.ini app.jar com

java -jar app.jar
```

## maven项目结构
```
src
    main
        java
            com.local.web
                student.java
        resources
            application.yml
    test
        java
            com.local.web
                student.java
```

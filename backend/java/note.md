## Topic
java 内存回收  
异步  
多线程  

override: 重写父类方法  
overload: 相同方法名, 不同参数  
  
深入理解java虚拟机  
java多线程编程核心技术

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


## Other
p = null; # del object


## Gleaning
```
jar xf /path/to/jar
    META-INFO
        MANIFEST.MF
            Main-Class 
            Build-Jdk
```

## jdk architecture
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

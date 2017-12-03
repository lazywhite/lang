1. volatile关键字可以用来提醒编译器它后面所定义的变量随时有可能改变，因此编译后的程序每次需要存储或读取这个变量的时候，都会直接从变量地址中读取数据。如果没有volatile关键字，则编译器可能优化读取和存储，可能暂时使用寄存器中的值，如果这个变量由别的程序更新了的话，将出现不一致的现象。

2. union的意义是可以存储不同数据类型的数据在同一个地址上，一个union 只配置一个足够大的空间以来容纳最大长度的数据成员, 只有最新赋值的数据才是有效的

## Topic
1. return multiple value from a function
2. there are no default parameters in C
3. When a local variable is defined, it is not initialized by the system, you must initialize it yourself. Global variables are initialized automatically by the system 
4. storage class: auto, register, static, extern
5. __packed: 结构体字节对齐
6. Like any variable or constant, you must declare a pointer before using it to store any variable address. A pointer that is assigned NULL is called a null pointer.

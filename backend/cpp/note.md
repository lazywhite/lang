sizeof() 接受变量或类型关键字, 返回字节数
    NULL 8字节
typedef int feet; 类型别名
enum 元素的值默认从0开始, 可以设置默认值, 后一个元素将比前一个元素大1
    typedef enum {
        red,
        blue = 5,
        yellow
    }color;

    color c; c = yellow// c = 6

基本数据类型
    bool 1 byte
    char  1 byte
    float 4 byte
    double 8 byte
    int 4 byte
    void 不占字节
    wchar_t  4 byte

数据类型修饰符(type modifier)
    signed
    unsigned
    short
    long


类型限定符(type qualifier)
    const: 值不会发生改变
    volatile: 值可能会改变, 每次访问都从内存读取, 不访问缓存
    restrict: 

lvalue 可以出现在等号两侧
    pointer
    variable
    reference
rvalue 只能出现在等号右侧
    10
    'c'


变量存储类别(storage class)
    extern: 修饰全局变量或function, 表示已在其它地方声明或初始化
    register: 修饰local variable, 变量存储在寄存器, 不能取地址, 因为没有存储在内存
    auto : default for local variables
    static: 可以修饰local或global变量, 不会在function调用结束后销毁
    mutable: 只能修饰类对象

变量作用域
    local
    formal parameter
    global
    
局部变量必须手动初始化
全局变量自动初始化
    int 0
    float 0
    double 0
    char '\0'
    pointer null

定义常量
    #define
    const 



操作符
    数学运算符
        + - * /(整除)  % ++ --
    关系运算符
        == != > < >= <=
    逻辑运算符
        && || !
    位运算符
        & ! ^ ~ << >>
    赋值运算符

循环
    while
    do while
    for 
    break
    continue
    goto 

函数组成
    header
        声明(返回值, 函数名, 参数类型)
    body
    
函数在调用前必须被声明, 可以先声明后实现
函数某个参数设置默认值之后, 后续的参数也必须有默认值
round(<num>) 如果num为负数, 则结果为对正数求round的相反数


函数参数传递
    call by value: 变量被拷贝给形式参数,  对形参的修改不会影响原变量
    call by reference: 变量的引用被拷贝给形式参数, 会影响原变量
    call by pointer: 变量的指针被拷贝给形式参数, 会影响原变量


数组元素必须手动初始化
数组作为参数
    void iter(int* arr, int size);
    void iter(int arr[], int size);
数组作为返回值
    int* getArray(){
        int arr[2] = {0, 1};
        return arr;
    }

数组的指针就是数组首元素的指针
    
字符串处理
    <cstring>
    <string>

指针
    支持加减, 比较
    指向数组的指针
        int arr[3];
        arr = &arr[0]
    指针数组
        int* p[2];

    指向指针的指针
        int a = 10;
        int *p; p = &a;
        int **q; q = &p;
        cout << **q << endl;
    void* 
        无类型指针, 可以指向任意类型

引用
    int a = 10;
    int& b = a;
    b可以视为a的别名, 两者指向同一个内存地址


    常量引用
        int a = 10;
        const int& b = a;  
        a = 30; //a可以重新赋值
        //b = 50; //b不可以重新赋值



cin 
cout 
cerr 
clog 
    
struct, class 定义后需要用分号结束
struct成员默认访问权限是public, class是private


面向对象
=====================
access-specifier
    public
        父类的public member成为子类的public member
        父类的protected member成为子类的protected member
    protected
        父类的public, protected member成为子类的protected member
    private
        父类的public, protected member成为子类的private member

多重继承
    class A: public B, public C{};

构造函数 Box()
    必须跟类名同名
    不返回内容, void也不需要



析构函数 ~Box()

copy constructor
    用同类型的一个object去初始化另一个object
friend function
    class Box {
        double width;
        public:
           double length;
           friend void printWidth( Box box ); //外部的printWidth函数可以访问Box任意member, 即使是private的
           void setWidth( double wid );
    };
    void printWidth( Box box ) {
       cout << "Width of box : " << box.width <<endl;
    }
inline function
    类内部定义的function默认就是inline function
    在编译时, inline function被调用的地方会被替换成copy
    inline function定义被改变, 需要重新编译整个项目

类的指针
    A a;
    A *p;
    p = &a;


类的静态成员, 无论类有多少实例, 成员都只有一份, 所有实例共享
静态方法只能访问静态成员或其他静态方法

重载
    函数
    运算符  operator<+>()

多态
    early binding
    late binding virtual function

virtual function
    1. virtual void greet() = 0;
    2. 具有virtual function的class是抽象类
    3. 继承抽象类而不实现virtual function, 则仍为抽象类, 无法实例化
    4. struct可以有virtual function


exception 
    <stdexcept>
    exception: class 
    try, throw, catch

new <data-type>, delete <pvalue>  

namespace outer{
    void func(){};
    namespace inner{  //嵌入式命名空间
    };
}

outer::func();
outer::inner::func();

template
    keyword:
        typename
        class
    function template
    class template

preprocessor
    #define <macro-name> <replacement-text> (规定一个macro)
    #ifdef
    #ifndef
    #endif 
    ## 字符串拼接

    pre-defined macro
        __FILE__
        __LINE__
        __DATE__
        __TIME__

<csignal>
    SIGABRT
    SIGFPE
    SIGILL
    SIGINT
    SIGSEGV
    SIGTERM




多线程
    pthread_t: class
    pthread_create()
    pthread_exit()


    

Lambda函数的语法定义如下：
[capture](parameters) mutable ->return-type{statement}
其中：
[capture]：捕捉列表。捕捉列表总是出现在lambda表达式的开始处。事实上，[]是lambda引出符。编译器根据该引出符判断接下来的代码是否是lambda函数。捕捉列表能够捕捉上下文中的变量供lambda函数使用。
    []      // 沒有定义任何变量。使用未定义变量会引发错误。
    [x, &y] // x以传值方式传入（默认），y以引用方式传入。
    [&]     // 任何被使用到的外部变量都隐式地以引用方式加以引用。
    [=]     // 任何被使用到的外部变量都隐式地以传值方式加以引用。
    [&, x]  // x显式地以传值方式加以引用。其余变量以引用方式加以引用。
    [=, &z] // z显式地以引用方式加以引用。其余变量以传值方式加以引用。

    对于[=]或[&]的形式，lambda 表达式可以直接使用 this 指针。但是，对于[]的形式，如果要使用 this 指针，必须显式传入：
    [this]() { this->someFunc(); }();

(parameters)：参数列表。与普通函数的参数列表一致。如果不需要参数传递，则可以连同括号（）一起省略。
mutable：mutable修饰符。默认情况下，lambda函数总是一个const函数，mutable可以取消其常量性。在使用该修饰符时，参数列表不可省略（即使参数为空）。
->return_type：返回类型。用追踪返回类型形式声明函数的返回类型。出于方便，不需要返回值的时候也可以连同符号->一起省略。此外，在返回类型明确的情况下，也可以省略该部分，让编译器对返回类型进行推导。
{statement}：函数体。内容与普通函数一样，不过除了可以使用参数之外，还可以使用所有捕获的变量。
在lambda函数的定义式中，参数列表和返回类型都是可选部分，而捕捉列表和函数体都可能为空，C++中最简单的lambda函数只需要声明为： []{};


clang++  编译含有lambda 表达式, 需要开启c++ 11 extension 支持
    clang++ -stdlib=libc++ -std=c++11 [input]
    clang++ -stdlib=libstdc++ -std=gnu++11 [input]

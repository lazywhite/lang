http server
    python -m SimpleHTTPServer 0.0.0.0:8000
    python -m http.server --bind 0.0.0.0 8000


docstring
    # google风格
    def func(arg1, arg2):
        '''主要用途说明

        详细说明

        Params:
            arg1 (str): 说明
            arg2 (str): 说明
        Returns:
            a dict
            example:
            {"foo": 100, "bar": 200}
        Raises:
            IOError: 

    # reST风格, pycharm默认, 支持sphinx
    def func(arg1: str, arg2: str) -> dict:
        '''
        this is a reST style

        :param arg1: description
        :param arg2: description
        :returns: result store in dict
        :raises IOError: io exception
        '''
        pass

            
    class MyClass:
        '''主要说明
        
        详细说明

        Attibutes:
            foo (str): 说明
            bar (str): 说明
        '''
        def __init__(self, foo, bar):
            pass


package
    regular package
        文件夹内包含__init__.py即可
        foo # package
            __init__.py # package init
            bar.py  # module

    namespace package # 3.3版本引入
        可以不局限于文件系统, 可以是一个url，甚至没有代码



特点
    拥有高级数据结构

类与继承:
    __init__  
    __del__
    可在类体外定义类的函数

异常处理
    try raise expect else finally
with
    __enter__
    __exit__

Tips
    random.choice(list)
    eval exec 将字符串中的字符当作命令来执行
    assert 断言,若为False则fatal error
    repr() 获得对象得正规字符串表示


    import this //zen of python

    进制赋值 //0x22
    运算顺序not > and > or
    range(1,5) 不包含最后一个数
    global语句用来声明x是全局变量
    有默认值的参数只能出现在参数列表后面
    pyc文件的意义是加快模块加载速度
    print("foo", end="")

    for k, v in enumerate(a_list) 带index进行迭代

    dict1.update(dict2) 从dict2中更新或新增kv

String format
    age = 20
    name = 'Swaroop'
    print('{0} was {1} years old when he wrote this book'.format(name, age))



我们可以使用函数的__doc__(注意，双下划线)属性(属于名字的)访问函数的文档字符串

assert 0>1 将会返回AssertionError



PEP: python enhanchment proposal

PyPI: python package index


class create procedure
    1. determin the metaclass
    2. prepare a namespce for it , default dict()   __prepare__
    3. execute the class declare body
    4. create the new class ; __new__

raise Exception from none : suppress the original exception in chained context

__path__ : internal module search path
__file__ :always return absolute path of file
__iter__, __next__
__index__: should return an int, bin(object)

sorted() , squence.sort()


name mangling 
    obj._Class__private_attr


函数描述
    add(int:x + int:y) -> int:
 
unicodedata.normalize()

import pkgutil
data = pkgutil.get_data(__package__, 'somedata.dat') -> raw

importlib.import_module('.b', __package__) -> from . import b


time.ctime()
time.localtime()
time.mktime(datetime.datetime(2016, 01, 10).timetuple()) #return timestamp

'dump' to a file object and 'dumps' to a string

descriptor
    staticmethod
    classmethod
    __slots__
    property

dict((('a','b'),)) --> {'a':'b'} 
dict(a='b') --> {'a':'b'}
dict.update(a=10)
dict.update({'key':10})

__import__('str') --> import module
importlib.import_module('str')
The 'package' argument is required when performing a relative import. It
specifies the package to use as the anchor point from which to resolve the
relative import to an absolute import.

from __future__ import absolute_import
from __future__ import division, unicode_literals

module is a big dict, you can insert new attr into it
__builtin__.end = None

any(iterable object) --> return true if any bool(x) is true
all(iterable)  --> return true if all bool(x) is true

tuple(dict) --> (key1,key2...)
tuple(set) --> a tuple

sys.modules --> return a dict of all loaded modules


bytes <-(encode|decode)-> string
    b = b'string' 
    a = b.decode('utf-8')
    c = a.encode('utf-8')

sys.getdefaultencoding()
sys.getfilesystemencoding()

'unicode'是python内部编码, 而'utf-8'是一种编码方式

c=[1,2,3]  b=c[::] (copy)  b=c[::-1](reverse copy)


from collections import Counter ; c=Counter('hello,world')
c.most_common(3) ; c just like a dictionary

while/for, else: when loop is normally done then run else branch


callable = deco(callable), deco is callable 
    deco can be function or class
    callable can also be function or class



any(sequence) --> True if any is True
all(sequence) --> True if all is True



file.read() --> string
file.readliens() --> list
file.readline() --> string per line
file is a iterator

textwrap.fill(doc, width=40)

from test.a import * 
    (定义__all__) 只会导入定义的属性
    (没定义__all__)只会导入__init__.py
    __all__ ,__file__ 需要显式定义


how to test if multiple item in same container
    item_set = set(item_list)
    container_set = set(container)
    if item_set.issubset(container_set): 
        return True


# set
#
a | b : 并集
a & b : 交集
a ^ b : 对称差集
a - b : b相对于a的差集


Exception.args

a  = 10 if True else 100

from module import * :
# will not be imported
    _a 
    __a 

import module:
    module._a
    module.__a


# what information stored in special attribute
__dict__ : only store private attribute, no method

bytes解码过后成为string,string编码后成为bytes
unicode 为python的内部编码
s = '中文' , 解释器会用默认编码存储一串bytes

m  = hashlib.md5()
m.update('hello')
m.update(' world')
m.hexdigest()
--> '5eb63bbbe01eeed093cb22bb8f5acdc3'
hashlib.md5('hello world').hexdigest()
--> '5eb63bbbe01eeed093cb22bb8f5acdc3'




pdb使用
    python -m pdb sr.py
    pdb.set_strace()

    b 设置断点  
    c 继续执行程序    
    l 查看当前行的代码段  
    s 进入函数  
    r 执行代码直到从当前函数返回  
    q 中止并退出  
    n 执行下一行  
    p（p） 打印变量的值  
    h 帮助  


编码规范
    use CameCase for classes
    use lower_case_with_underscores for functions and methods
    use self as the name for the first method argument
    use docstrings
    put comments on a line of their own
    use 4-space indentation and no tabs
    wrap lines so that they don't exceed 79 characters
    use blank lines to seperate functions and classes and larger blocks of code inside functions


7 is an instance of int, int class is an instance of type 
difference between instance and subclass
  
1. python的内建基类:int str list dict function type super code module
2. 所有对象均为object的实例  
3. type生成了所有的基类  
4. type 继承于object,所有的基类也继承于object  
5. locals()可打印出所有局部变量，globals()可打印全局变量  
6. 无法生成与类名相同的实例  
7. 修饰器，接受一个function,返回一个function  
8. vim中设置tab为4空格 set ts=4 sw=4 sts=4 et  
9. range(start,stop,pace),xrange is faster than range
10. 集合必须用set()来生成
11. python-kombu: python rabbitmq driver
12. python没有真正意义的protect 和 private,只能模拟，但不真正起作用

  
String format
    '{name} want to eat {food}'.format(name='cats', food='lalal')
    '{} is a {}'.format('This', 'placeholder')
    '{0} can be {1}'.format('string', 'formated')


sorted(iterable, key=sort_lambda)
bisect.insort(iterable, item)
setattr(obj, name, value)
getattr(obj, name)
delattr(obj, name)


类可以定义在方法, 类, 或类中
函数可以定义在函数或方法中

函数传递方式为pass-by-sharing, 参数仅仅是新的binding, 如果指向的值是mutable, 则变量会发生改变


同时catch多种类型Exception
    try:
        func()
    except (IDontLikeYouException, YouAreBeingMeanException) as e:
        pass


copy一个对象
    import copy
    a = dict(key="100")
    b = copy.deepcopy(a)


dict操作
    a = {
        "key1": 100,
        "key3": 100,
    }
    b = {
        "key1": 200,
        "key2": 100,
    }

    a.update(b) //如果有相同key则覆盖，没有则新建


函数的参数传值
    call by object reference
    object --binding-- label
    如果object是immutable，函数内部会新建一个object，并加上label，改变object不会影响外部值
    如果object是mutable, 函数内部会新建一个label, 指向同一个object, 对label的操作会影响外部object
    immutable object的id都会不一样，只有两种情况:
        -5 <= num <= 256 (singleton int)
        intern string(长度小于等于20个字符)

    在函数内部， 值会缓存
    def x():
      a = 123123123
      b = 123123123
      id(a) == id(b)  # True


    结论: 要尽量拒绝使用id(), 只推荐使用在is None判断


python没有a++, ++a的语法， 有a+=2语法



新式类与老式类
    class A:
        pass

    class B(object):
        pass

    a = A()
    b = B()
    type(a) --> instance 
    type(b) --> __main__.B

    type(A) --> classobj
    type(B) --> type


    mro: 老式类深度优先， 新式类广度优先

列表删除元素
    type(a) --> list
    a.remove(<element>)
    a.pop([index])

bool([0, None, [], {}, ()]) --> False



isinstance(10, int) -->True
issubclass(A, object) -->bool

python不支持函数重载 不支持泛型, 因为函数对参数类型和个数均不敏感
python singledispatch


try语句块如果没有异常发生, 则执行else语句, finally一定会被执行

@classmethod 第一个参数一定是cls, @staticmethod像普通方法一样定义即可


python 数据类型
    int
    long
    float
    bool
    complex
    str
    function
    type
    list
    set
    dict
    tuple

面向对象
    继承关系
        obj.__base__ 查看其父类
        type.__base__ --> object
        object是继承关系的顶点, 所有数据类型的父类都是object
    类型实例关系
        obj.__class__ 查看其类型
        object.__class__ --> type
        type是实例关系的顶点, 所有对象都是它的实例

迭代器
    当需要遍历一个可迭代对象内的所有元素，却不想使用for循环, 可以使用迭代器
    迭代器就是可以对其执行next(), 在迭代结束后会抛出StopIteration
    将iterator转换为list会导致iterator耗尽, 无法再迭代
生成器
    函数内部必须有yield

float('nan')
float('inf')
float('-inf')

d = {'k1':200, 'k2': 100}
max(d) --> 'k2'
max(d, key=lambda key: d[key]) --> 按value排序


class A(object):
    __private = 10  # 访问时自动被重命名, 被继承后无法被覆盖
    _protected = 20

class B(A):
    __private = 100
    _protected = 200
	_A__private = 10101  # override方法

    def __func(self):
        pass

b = B()

b._protected
b._B__private
b._A__private
b._B__func()

## GIL
一个防止多线程并发执行机器码的一个Mutex, 造成在计算密集型的多线程程序中性能甚至低于单线程
因为有了GIL, 默认python内部对象是thread-safe的，无需在实现时考虑额外的内存锁和同步操作




## install pycrypto-2.6.1 on Mac 10.12
    configure: error: C preprocessor "clang++" fails sanity check
    方法： **sudo** pip install pycrypto

## django template unicode decode error
    manage.py
        reload(sys)
        sys.setdefaultencoding('utf8')

    path/to/template.html
        <head>
            <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
        </head>
    views.py
        # -*- coding: utf-8 -*-


string.join(list), list内的元素必须是string
    ", ".join(str(i) for i in list)


wss:// websocket with ssl
websocket 默认可以跨域, 可以通过Origin header进行控制
数据支持字符串, array buffer, blob


python thread 不支持stop thread的api, 会导致GIL死锁
process api支持停止


a = "0x13"  b = int(a, 16)  


函数的参数传递
    对于可变对象, 相当于传引用
    对于不可变对象, 相当于传值


a = 10
def f(num):
    num += 10
    return num
b = f(a)
print a # 10
print b # 20


c = [1, 2]
def f1(aList):
    aList[0] += 10
    return aList
d = f1(c)
print c # [11, 2]
print d # [11, 2]


global
    y = 100
    def change():
        global y 
        y += 10
    change()
    print y #110

进制转换
    bin() oct() int() hex()

a = list(range(3))
print "print list %s" % a

检查文件是否存在
    os.path.exists("/file/path")

反转list a[::-1]

pip install error
    pip install -U pip


1.from a.b import c 
    both a.__init__ and b.__init__ will be executed,
    then <import a >will not execute a.__init__ any more

2.from a import * 
    will not import name.startswith('_')
    __all__ can define resource list

3.from __future__ import absolute_import
     import string ## will try to import 'string' standard library not .string

4. relative import can only use like this <from . import m>
    it won't work if parts of package are executed as script

5. import importlib; importlib.import_module('name')
    path = importlib.import_module('os.path')


install m2crypto on mac
    brew install openssl
    brew install swig

    env LDFLAGS="-L$(brew --prefix openssl)/lib" \
    CFLAGS="-I$(brew --prefix openssl)/include" \
    SWIG_FEATURES="-cpperraswarn -includeall -I$(brew --prefix openssl)/include" \
    pip install m2crypto



Normally, using a.b to get, set or delete an attribute looks up the object named b in the class dictionary for a, but if b is a descriptor, the respective descriptor method gets called.


An object is hashable if it has a hash value which never changes during its lifetime

All of Python’s immutable built-in objects are hashable, while no mutable containers (such as lists or dictionaries) are. Objects which are instances of user-defined classes are hashable by default; they all compare unequal (except with themselves), and their hash value is their id().

iterator : an object representing a stream of data

metaclass: The class of a class. Class definitions create a class name, a class dictionary, and a list of base classes. The metaclass is responsible for taking those three arguments and creating the class. 

MRO: method resolution order 
module: An object that serves as an organizational unit of Python code. Modules have a namespace containing arbitrary Python objects.

package: Technically, a package is a Python module with an __path__ attribute

reference count

object: type, value, identifier

views: objects returned from dict.keys(), dict.values(), and dict.items() are called dictionary views. They are lazy sequences that will see changes in the underlying dictionary. To force the dictionary view to become a full list use list(dictview).


'return' will break the loop

Packages support one more special attribute, __path__. This is initialized to be a list containing the name of the directory holding the package’s __init__.py before the code in that file is executed. This variable can be modified; doing so affects future searches for modules and subpackages contained in the package.



an object's type determines the operations that the object support
an object's mutability is determined by its type

It is not guaranteed that __del__() methods are called for objects that still exist when the interpreter exits.

print(object) execute object.__str__
repr(object) execute object.__repr__


__getattribute__ 

Specifically, any module that contains a __path__ attribute is considered a package.

2to3 -w (写入源文件) -n (不建立backup文件)


s1 = slice(2, 7, 2)
b = range(10)
b[s]

s1 = slice(2, -1, 2)
b[s1]

try:
except:
    logger.exception("error stack") # 将会将错误栈打印到日志中

空字符串为false

with open('file') as f:
    data = f.read()  # data为一个字符串
    data = f.readlines() # data为一个列表


求某个元素的下标
    a = ['a', 'b']
    a.index('a')

参数传递
    对于不可变对象作为函数参数，相当于C系语言的值传递；
    对于可变对象作为函数参数，相当于C系语言的引用传递。

按照多种属性排序
    sorted(obj_list, key=itemgetter("attr1", "attr2"))

lambda表达式不能跨行
    使用print 
        from __future__ import print_function
        lambda x: print("test")
    无参lambda
        lambda : True


dict comprehension
    {key.upper(): value for key, value in dct.items()}



absolute import 
    pkg/
    pkg/init.py
    pkg/main.py
    pkg/string.py

    from __future__ import absolute_import

    main.py
        import string          # 系统builtin string module
        from pkg import string # 当前目录module



字符串替换
    %.2f 保留小数点2位
    %%   escape %

编译安装python3
    yum install tk-devel sqlite-devel readline-devel gdbm-devel xz-devel bzip2-devel openssl-devel; make -j


执行一段字符串代码
    exec("var1 = 100")
    exec('''
    for i in range(10):
      print(i)
    ''')


命名切片
    a = slice(1, 3)
    a = slice(1, None, None)
    a = slice(None, 1, None)
    b = "hello"
    b[a]

函数如果需要定义带默认值的参数, 必须放在参数列表的最后


lambda
    lambda表达式中的x是一个自由变量， 在运行时绑定值，而不是定义时就绑定，这跟函数的默认值参数定义是不同的。


centos8编译安装python3.9.5
1. 下载源码, 不要解压到windows共享盘，会导致编译失败
2. 下载依赖库  
    yum install openssl-devel ncurses-devel  bzip2-devel sqlite-devel zlib-devel libffi-devel -y
3. ./configure --prefix=/usr/local/python3.9.5 --enable-optimizations --enable-shared

    # --enable-shared 才会生成libpython2.7.so
    make altinstall
    wget https://bootstrap.pypa.io/get-pip.py

cento7编译安装python2.7.18
    wget https://www.python.org/ftp/python/2.7.18/Python-2.7.18.tgz
    yum install gcc* openssl-devel ncurses-devel  bzip2-devel sqlite-devel zlib-devel
    ./configure --prefix=/usr/local/python2.7.18 --enable-optimizations --enable-shared
    make altinstall
    wget https://bootstrap.pypa.io/pip/2.7/get-pip.py
    /usr/local/python2.7.18/bin/python get-pip.py # 一定要用绝对路径安装, 否则ln -s /abs/path /bin/python2.7.18 会安装在软连接所在目录
    



协程的实现有三种
    asyncio (官方)
    greenlet
    gevent


python2.x没有nonlocal keyword, 闭包的实现必须要依赖nonlocal

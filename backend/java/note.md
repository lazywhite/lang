## Topic
java 内存回收
异步
多线程

override: 重写父类方法
overload: 相同方法名, 不同参数


## TODO
深入理解java虚拟机
java多线程编程核心技术


## Gleaning
jar xf /path/to/jar
    META-INFO
        MANIFEST.MF
            Main-Class 
            Build-Jdk


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

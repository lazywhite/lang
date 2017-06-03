## Term
```
ajp: apache jserv protocol
jre: java runtime environment
jdk: java development kit
jndi: java namespace and directory interface
jdbc: java database connectivity
jpa: java persistence api
jmx: java management extensions
javabean: special class in java, serial multiple class into one "Bean" 
apr: apache portable runtime(support for openssl, epoll, sendfile)
```

## Tomcat server architecture

```
Server
    Listener(security, apr, memory leak prevent)
    GlobalNamingResources
    Service(name)
        Connector(port, protocol)
        Engine(name, defaultHost)
            Realm
            Host(name, appBase)
                Valve(logging config)
```

## Topic

```
CATALINA_HOME: 指向bin, lib的父目录
CATALINA_BASE: 指向每个tomcat目录私有信息, conf, logs, temp, webapps, work父目录
  

## Server startup
https://tomcat.apache.org/tomcat-8.0-doc/architecture/startup/serverStartup.pdf


## components of tomcat
```
catalina: tomcat servlet container
coyote: http connector
jasper: jsp engine
```

## jsp processing
1. web server forward http request to jsp engine
2. jsp engine load jsp files and convert to servlet content
3. jsp engine compile servlet into class and forward original request 
    to servlet engine
4. a part of web server call the servlet engine loads servlet class and 
    execute it, get html output
5. web server response html content

jsp engine compare the mtime of jsp and servlet to decide whether to recompile 

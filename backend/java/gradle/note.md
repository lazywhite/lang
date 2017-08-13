## Usage
```
1. 初始化目录结构
gradle init --type java-application|java-library|scala-library|groovy-library|basic

2. 初始化war工程目录
src
    main
        java
        resource
        webapp
    test
        java
        resource
```

## Topic
1. cache path: ~/.gradle/caches
2. refresh dependencies: #gradle <command> --refresh-dependencies
3. running a task: #gradle -q <taskname>
4. list all tasks: #gradle tasks --all
5. tasks without a group are considered as private tasks
6. convert a maven project to gradle: [maven_pro_dir]# grade init --type pom
7. 使用getty插件:  gradle appRun
8. gradle test
9. 自定义task  


## build.gradle for war project
```
plugins{  //必须放在文件最前面
    id 'java'
    id 'war'
    id 'org.akhikhl.gretty' version '1.4.2'
}

sourceCompatibility = 1.8   // 设置 JDK 版本
webAppDirName = "src/main/web" //设置web主目录

repositories {
    jcenter()
}

dependencies {
    providedCompile 'javax.servlet:javax.servlet-api:3.1.0' 
    testCompile 'junit:junit:4.12' 
}

```
## Command
```
gradle tasks --all
gradle [app:]dependencies  //app是子模块名称
```

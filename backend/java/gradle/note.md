# 如何管理不同类型项目
## 1. java application

```
1. 初始化目录结构
mkdir demo; cd demo
gradle init
gradle init --type java-application ## 会生成app目录

2. 执行
./gradlew run

3. 打包
./gradlew build
    生成在app/build/distribution/demo.zip + demo.tar, 解压即可有demo/bin/demo可执行文件
```

## 2. java library

```
1. mkdir demo;cd demo
2. gradle init --type java-library # 会生成lib目录
3. ./gradlew build 
    生成lib/build/libs/demo.jar
4. ./gradlew jar
    重新打包
```

## Tips
```
gradle用户目录
    linux: ~/.gradle
    windows: Users/<>/.gradle
cache path
    ~/.gradle/caches
refresh dependencies: 
    gradle <command> --refresh-dependencies
running a task
    gradle -q <taskname>
list all tasks
    gradle tasks --all
tasks without a group are considered as private tasks
convert a maven project to gradle
    cd /maven_pro_dir
    grade init --type pom
使用getty插件
    gradle appRun
```


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


## 依赖管理
```
gradle 3.4 引入了api和implementation来取代compile

api
    可以看作跟compile是一摸一样的
implementation
    只能在内部使用此模块，比如我在一个libiary中使用implementation依赖了gson库，然后我的主项目依赖了libiary，那么，我的主项目就无法访问gson库中的方法。这样的好处是编译速度会加快，推荐使用implementation的方式去依赖，如果你需要提供给外部访问，那么就使用api依赖即可
compileOnly
    取代provides, 只在编译期有效， 不参与打包

runtimeOnly
    取代apk, 不参与编译，只参与打包，很少使用

testImplementation
    取代testCompile, 只在单元测试和打包测试apk时依赖
debugImplementation
    取代debugCompile, 只在debug编译时依赖

releaseImplementation
    取代releaseCompile, 只在release模式时依赖


dependencies{
    implementation() 
    testImplementation() 
    api()
}

```

## Concept
POM: project object model
java program lifecycle manage tool, use plugin to integrate with other tool

## POM
所有pom.xml都从super pom继承
查看最终pom
    mvn help:effective-pom 

lifecycle
    clean
        pre-clean
        clean
        post-clean

    build
        prepare-resource
        compile
        package
        install
    site: 生成项目文档
        pre-site
        site
        post-site
        site-deploy


pom.xml结构
```
    modelVersion 
    groupId: 组织名
    artifactId: 项目名
    version: 版本
    packaging
        war
        jar: 默认
        ear
    repositories
        repository
            id
            url
    dependencies 
        dependency
            gourpId
            artifactId
            version
            exclusions
            scope
                compile(默认): 需要在classpath之内
                test: 测试时需要, 编译时不需要
                provided: 只在编译和测试时需要, 打包时不需要, 运行时由jdk或container提供
                runtime: 运行时需要, 编译时不需要
                system: 本地包, 必须指明system-path
                import: 
    profiles
        profile
            id
            properties
            activation
    properties
    build
        resources
            resource
                directory
                includes
                    include

        testResource
            testResource
        plugins
            plugin
    modules
        module  对应子项目的目录名和artifactId
```            

## 编译跳过test
```
mvn install -Dmaven.test.skip=true

or 

<plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <configuration>
          <skip>true</skip>
        </configuration>
      </plugin>
</plugins>
```

```
查看包依赖
    mvn dependency:resolve
    mvn dependency:analyze
    mvn dependency:tree

同名包不同版本依赖冲突
    路径最短优先
    路径相同xml定义顺序优先

```
```
mvn archetype:generate -DgroupId=com.greeting -DartifactId=test -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false    //普通java程序 
// -DarchetypeArtifactId=maven-archetype-webapp      //web应用
```
plugin
    build plugin
    reporting plugin

常见plugin
    clean
    compiler
    surfire: run junit test, 生成test report
    jar
    war
    javadoc: 生成项目的javadoc
    antrun: 执行一系列的task

每个plugin提供一系列的goal
mvn [plugin-name]:[goal-name]


指定没有repo的外部依赖
```
<dependency>
     <groupId>ldapjdk</groupId>
     <artifactId>ldapjdk</artifactId>
     <scope>system</scope>
     <version>1.0</version>
     <systemPath>${basedir}\src\lib\ldapjdk.jar</systemPath>
</dependency>
```
Archetype is a Maven plugin whose task is to create a project structure as per its template.

SNAPSHOT标明是由最新的代码生成的包

只需要声明直接依赖, maven自己处理依赖树

maven-release-plugin

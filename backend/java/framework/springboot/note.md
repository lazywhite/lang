## Introduction
pivot团队开发, 无需xml配置, 拥有内置web容器(tomcat, jetty等)
## Usage
```
## 1. using springboot CLI
brew tap pivotal/tap
brew install springboot

bash> echo > app.groovy <<EOF
@RestController
class ThisWillActuallyRun {

    @RequestMapping("/")
    String home() {
        "Hello World!"
    }

}
EOF
bash> spring run app.groovy

## 2. run jar
cd /path/to/springboot/project
mvn clean package 
java -jar target/demo.jar

## 3. 配置文件
src/main/resource/application.[yml,properties]
```

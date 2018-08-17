## Introduction
pivot团队开发, 无需xml配置, 拥有内置web容器(tomcat, jetty等)  
[initializer](https://start.spring.io/)
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

## Tips
```
@Controller  + @ResponseBody 或 @RestController可自动将domain转换json或xml

返回逻辑视图
    public String view(){
        return "hello"
    }
    Thymeleaf模板
        src/main/resources/template/demo.html

    jsp
        禁用spring-boot-starter-thymeleaf
        webapp/WEB-INF/views/demo.jsp
        src/main/resources/application.properties
            spring.mvc.view.prefix=WEB-INF/views/
            spring.mvc.view.suffix=.jsp

content negotiation
    path extension 
        /person/all.json
    path parameter
        /person/all?mediaType=json
    header
        Accept: application/xml

    服务端开启基于header的content negotiation
		1. 添加依赖
        <dependency>
          <groupId>com.fasterxml.jackson.dataformat</groupId>
          <artifactId>jackson-dataformat-xml</artifactId>
        </dependency>
		2. curl -H "Accept: application/xml" http://localhost:8080/person/all
        
JPA customized sql query
	https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-three-custom-queries-with-query-methods/
	public interface UserRepository extends CrudRepository<User, Long>{
		List<User> findAll();
		User findByName(); // 具备name字段
		@Query("SELECT p FROM Person p WHERE LOWER(p.lastName) = LOWER(:lastName)")
		public List<User> find(@Param("lastName") String lastName);
		

	}

Spring data REST

	<dependency>
	  <groupId>org.springframework.boot</groupId>
	  <artifactId>spring-boot-starter-data-rest</artifactId>
	</dependency>

	//自动生成url映射
	@RestResource(path="user", rel="user")
	public interface UserRepository extends CrudRepository<User, Long>{
	}
	

	
```

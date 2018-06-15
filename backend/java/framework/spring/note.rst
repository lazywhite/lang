spring容器
    负责创建对象, 配置对象, 组合对象, 管理对象声明周期
    可以创建任何类型的对象并进行管理
    
容器类型
    BeanFactory
        最基础的容器
    ApplicationContext
        包含BeanFactory功能，还支持事件机制
        

IOC:控制反转
    创建对象不由代码完成, 而由spring容器进行创建 
    解耦合

DI:依赖注入, IoC的一种
    set注入
        bean
            property name="属性名" value=""  //普通类型
            property name="" ref="bean id"  //对象类型
    构造注入
        将对象作为构造函数的参数传入
        可以决定依赖对象的注入顺序
        bean
            constructor-arg index="0" value=""  //按照参数顺序
            constructor-arg type="java.lang.String" value=""  //按照参数类型
    反射注入
        @Autowired
        private UserDao userDao;

Bean的生命周期
    调用构造方法或工厂方法创建实例
    根据配置进行属性赋值
    调用init-method进行初始化
    调用destroy-method进行销毁

创建bean的方法
    类名(反射)模式
        <bean class="" />
    工厂模式
        静态工厂(无需创建工厂实例, 直接调用静态方法)
            <bean id="" class="com.util.UserFactory" factory-method="getUser" >
                <constructor-arg index="0" value="bob" />
        实例工厂(首先要创建一个工厂实例)
            <bean id="userFactory" class="com.util.UserFactory" >
            <bean id="user" factory-bean="userFactory" factory-method="getUser" >
                <constructor-arg index="0" value="bob" />
        FactoryBean泛型接口
            public interface FactoryBean{
                Object getObject() throws Exception;
                Class getObjectType();
                boolean isSingleTon();
            }
            public class UserFactory implements FactoryBean{}

            <bean id="user" class="com.util.UserFactory" />

不同类型值的注入
    list
        <list>
    set
        <set>
    array
        <array>
    map
        <map>
            <entry>
                <key>
                    <value>
                <value>
    properties
        <props>
            <prop key="">xxxx</prop>
    null
        <null /> null值
        <value></value> 空串
    基本类型
    bean对象


值注入用
    <property name="" value="" />
对象注入 <property name="" ref="<bean-id>" />
特殊字符"<", "&" 等的处理
    转义
    <![CDATA[]]>

UserDao ud  = ac.getBean("userDao", com.UserDaomImpl.class) 
UserDao ud  = (UserDao) ac.getBean("userDao")

SpringEL
    

spring 注解
    <context:component-scan  
        base-package="com.local"  
        resource-pattern="dao/impl/*.class" 
        use-default-filter="true"  
            默认扫描@Service, @Controller, @Repository, @Component 
            还会扫描@Autowired, @Resource, @Inject注解
        <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller" 
        <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller" 


    支持泛型依赖注入

<context:property-placeholder location="/path" /> 引用其他的properties文件
    
bean
    id
    name
    autowire
        no     // default
        byName // by property name(bean id要跟属性的名称一致)
        byType // by property data type(bean id跟属性的类型一致)
        constructor
        autodetect
    class
        实现类的路径, 不能是interface
    scope
        singleton
            默认单例模式
        prototype
            原型模式, 每次都创建新的
        request
        session
        global-session

    lazy-init
        延迟bean的创建
    parent 继承bean, 自动获得父bean属性
    depends-on  依赖bean列表, 用空格或逗号隔开
    abstract  抽象bean, 不能被实例化, 只能被继承
    init-method="init" //初始化语句
    destroy-method="destroy" //销毁语句

Annotations
    @Required //只能修饰property setter, 表示此属性必须被设置
    @Autowired(required=false) //默认按照类型装配, required false表示可以为null
    @Qualifier(value="") //消除@Autowired的歧义, 指定某个具体的bean
    @Resource //按照名称装配
    @Controller
    @Service
    @Repository
    @Component






aop: 在哪些类的哪些方法中植入哪个advice
    横切关注点
        一个业务逻辑由多个关注点组成
        对哪些方法进行拦截, 拦截后怎样处理, 这些关注点称为横切关注点
    aspect 切面
        对横切关注点的抽象
        切面由pointcut和advice组成
    advice 通知
        拦截到连接点后要执行的逻辑
            before 前置通知: 作用在目标方法之前
            after-returning 后置通知: 目标方法成功执行之后调用通知
            around 环绕通知
            after-exception 异常通知: 目标方法出现异常时调用通知
            after 最终通知: 不管目标方法有没有执行成功都通知
    pointcut 切入点
        对哪些连接点进行拦截的匹配表达式
    joinpoint 连接点
        被拦截到的点, 一般是方法, 还可以是字段或构造器
    weaving 织入
        将切面应用到目标对象并导致代理对象创建的过程
    introduce 引入
        在不修改代码的前提下, 在运行期间为类动态的添加一些字段或方法


JoinPoint API
    jp.getSignature().getName(); //获取方法名
    jp.getTarget.getClass().getName(); 获取类名
    Object[] jp.getArgs();
如果一个方法同时应用了前置通知和环绕通知, 执行按照xml配置顺序

aop配置
    XML
        <aop:config>
            <aop:aspect>
                <aop:pointcut>
                    @expression
                        within()
                        execution(public * com.local.service..*(..))
                        bean(*Service)
    Annotation
        <aop:aspectj-autoproxy proxy-target-class="true" /> //启用注解支持
        @Aspect
        @Pointcut("execution()")
        private void anyMethod()

        @Before("anyMethod() && args(name)")
        public void doBefore()

        @After("anyMethod()")
        @AfterReturning("anyMethod()")
        @AfterThrowing("anyMethod()")

        @Around("anyMethod()") //pjp有返回, around()方法也要有返回
        public Object around(ProceddingJoinPoint pjp){
            pjp.proceed();
        }

spring 配置
    xml
        FileSystemXML
        ClassPathXML
    java config class
        @Configuration
        @Bean



springMVC
================

keyword
    test
    expression
    messagesource

DispatcherServlet: 主控制器
    默认配置 /WEB-INF/<Servlet-Name>-context.xml
Handler: 获取请求参数, 调用业务模型, 处理请求
HandlerAdaptor: 调用执行对应规则的Handler对象, 相当于struts ActionInvocation
HandlerMapping: 负责url与handler的对应
ViewResolver: 视图解析器
    /WEB-INF/jsp/add.jsp
    prefix: /WEB-INF/jsp
    suffix: .jsp
    逻辑视图名称: add

ModelAndView模型数据和视图
    ModelAndView mav = new ModelAndView("redirect:list"); //类内重定向
    ModelAndView mav = new ModelAndView("forward:list"); //类内转发
    ModelAndView mav = new ModelAndView("user/list");
        
请求处理流程
DispatcherServlet
    HandlerMapping
        HandlerAdaptor
            Handler
               ViewResolver
                    DispatcherServlet

注解分类
    1. 处理uri部分
        @RequestMapping
            value="/pets/{petId}"  (@PathVariable("petId")Integer id)
            value="/url/*" 跟0个或多个字符
            value="/url/???" 跟3个任意字符
            value="/url/**/url/" 代理任意多层路径
            method=RequestMethod.GET 指定请求的方法, 不写不限制
            consumes={"application/json"} 指定提交的内容类型
            produces={"application/xml"} 指定返回的内容类型
            params={"!name", "key=value"} 请求包含或不包含对应键值对才进行处理,否则404
            headers={"Referer=http://www.xx.com"} 请求包含响应header才进行处理
    2. 处理request parameter
        @RequestHeader("Accept-Encoding") String encoding 获取header并注入
        @CookieValue("JSESSIONID") String sessionId 获取cookie并注入
        @SessionAttributes(value={"key1", "key2"}, types={User.class, Dept.class}(只能修饰controller)
            匹配到的名称或对象会被自动同步到session中
        @SessionAttribute("<attr-name>")
            注入session中的attr, 不存在会报错
            还可以使用(ModelMap map|@ModelAttribute("attr"))来获取
        @ModelAttribute
            1. 注解在方法上, 在每个method调用之前执行, 然后插入ModelMap
            2. 注解在request parameter上, 将请求参数绑定给ModelMap
        @DateTimeFormat(pattern="yyyy-MM-dd") 
        @RequestParam(value="name", required="false") String alias 表单名与参数名不一致时使用, required标明是否必须
    3. 处理request body 
        @RequestBody User user(当以post方式传递时)
            $.ajax({url: "http://", 
                data: {
                    id: 1000, 
                    name: "bob"}
                })
        application/x-www-form-data, application/json application/xml格式需要用此注解处理
        默认调用HttpMessageConverter进行转换
        
    5. 处理response 
            @ResponseBody 根据返回内容的类型调用不同的Converter转换后返回
    6. @RestTemplate //调用远程api接口， 将返回转化为Object

方法传值
1. 基本类型 func(String name)
    参数名与函数形参名字一致即可传值
    <input name="name" />
2. 数组 func(String[] interest)
    参数名与函数形参名字一致即可传值
    <input type="checkbox" name="interest" />
    <input type="checkbox" name="interest" />
3. 复合类型 
    User
        name
        age
        Adress
            id
            name
    传入方法
        <input name="name" />
        <input name="age" />
        <input name="address.id" />
        <input name="address.name" />
4. List<User>
    <input name="articles[0].title" />
    <input name="articles[0].content" />
5. Map
    input name='userMap["name"]'
6. Date
    conversion-service
        Formatter
        
        
方法返回值类型
    ModelAndView  走视图解析器 
    String 走视图解析器 
        return "list" 逻辑视图
        return "redirect:/index.jsp" 不走视图解析器
        return "forward:view.jsp" 相对路径, 不走视图解析器
        return "forward:view" 转发到方法
        return "redirect:view" 重定向到方法
        
        resp.sendRedirect("/index.jsp") 不包含项目名
        req.getRequestDispatcher("/index.jsp").forward(req, resp) 包含项目名

        转发不能跳出当前应用, 重定向可以跨域

    void  HttpServletRequest HttpServletResponse HttpSession注入


controller method可以重载,  必须有不同的@RequestMapping


文件上传
    func(MultipartFile inputName)
    配置CommonsMultipartResolver bean

数据校验
    JSR303 API
        Hibernate-validator
    error message 
    @Validated BindingResult要放在一起

国际化
    MessageSource, Locale

token认证
    spring-security
    interceptor


tx:method  @propagation
    REQUIRED：支持当前事务，如果当前没有事务，就新建一个事务。这是最常见的选择。
    SUPPORTS：支持当前事务，如果当前没有事务，就以非事务方式执行。
    MANDATORY：支持当前事务，如果当前没有事务，就抛出异常。
    REQUIRES_NEW：新建事务，如果当前存在事务，把当前事务挂起。
    NOT_SUPPORTED：以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。
    NEVER：以非事务方式执行，如果当前存在事务，则抛出异常。
    NESTED：支持当前事务，如果当前事务存在，则执行一个嵌套事务，如果当前没有事务，就新建一个事务。


springmvc post数据404, 一般是数据注入失败, datetime格式, 属性名字等


HandlerInterceptor //执行顺序如出现顺序
    preHandle
    postHandle
    afterCompletion

jdbcTemplate(不支持内嵌对象, User.articles)
    RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);
    jt.update(sql, obj...) //单条增删改
    jt.batchUpdate(sql, List<Object[]>)//批量操作 
    jt.queryForObject(sql, mapper, args...) 单条查询并封装成User
    jt.queryForObject(sql, Integer.class, args...) 单条查询返回Integer
    jt.query(sql, mapper) //多条查询并封装



Thymeleaf
    thymeleaf-spring4.jar

    <html xmlns:th="http://www.thymeleaf.org" >
    <div th:fragment="copyright">
    <div th:include="footer :: copyright"></div>(fragment选择器, 只引入内容)
    <div th:replace="footer :: copyright"></div>(替换当前标签)
    <div th:include="footer"></div>(加载整个模板)


    <div id="copy-section">
    <div th:include="footer :: #copy-section"></div> (dom选择器)
    <div th:include="header :: (${user.isAdmin}? #{header.admin} : #{header.normaluser})"></div>

    <html xmlns:layout="http://www.ultraq.net.nz/web/thymeleaf/layout" 
        xmlns:th="http://www.thymeleaf.org"
        layout:decorator="base/layout"> 继承父模板
    <div layout:fragment="content" >重写content块


HiddenHttpMethodFilter
    <form method="POST">
        <input type="hidden" name="_method" value="PUT" />

    web.xml
        <filter>
            <filter-class>
        <filter-mapping>
            <servlet-name>
        
CharacterEncodingFilter 配置要放在web.xml的最前面
使用Interceptor需要在spring_mvc.xml中使用mvc:interceptor标签声明

参数注入
    HttpServletRequest
    HttpServletResponse
    HttpServletSession
    java.security.Principal
    Locale
    InputStream
    OutputStream
    Reader
    Writer
    ModelAndView
    ModelMap

DispatcherServlet
    <url-pattern>/</url-pattern>

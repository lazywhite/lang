spring
    整合性质框架, 可以包含struts2, hibernate, mybatis等

spring容器
    负责创建对象, 配置对象, 组合对象, 管理对象声明周期
    对象被称为spring bean
    可以创建任何类型的对象并进行管理
    
容器类型
    BeanFactory
        向后兼容
    AbstractApplicationContext
        推荐使用


IOC:控制反转
    创建对象不由代码完成, 而由spring容器进行创建 
    解耦和

DI:依赖注入, IoC的一种
    set注入
        bean
            property name="属性名" value=""  //普通类型
            property name="" ref="bean id"  //对象类型
    构造注入
        将对象作为构造函数的参数传入
        可以决定依赖对象的注入顺序
    接口注入

    反射注入

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


值注入用value, 对象注入用ref bean
值中的特殊字符需要转义
CDATA 

内部bean
    在property内部定义的bean
外部bean
beans
    default-autowire="byType"
bean
    id
    name
    autowire
        no     // default
        byName // by property name
        byType // by property data type
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
    parent
    abstract
    init-method="init" //初始化语句
    destroy-method="destroy" //销毁语句

Annotations
    @Required //修饰property setter, 必须在xml中为此属性提供值
    @Autowired(required=false)
    @Qualifier(value="") //消除@Autowired的歧义, 指定某个具体的bean
    @Controller
    @Service
    @Repository
    @Component


    @Aspect
    @Pointcut()
    @Before
    @After

AOP
    将一个项目中公共的代码块抽取出来, 形成一个切面对象, 外挂到业务代码中
    事务管理
    日志管理
    权限管理
    登录验证

aop
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


如果一个方法同时应用了前置通知和环绕通知, 执行按照xml配置顺序

<aop:config>
    <aop:aspect>
        <aop:pointcut>
            @expression
                within()
                execution(public * com.local.service..*(..))
                bean(*Service)

@Configuration 代替applicationContext.xml
@Bean

所有的bean不能手工新建, 被spring容器管理才会起作用
使用xml需要实现接口, 使用注解不需要


springMVC
================
    DispatcherServlet: 主控制器
    Handler: 获取请求参数, 调用业务模型, 处理请求
    HandlerAdaptor: 调用执行对应规则的Handler对象, 相当于struts ActionInvocation
    HandlerMapping: 负责url与handler的对应
    ViewResolver: 视图解析器
        /WEB-INF/jsp/add.jsp
        prefix: /WEB-INF/jsp
        suffix: .jsp
        逻辑视图名称: add
    ModelAndView模型数据和视图
        

DispatcherServlet-->HandlerMapping--->HandlerAdaptor-->Handler-->ModelAndView-->ViewResolver


    @RequestMapping
        value="/pets/{petId}
        method=RequestMethod.GET
        consumes="application/json" 指定提交的内容类型
        produces="application/xml" 指定返回的内容类型
        params="key=value" 请求包含对应键值对才进行处理
        headers="Referer=http://www.xx.com" 请求包含响应header才进行处理
    @RequestParam
    @RequestHeader
    @PathVariable
    @RequestBody
        $.ajax({url: "http://", 
            data: {
                id: 1000, 
                name: "bob"}
            })
        当以post方式传递时
    @ResponseBody

方法传值
    参数名与函数形参名字一致即可传值
1. 基本类型 func(String name)
    <input name="name" />
2. 数组 func(String[] interest)
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
    <input name="name"
    <input name="age"
    <input name="address.id"
    <input name="address.name"
4. List<User>
5. Map
    input name='userMap["name"]'
6. Date
    Formatter
        
        
方法返回值类型
    ModelAndView
    String
    void  参数绑定


ModelMap
Model
ModelAndView

controller method 名字可以相同, 可以有不同的@RequestMapping

不使用@Responsebody, 手动返回json
return String 是否走视图解析器
空返回注入原理


文件上传
    func(MultipartFile inputName)
    CommonsMultipartResolver


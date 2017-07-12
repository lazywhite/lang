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
    aspect 切面
    advice 通知
        前置通知: 作用在目标方法之前
        后置通知: 目标方法成功执行之后调用通知
        环绕通知: 先执行一部分切面功能在调用目标方法,再执行切面另外一部分功能
        异常通知: 目标方法出现异常时调用通知
        最终通知: 不管目标方法有没有执行成功都通知
    pointcut 切入点
        需要应用切面的方法的匹配表达式
    joinpoint 连接点
        被作用的对象

如果一个方法同时应用了前置通知和环绕通知, 执行按照xml配置顺序
后置通知获取方法的返回值
pointcut
    expression
        within()
        execution(public * com.local.service..*(..))
        bean(*Service)

@Configuration 代替applicationContext.xml
@Bean

所有的bean不能手工新建, 被spring容器管理才会起作用

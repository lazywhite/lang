spring
    整合性质框架, 可以包含struts2, hibernate, mybatis等

spring容器
    创建对象, 管理对象的工厂(BeanFactory, ApplicationContext)
    可以创建任何类型的对象并进行管理

IOC
    控制反转
    创建对象不由代码完成, 而由spring容器进行创建 

DI
    依赖注入
    set注入
        bean
            property name="属性名" value=""  //普通类型
            property name="" ref="bean id"  //对象类型
    构造注入

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


BeanFactory

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
        byName //根据属性名找id同名的bean
        byType //根据属性的类型, 当多个bean的type相同是会报错
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


AOP
    将一个项目中公共的代码块抽取出来, 形成一个切面对象, 外挂到业务代码中
    事务管理
    日志管理
    权限管理
    登录验证

aop
    切面
    目标对象
    通知
        前置通知: 作用在目标方法之前
        后置通知: 作用在目标方法之后
        环绕通知: 先执行一部分切面功能在调用目标方法,再执行切面另外一部分功能
        异常通知: 当目标方法出现异常时执行切面方法
        最终通知
    切入点
        需要应用切面的方法的匹配表达式


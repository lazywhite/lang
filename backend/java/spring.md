web.xml
    weba-app
        display-name
        listener
        context-param
            param-name: contextConfigLoaction
            param-value: classpath:/config/applicationContext*.xml
        context-param
            param-name: spring.liveBeansView.mbeanDomain
            param-value: <environment>
        filter
            filter-name
            filter-class
        listener
            listener-class: org.springframework.web.util.IntrospectorCleanupListener
        session-config
            session-timeout: 30
        servlet
            servlet-name: springmvc
            servlet-class: org.springframework.web.servlet.DispatcherServlet
            init-param:
                param-name: contextConfigLocation
                param-value: /WEB-INF/springmvc-*.xml
            load-on-startup: 1
        servlet-mapping
            servlet-name: springmvc
            url-pattern: /



applicationContext-config.xml
    beans
        context:annotation-config
        context:component-scan base-package="com.rongzj.jiedianqian"
        bean name="dataSource"
        bean id="jdbcTemplate"
        bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean"
            property name="dataSource" ref="dataSource"
            property name="configLocation" value="classpath:/config/mybatis-config.xml"
            property name="mapperLocations" value="classpath:com/rongzj/jiedianqian/mapping/*.xml"
        bean class="org.mybatis.spring.mapper.MapperScannerConfigure"
            property name="basePackage" value="com.rongzj.jiedianqian.dao"
            property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"
        bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager"
            property name="dataSource" ref="dataSource"
        tx:annotation-driven transaction-manager="transactionManager" proxy-target-class="true"
        bean id="userService" class="com.rongzj.jiedianqian.service.impl.UserServiceImpl"


mybatis-config.xml
    configuration
        settings
            setting name="cacheEnabled" value="true"
            setting name="jdbcTypeForNull" value="NULL"




java.lang.NoClassDefFoundError: org/springframework/web/context/ContextCleanupListener
    web.xml <listener> must be ahead of <servlet>

no UserMapper.java found
    <context:annotation-config />
    <!-- scan annotation -->
    <context:component-scan base-package="com.local.test.sptest"></context:component-scan>


Todo
    Autowired
  
    RedirectView
    ContentNegotiation
    return object, jsp_name, string
    HashMap to Json
        toJSONString(Map map)
    json to object
        parseObject(String data, User.class)
    get post data
        @RequestBody
    controller default method
    db transaction
    jsp
    negotiater

    different response datatype base on request header

    jedis
    mongodb

java
    reflect
    commons-lang3
    IO
        buffer
        writer
        stream
    multiprocessing
        thread
        subprocess

    abstractclass


ldap dump

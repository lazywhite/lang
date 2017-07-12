构建sessionFactory的方法
    1. mybatis-config.xml
    2. java代码

jdbc事务管理, 默认自动提交, 可以关闭自动提交
直接在session上提交事务

mapper.xml
    select
        @id
        @resultType
        @parameterType  完整类名或别名

multi datasource

mybatis自动生成接口实现类
    1. mapper的namespace与接口的完全类名一致
    2. 接口的方法名与语句id一致
    3. 接口的参数类型与语句的parameterType一致
    4. 接口的返回类型与语句的resultType一致

关系映射
    association
    collection

lazyload

一级缓存
    不能跨session使用
二级缓存
    mapper级别
    开启方法
        mybatis-config.xml
            <setting cacheEnable="true">
        mapper.xml
            <cache type="" >
            <select useCache="false"> //禁用缓存
    如果有事务提交,则二级缓存要释放掉
        <update flushCache="true" />

mybatis-generator
mybatis-ehcache

#{}: 占位符
${}: 字符串拼接


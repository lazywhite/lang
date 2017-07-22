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

需要缓存的实体必须实现序列化接口

一级缓存
    不能跨session使用
二级缓存
    在相同的mapper中, 可以跨session使用
    开启方法
        mybatis-config.xml
            <setting cacheEnabled="true">
        mapper.xml
            <cache type="">

缓存生效顺序

二级缓存问题
    1. 禁止使用双向关联, 只使用多对主的单向映射
    2. 使用子查询select语句来映射关联对象
    3. 不管是N-1或N-N映射, 子查询均可使用cache
    4. delete, update, insert语句默认flushCache="true", select *|count(*) 等操作产生的缓存会被清除
    5. select 语句默认flushCache="false", useCache="true"
    

给entity设置private static final long serialVersionUID, 解决序列化问题
mybatis-generator

mybatis-redis 使用JediPool

#{}: 占位符
${}: 字符串拼接


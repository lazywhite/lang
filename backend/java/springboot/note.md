http://start.spring.io/

勾选mysql， mvn package报错
Cannot determine embedded database driver class for database type NONE
    src/main/resource/application.properties
        spring.datasource.url=jdbc:mysql://localhost:3306/test
        spring.datasource.username=root
        spring.datasource.password=root
        spring.datasource.driver-class-name=com.mysql.jdbc.Dr


 No session repository could be auto-configured, check your configuration (session store type is 'null')
    src/main/resource/application.properties
        spring.redis.host=127.0.0.1
        spring.redis.port=6379
 
   src/main/java/com/example/demo/RedisSessionConfig.java
        package com.example.demo;
        /*
         * RedisSessionConfig.java
         * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
         *
         * Distributed under terms of the MIT license.
         */

        import org.springframework.context.annotation.Configuration;
        import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

        @Configuration
        @EnableRedisHttpSession
        public class RedisSessionConfig {
        }



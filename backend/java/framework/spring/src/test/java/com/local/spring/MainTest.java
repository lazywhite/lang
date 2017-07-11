package com.local.spring;

import com.local.spring.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by white on 17/7/10.
 */
public class MainTest {

    @Test
    public void test01(){
        //applicationContext.xml是默认配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl us = (UserServiceImpl)  ac.getBean("userServiceImpl");
        System.out.println(us.findAllUser());

    }
}

package com.local.spring;

import com.local.spring.controller.UserController;
import com.local.spring.service.impl.ArticleServiceImpl;
import com.local.spring.service.impl.UserServiceImpl;
import com.local.spring.util.StringToDate;
import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

/**
 * Created by white on 17/7/10.
 */
public class MainTest {


    @Test
    public void test01(){
        AbstractApplicationContext  ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl us = (UserServiceImpl)  ac.getBean("userServiceImpl");
        us.findUsersCount();
        us.findAllUser();

    }
    @Test
    public void test02(){
        AbstractApplicationContext  ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserController uc = (UserController) ac.getBean("userController");
        uc.findUsers();
    }
    @Test
    public void test03(){
        AbstractApplicationContext  ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        ArticleServiceImpl articleService = (ArticleServiceImpl) ac.getBean("articleServiceImpl");
        articleService.testArticle();
    }
}

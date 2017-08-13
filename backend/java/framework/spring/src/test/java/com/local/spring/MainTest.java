package com.local.spring;

import com.local.spring.dao.AnnoDao;
import com.local.spring.entity.Anno;
import com.local.spring.service.AnnoService;
import com.local.spring.service.impl.AnnoServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by white on 17/8/13.
 */
public class MainTest {

    @Test
    public void test01(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        Anno a = (Anno) ac.getBean("anno");
        System.out.println(a);
        AnnoDao ad = (AnnoDao) ac.getBean("annoDao");
        System.out.println(ad.getList().get(0).getName());
        AnnoServiceImpl as =  ac.getBean("annoService", AnnoServiceImpl.class);
        System.out.println(as.getList().get(0).getName());

    }

}

package com.local.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    /* 避免用户过度开销session */
    static ThreadLocal<Session> threadLocal = new ThreadLocal<>();
    private static SessionFactory sessionFactory;
    static{
        Configuration conf = new Configuration();
//        conf.configure("hibernate.cfg.xml");
        conf.configure();
        /*添加基于注解的实体类的两种方式
            1. conf.addAnnotatedClass
            2. hibernate.cfg.xml
                <mapping class="com.local.entity.PersonAttr />
         */
//        conf.addAnnotatedClass(com.local.entity.PersonAttr.class);
        sessionFactory =  conf.buildSessionFactory();
    }
    public static Session getSession(){
        Session session = threadLocal.get();
        if(session == null || !session.isOpen()) {
            session = sessionFactory.openSession();
            threadLocal.set(session);
        }
        return session;
    }

    public static void closeSession(){
        try{
            threadLocal.get().close();
        }catch(Exception e ){
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

}

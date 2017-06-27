package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    /* 避免用户过度开销session */
    static ThreadLocal<Session> threadLocal = new ThreadLocal<>();
    private static SessionFactory sessionFactory;
    static{
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
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

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

}

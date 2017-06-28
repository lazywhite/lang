import dao.UserDao;
import dao.impl.UserDaoHbmImpl;
import entity.Article;
import entity.User;
import entity.UserInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import util.HibernateUtil;

import java.util.List;
import java.util.Set;


/**
 * Created by white on 17/6/26.
 */
public class Main {
    public static void main(String[] args){


//        testSelect();
//        testInsert();
        testOne2Many();
    }

    public static void basic(){
        UserDaoHbmImpl ud = new UserDaoHbmImpl();
        //查询
        User u1 = ud.findById(11);
        System.out.println(u1);
        //更新
        u1.setName("worrier");
        ud.update(u1);
        //新增
        User u2 = new User("marray", "password") ;
        ud.create(u2);
        System.out.println(u2.getId());
        //删除
        ud.delete(u2);
    }

    public static void testSelect(){
//        Session session = HibernateUtil.getSession();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session currentSession = sessionFactory.getCurrentSession();//mapping配置current_session_context_class后, 事务提交自动关闭session
        Transaction tx =  currentSession.beginTransaction();//即使是select操作也要开启事务

        User u = (User)currentSession.get(User.class, 3);
        System.out.println(u.getUserinfo().getLocation());

        UserInfo uinfo = (UserInfo)currentSession.get(UserInfo.class, 3);
        System.out.println(uinfo.getUser().getName());

        tx.commit();
    }

    public static void testInsert(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        User u = new User();
        u.setName("alice");
        u.setPassword("hehe");
        UserInfo uinfo  = new UserInfo();
        uinfo.setLocation("北京");
        uinfo.setUser(u);
        session.save(uinfo);
        session.save(u);  //不开启cascade, 如果不执行此语句会报错
        tx.commit();
    }

    public static void testOne2Many(){
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        User u = (User) session.get(User.class, 7);
        for(Article a: u.getArticles()){
            System.out.println(a.getContent());
        }
        Article a = (Article) session.get(Article.class, 4);
        System.out.printf("get user by article" + a.getUser().getName());

        User u2 = new User();
        u2.setName("celine");
        u2.setPassword("akdjf");

        Article a1 = new Article();
        a1.setContent("content 01");
        Article a2 = new Article();
        a2.setContent("content 02");

        a1.setUser(u2);
        a2.setUser(u2);

        session.save(u2);
        session.save(a1);
        session.save(a2);
        tx.commit();
        //无法获取articles问题
//        for(Article b: u2.getArticles()){
//            System.out.println(b.getContent());
//        }

        HibernateUtil.closeSession();
    }
}

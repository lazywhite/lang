import dao.UserDao;
import dao.impl.UserDaoHbmImpl;
import entity.User;
import entity.UserInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;


/**
 * Created by white on 17/6/26.
 */
public class Main {
    public static void main(String[] args){


//        testSelect();
        testInsert();
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
}

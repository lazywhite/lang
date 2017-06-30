package com.local;

/**
 * Created by white on 17/6/30.
 */
import com.local.dao.impl.UserDaoHbmImpl;
import com.local.util.HibernateUtil;
import com.local.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by white on 17/6/26.
 */
public class Main {
    public static void main(String[] args){


//        testSelect();
//        testInsert();
//        testOne2Many();
//        testMany2Many();
//        test1NJoin();
//        test1Nreverse();
//        hqlTest01();
//testAnnotation();
        testOne2OneByPrimaryKey();
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

    public static void testMany2Many(){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        try{

            User u = (User)session.get(User.class, 7);
            System.out.printf(u.getName());
            for(Role role: u.getRoles()){
                System.out.println(role.getName());
            }

            Role r = (Role) session.get(Role.class, 2);
            for(User user : r.getUsers()){
                System.out.println(user.getName());
            }

            Role r1 = new Role();
            r1.setName("协管员");
            User u1 = new User();
            u1.setName("huni");
            u1.setPassword("pwd");

            Set<Role> roles = new HashSet<>();
            roles.add(r);
            roles.add(r1);

            u1.setRoles(roles);//此处会保存映射关系, save(u1)的时候必须由user表来负责映射才能成功保存, 即role.hbm.xml要配置inverse="true"
            session.save(u1);
            session.save(r1);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        HibernateUtil.closeSession();

    }

    public static void test1NJoin(){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        try{
        /* 新建操作 */
//            User u = new User("lilian" , "pass");
//            Park p = new Park("北京中关村");
//            u.setPark(p);
//            session.save(u);
        /* 删除操作 */
            User u = (User)session.get(User.class, 23);
            /*
            即使配置了lazy, 仍然查询了多余的表
                select
                    user0_.id as id1_8_0_,
                    user0_.name as name2_8_0_,
                    user0_.password as password3_8_0_,
                    user0_1_.pid as pid2_6_0_,
                    userinfo1_.id as id1_0_1_,
                    userinfo1_.location as location2_0_1_,
                    userinfo1_.uid as uid3_0_1_,
                    articles2_.uid as uid3_1_2_,
                    articles2_.id as id1_1_2_,
                    articles2_.id as id1_1_3_,
                    articles2_.content as content2_1_3_,
                    articles2_.uid as uid3_1_3_
                from
                    user user0_
                inner join
                    map_user_park user0_1_
                        on user0_.id=user0_1_.uid
                left outer join
                    test.user_info userinfo1_
                        on user0_.id=userinfo1_.uid
                left outer join
                    article articles2_
                        on user0_.id=articles2_.uid
                where
                    user0_.id=?
             */
            session.delete(u);

            transaction.commit();


        }catch(Exception e){
            transaction.rollback();
        }
        HibernateUtil.closeSession();

    }

    public static void test1Nreverse(){
        /*基于中间表的 1-N 双向 */
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        System.out.println("what");

        try{
            Park p = (Park)session.get(Park.class, 7);
            System.out.println(p.getLoc());
            for(User user: p.getUsers()){
                System.out.println(user.getName());
            }
            transaction.commit();

        }catch(Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        HibernateUtil.closeSession();
    }

    public static void hqlTest01(){
        Session session = HibernateUtil.getSession();
//        String hql = "select u.name, count(u.id) from Article a join a.user u group by u.name";
//        String hql = "select r1.id, count(r1.id) from Role r1 join r1.users group by r1.id having count(r1.id) > (select count(*) from Role r join r.users where r.id = 3 group by r.id)";
//        String hql = "select r1.id, count(r1.id) from Role r1 join r1.users group by r1.id";
        String sql = "select * from user";
//        Query q = session.createQuery(hql);
        Query q = session.createSQLQuery(sql);
//        q.setMaxResults(5);
//        q.setFirstResult(2);   //limit 2, 5;
        List<Object[]> list = q.list();
        for(Object[] u: list){
            System.out.println(u[0] + ":" + u[1]);
        }
    }

    public static void testOne2OneByPrimaryKey() {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        Person p = session.get(Person.class, 1);
//        PersonAttr pa = new PersonAttr();
//        pa.setAttr("good");
//        pa.setPerson(p);
//        session.save(pa);
        System.out.println(p.getAttr().getAttr());

        Person p1 = new Person();
        p1.setName("bob");
        PersonAttr pa1 = new PersonAttr();
        pa1.setAttr("good");
        pa1.setPerson(p1);
        session.save(p1);
        tx.commit();
        HibernateUtil.closeSession();

    }
}

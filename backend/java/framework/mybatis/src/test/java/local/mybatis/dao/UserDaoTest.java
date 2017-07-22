package local.mybatis.dao;

import local.mybatis.dao.UserDao;
import local.mybatis.entity.Article;
import local.mybatis.entity.User;
import local.mybatis.util.MybatisUtil;
import local.mybatis.util.Page;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by white on 17/7/4.
 */
public class UserDaoTest {
    private SqlSession session;
    private UserDao userDao;

    @Before
    public void getSession(){
        session = MybatisUtil.getSession();
        userDao = session.getMapper(UserDao.class);
    }
    @After
    public void closeSession(){
        session.close();
    }

    @Test
    public void testGetUserById(){
        User u = userDao.getUserById(125);
        System.out.println(u.getName());
    }

    @Test
    public void testSelectPage(){
        Map<String, Object> condition = new HashMap<>();
//        condition.put("name", "%b%");
        condition.put("password", "%b%");
        Page p = new Page();
        p.setCondition(condition);

        p.setTotalRecords(userDao.getUsersCount(p));
        p.setCurPage(1);
        List<User> list = userDao.selectPage(p);

        for(User u : list){
            System.out.println(u.getName());
        }
    }
    @Test
    public void testUpdateUser(){
        User u = userDao.getUserById(125);
        u.setName("changed");
        u.setPassword(null);
        userDao.updateUser(u);
        session.commit();
    }

    @Test
    public void testGetCount(){
        Page p = new Page();
        System.out.println(userDao.getUsersCount(p));
    }

    @Test
    public void testDelete(){
        User u = new User("testUser", "1234");
        userDao.createUser(u);
        session.commit();
        System.out.println(u.getId());
        userDao.deleteUser(u);
        session.commit();
    }

    @Test
    public void testCreate() {
        User u = new User("testUser", "1234");
        userDao.createUser(u);
        session.commit();
    }

    @Test
    public void testGetUserByAuth(){
        User u = userDao.getUserByAuth("test7", "pass");
        System.out.println(u.getId());
    }

    @Test
    public void testGetAllUsers(){
        List<User> users = userDao.getAllUsers();
        System.out.println(users.size());
    }
}

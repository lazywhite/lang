package local.mybatis.dao;

import local.mybatis.dao.UserDao;
import local.mybatis.entity.Article;
import local.mybatis.entity.User;
import local.mybatis.util.MybatisUtil;
import local.mybatis.util.Page;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by white on 17/7/4.
 */
public class UserDaoTest {

    @Test
    public void testGetUserById(){
        SqlSession session = MybatisUtil.getSession();
        //无需写DAO实现类, 根据规则自动生成
        UserDao userMapper = session.getMapper(UserDao.class);
        System.out.println(userMapper.getClass().getName());
        User u = userMapper.getUserById(7);
        System.out.println(u.getName());
        System.out.println("===== before lazy loading =====");
        List<Article> articles = u.getArticles();
        for(Article a: articles){
            System.out.println(a.getContent());
//            System.out.println(a.getUser().getName());  重复调用
        }
        session.close();
    }

    @Test
    public void testSelectPage(){
        SqlSession session = MybatisUtil.getSession();
        //无需写DAO实现类, 根据规则自动生成
        UserDao userMapper = session.getMapper(UserDao.class);
        Map<String, Object> condition = new HashMap<>();
//        condition.put("name", "%b%");
        condition.put("password", "%b%");
        Page p = new Page();
        p.setCondition(condition);

        p.setTotalRecords(userMapper.getUsersCount(p));
        p.setCurPage(1);
        List<User> list = userMapper.selectPage(p);

        for(User u : list){
            System.out.println(u.getName());
        }
        session.close();
    }
    @Test
    public void testUpdateUser(){
        SqlSession session = MybatisUtil.getSession();
        UserDao userMapper = session.getMapper(UserDao.class);
        User u = userMapper.getUserById(4);
        u.setName("changed");
        u.setPassword(null);
        userMapper.updateUser(u);
        session.commit();
        session.close();
    }

    @Test
    public void testDeleteUser(){
        SqlSession session = MybatisUtil.getSession();
        UserDao userMapper = session.getMapper(UserDao.class);
        int[] ids = new int[]{1, 2, 3};
        userMapper.deleteUser(ids);
//        session.commit();
        session.close();
    }

    @Test
    public void testGetUserByAuth(){
        SqlSession session = MybatisUtil.getSession();
        UserDao userMapper = session.getMapper(UserDao.class);
        User u = userMapper.getUserByAuth("test7", "pass");
        System.out.println(u.getId());
        session.close();
    }

}

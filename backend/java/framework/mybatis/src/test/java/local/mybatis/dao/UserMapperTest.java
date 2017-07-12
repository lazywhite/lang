package local.mybatis.dao;

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
public class UserMapperTest {
    private SqlSession session;
    private UserMapper userMapper;

    @Before
    public void getSession(){
        session = MybatisUtil.getSession();
        userMapper = session.getMapper(UserMapper.class);
    }
    @After
    public void closeSession(){
        session.close();
    }

    @Test
    public void testGetUserById(){
        User u = userMapper.getUserById(7);
        System.out.println(u.getName());
        List<Article> articles = u.getArticles();
        for(Article a: articles){
            System.out.println(a.getContent());
//            System.out.println(a.getUser().getName());  重复调用
        }
    }

    @Test
    public void testSelectPage(){
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
    }
    @Test
    public void testUpdateUser(){
        User u = userMapper.getUserById(4);
        u.setName("changed");
        u.setPassword(null);
        userMapper.updateUser(u);
        session.commit();
    }

    @Test
    public void testDeleteUser(){
        int[] ids = new int[]{1, 2, 3};
        userMapper.deleteUser(ids);
//        session.commit();
    }

    @Test
    public void testGetUserByAuth(){
        User u = userMapper.getUserByAuth("test7", "pass");
        System.out.println(u.getId());
    }

}

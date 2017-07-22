package local.mybatis.dao;

import local.mybatis.dao.ParkDao;
import local.mybatis.entity.Park;
import local.mybatis.entity.User;
import local.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by white on 17/7/5.
 */
public class ParkDaoTest {

    private SqlSession session;
    private ParkDao pd;
    private UserDao ud;
    @Before
    public void getSession(){
        session = MybatisUtil.getSession();
        pd = session.getMapper(ParkDao.class);
        ud = session.getMapper(UserDao.class);
    }

    @After
    public void closeSession(){
        session.close();
    }

    @Test
    public void testGetParkById(){
        Park p = pd.getParkById(7);
        System.out.println("------before get users ------");
        List<User> users = p.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }


    @Test
    public void testAddUser(){
        Park p = pd.getParkById(7);
        User u = new User("forPark", "1234");
        ud.createUser(u);
        pd.addUser(p, u);
        session.commit();
    }
}

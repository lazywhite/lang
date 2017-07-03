package local.mybatis;

import local.mybatis.dao.UserDao;
import local.mybatis.dao.impl.UserDaoImpl;
import local.mybatis.entity.User;
import org.junit.Test;
import java.util.Random;

/**
 * Created by white on 17/7/3.
 */
public class testUserDao {
    UserDao ud = new UserDaoImpl();
    Random r = new Random();
    @Test
    public void testSelect(){
        User u = ud.getUserById(11);
        System.out.println(u.getName());
    }

    @Test
    public void testInsert(){
        String name = "test" + r.nextInt(100);
        User u = new User(name, "pass");
        ud.createUser(u);
        User u1 = ud.getUserByName(name);
        System.out.println(u1.getName());

    }
    @Test
    public void testUserCount(){
        System.out.println(ud.getUsersCount());
    }

}

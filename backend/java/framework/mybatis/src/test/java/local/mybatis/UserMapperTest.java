package local.mybatis;

import local.mybatis.dao.UserDao;
import local.mybatis.entity.User;
import local.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created by white on 17/7/4.
 */
public class UserMapperTest {

    @Test
    public void testGetUserById(){
        SqlSession session = MybatisUtil.getSession();
        //无需写DAO实现类, 根据规则自动生成
        UserDao userMapper = session.getMapper(UserDao.class);
        System.out.println(userMapper.getClass().getName());
        User u = userMapper.getUserById(7);
        System.out.println(u.getName());
        session.close();
    }

}

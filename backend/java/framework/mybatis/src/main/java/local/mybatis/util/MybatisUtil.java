package local.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by white on 17/7/3.
 */
public class MybatisUtil {
    private static SqlSessionFactory sessionFactory;
    static{
        String resource="mybatis-config.xml";
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sessionFactory = new SqlSessionFactoryBuilder().build(is);
    }

    public static SqlSessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static SqlSession getSession(){
        return sessionFactory.openSession(false); //关闭自动提交
    }


}

package local.mybatis.dao;

import local.mybatis.entity.Article;
import local.mybatis.util.MybatisUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by white on 17/7/5.
 */
public class ArticleMapperTest {
    private SqlSession session;
    private ArticleMapper userMapper;

    @Before
    public void getSession(){
        session = MybatisUtil.getSession();
        userMapper = session.getMapper(ArticleMapper.class);
    }
    @After
    public void closeSession(){
        session.close();
    }

    @Test
    public void testGetArticleById(){
        SqlSession session = MybatisUtil.getSession();
        ArticleMapper ad = session.getMapper(ArticleMapper.class);
        Article a = ad.getArticleById(1);
        System.out.println(a.getContent());
        System.out.println(a.getUser().getName());
    }

}

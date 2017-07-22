package local.mybatis.dao;

import local.mybatis.dao.ArticleDao;
import local.mybatis.entity.Article;
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
public class ArticleDaoTest {
    private SqlSession session;
    private ArticleDao ad;
    private UserDao ud;
    @Before
    public void getSession(){
        session = MybatisUtil.getSession();
        ad = session.getMapper(ArticleDao.class);
        ud = session.getMapper(UserDao.class);

    }

    @After
    public void closeSession(){
        session.close();
    }

    @Test
    public void testGetArticleById(){
        Article a = ad.getArticleById(1);
        System.out.println(a.getContent());
        System.out.println("====== before get user ========");
        System.out.println(a.getUser());
    }


    @Test
    public void testSessionCache(){
        Article a = ad.getArticleById(1);
        System.out.println(a.getContent());
        System.out.println("======== 一级缓存 ==========");
        Article b = ad.getArticleById(1);
        System.out.println(b.getContent());
    }

    @Test
    public void testSessionCache02(){
        SqlSession session = MybatisUtil.getSession();
        ArticleDao am = session.getMapper(ArticleDao.class);
        Article a = am.getArticleById(1);
        System.out.println(a.getContent());
        a.setContent("hehehe");
        am.updateArticle(a);
        session.commit();
        System.out.println("======== 更新object后的一级缓存 ==========");
        Article b = am.getArticleById(1);
        System.out.println(b);
        b.setContent("what");
        am.updateArticle(b);
        session.commit();
        session.close();
    }

    @Test
    public void testRedisCache(){
        SqlSession session = MybatisUtil.getSession();
        ArticleDao am = session.getMapper(ArticleDao.class);
        Article a = am.getArticleById(1);
        System.out.println(a);
        session.close();
        System.out.println("======== 二级缓存 ==========");
        SqlSession session1 = MybatisUtil.getSession();
        ArticleDao am1 = session1.getMapper(ArticleDao.class);
        Article a1 = am1.getArticleById(1);
        System.out.println(a);
    }

    @Test
    public void testRedisCache02(){
        Article a = ad.getArticleById(1);
        System.out.println(a);
        a.setContent("why");
        ad.updateArticle(a);
        session.commit();
        session.close();
        System.out.println("======== 更新object之后的二级缓存 ==========");
        SqlSession session1 = MybatisUtil.getSession();
        ArticleDao am1 = session1.getMapper(ArticleDao.class);
        Article a1 = am1.getArticleById(1);
        System.out.println(a);
    }

    @Test
    public void testCreate(){
        User u = ud.getUserById(125);
        System.out.println(u.getName());
        Article a = new Article();
        a.setContent("test");
        a.setUser(u);
        ad.saveArticle(a);
        session.commit();
    }

    @Test
    public void testDelete(){
        List<Article> articles = ad.getArticlesByUID(125);
        ad.deleteArticle(articles.get(0));
        session.commit();

    }
}

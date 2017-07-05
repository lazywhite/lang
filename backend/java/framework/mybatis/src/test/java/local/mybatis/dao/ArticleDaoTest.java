package local.mybatis.dao;

import local.mybatis.entity.Article;
import local.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created by white on 17/7/5.
 */
public class ArticleDaoTest {

    @Test
    public void testGetArticleById(){
        SqlSession session = MybatisUtil.getSession();
        ArticleDao ad = session.getMapper(ArticleDao.class);
        Article a = ad.getArticleById(1);
        System.out.println(a.getContent());
        System.out.println("======== before lazyloading ========");
        System.out.println(a.getUser().getName());
    }

}

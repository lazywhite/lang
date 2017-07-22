package local.mybatis.dao;

import local.mybatis.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by white on 17/7/5.
 */
public interface ArticleDao {

    Article getArticleById(@Param("id") Integer id);
    List<Article> getArticlesByUID(@Param("uid") Integer uid);
    void updateArticle(Article article);
    void deleteArticle(Article article);
    void batchDelete(List<Article> articles);
    void saveArticle(Article article);

}

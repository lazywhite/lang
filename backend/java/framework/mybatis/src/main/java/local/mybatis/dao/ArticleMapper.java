package local.mybatis.dao;

import local.mybatis.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by white on 17/7/5.
 */
public interface ArticleMapper {

    Article getArticleById(@Param("id") Integer id);
    List<Article> getArticlesByUID(@Param("uid") Integer uid);

}

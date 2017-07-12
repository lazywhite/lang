package com.local.spring.dao.impl;

import com.local.spring.dao.ArticleDao;
import org.springframework.stereotype.Repository;

/**
 * Created by white on 17/7/10.
 */

@Repository
public class ArticleMybatisDao implements ArticleDao {
    public ArticleMybatisDao() {
        System.out.println("ArticleMybatisDao created");
    }
}

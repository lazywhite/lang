package com.local.spring.service.impl;

import com.local.spring.dao.impl.ArticleMybatisDao;
import com.local.spring.dao.ArticleDao;

/**
 * Created by white on 17/7/10.
 */
public class ArticleServiceImpl {
    ArticleDao articleDao;
    public ArticleServiceImpl(ArticleMybatisDao articleMybatisDao) {
        this.articleDao = articleDao;
    }

    public ArticleServiceImpl() {
    }
}

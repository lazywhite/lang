package com.local.spring.service.impl;

import com.local.spring.dao.impl.ArticleMybatisDao;
import com.local.spring.dao.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by white on 17/7/10.
 */

@Service
public class ArticleServiceImpl {
    @Autowired
    @Qualifier("articleMybatisDao")
    ArticleDao articleDao;

    public ArticleServiceImpl() {
    }

    public String testArticle(){
        return "done";
    }
}

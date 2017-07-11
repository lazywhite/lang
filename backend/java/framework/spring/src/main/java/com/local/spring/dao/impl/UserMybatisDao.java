package com.local.spring.dao.impl;

import com.local.spring.dao.UserDao;
import com.local.spring.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository  //一般放在数据持久访问层类上
public class UserMybatisDao implements UserDao {
    public UserMybatisDao() {
        System.out.println("mybatis dao created");
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    public void init(){
        System.out.println("init called");
    }

    public void destroy(){
        System.out.println("destroy called");
    }
}

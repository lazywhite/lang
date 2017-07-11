package com.local.spring.dao.impl;

import com.local.spring.dao.UserDao;
import com.local.spring.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserHBMDao implements UserDao {
    public UserHBMDao() {
        System.out.println("hbm dao created");
    }

    @Override
    public List<User> findAll() {
        User u = new User("bob", "1234");
        List<User> list = new ArrayList<>();
        list.add(u);
        return list;
    }
}
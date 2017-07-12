package com.local.spring.service.impl;

import com.local.spring.dao.UserDao;
import com.local.spring.service.UserService;
import com.local.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by white on 17/7/10.
 */

@Service
@Lazy //default "true"
public class UserServiceImpl implements UserService {
    public UserServiceImpl() {
        System.out.println("user service created");
    }

    @Autowired //无需getter, setter
    @Qualifier(value="userHBMDao") //区分到底使用哪个实现类

//    @Resource(name="userMybatisDao")
    private UserDao userDao;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("name injected");
        this.name = name;
    }

    @Override
    public List<User> findAllUser(){
        return userDao.findAll();
    }


    @Override
    public User findUserByID(int id){
        return userDao.findByID(id);
    }

    @Override
    public int findUsersCount() {
        return 1000;
    }
}

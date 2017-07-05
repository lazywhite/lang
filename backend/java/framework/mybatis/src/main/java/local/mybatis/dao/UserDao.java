package local.mybatis.dao;
/*
 * UserDao.java
 * Copyright (C) 2017 white <white@localhost>
 *
 * Distributed under terms of the MIT license.
 */

import local.mybatis.entity.User;
import local.mybatis.util.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
     
    User getUserById(@Param("id") int id); //可以省略 parameterType, 多个条件时不必封装为map传进去
    List<User> getUsers();

    void createUser(User u);

    void updateUser(User u);

    User getUserByAuth(@Param("name") String name, @Param("password") String password);

    Integer getUsersCount(Page p);

    //方法语法上可以重载, 但因为要跟UserMapper.xml结合使用, 有语句ID限制 不能重载
    List<User> selectPage(Page p);
    void deleteUser(@Param("ids") int[] ids);

}


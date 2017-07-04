package local.mybatis.dao;
/*
 * UserDao.java
 * Copyright (C) 2017 white <white@localhost>
 *
 * Distributed under terms of the MIT license.
 */

import local.mybatis.entity.User;
import local.mybatis.util.Page;

import java.util.List;

public interface UserDao {
     
    User getUserById(int id);
    List<User> getUsers();

    void createUser(User u);

    void updateUser(User u);

    User getUserByName(String name);

    Integer getUsersCount(Page p);

    //方法语法上可以重载, 但因为要跟UserMapper.xml结合使用, 有语句ID限制 不能重载
    List<User> selectPage(Page p);
    void deleteUser(int[] ids);
}


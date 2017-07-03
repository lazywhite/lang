package local.mybatis.dao;
/*
 * UserDao.java
 * Copyright (C) 2017 white <white@localhost>
 *
 * Distributed under terms of the MIT license.
 */

import local.mybatis.entity.User;

import java.util.List;

public interface UserDao {
     
    User getUserById(int id);
    List<User> getUsers();

    void createUser(User u);

    void changeUserPassword(User u);

    void deleteUser(User u);

    User getUserByName(String name);

    Integer getUsersCount();
}


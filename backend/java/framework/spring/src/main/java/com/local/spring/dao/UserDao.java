package com.local.spring.dao;/*
 * UserDao.java
 * Copyright (C) 2017 white <white@localhost>
 *
 * Distributed under terms of the MIT license.
 */

import com.local.spring.entity.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User findByID(int id);
}


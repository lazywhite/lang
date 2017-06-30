package com.local.dao;

import com.local.entity.User;

import java.util.List;

/**
 * Created by white on 17/6/26.
 */
public interface UserDao {
    User findById(Integer id);
    void update(User u);
    void delete(User u);
    void create(User u);
    List<User> getAll();
}

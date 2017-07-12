package com.local.spring.service;

import com.local.spring.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by white on 17/7/10.
 */

public interface UserService {

    List<User> findAllUser();

    User findUserByID(int id);
    int findUsersCount();
}

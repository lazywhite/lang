package com.local.spring.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;
import java.util.*;

/**
 * Created by white on 17/6/26.
 * +----------+-------------+------+-----+---------+----------------+
 | Field    | Type        | Null | Key | Default | Extra          |
 +----------+-------------+------+-----+---------+----------------+
 | id       | int(11)     | NO   | PRI | NULL    | auto_increment |
 | name     | varchar(30) | YES  |     | NULL    |                |
 | password | varchar(60) | YES  |     | NULL    |                |
 +----------+-------------+------+-----+---------+----------------+

 */

public class User {

    private Integer id;
    @NotEmpty(message="{user.name.empty}")
    private String name;
    @Size(min=6, max=20, message="{password.length.error}")
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

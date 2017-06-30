package com.local.entity;

import java.util.HashSet;
import java.util.Set;

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
    private String name;
    private String password;
    private UserInfo userinfo;
    private Set<Article> articles = new HashSet<>();
    private Set<Role> roles = new HashSet<>();

    private Park park;

    public Park getPark() {
        return park;
    }

    public void setPark(Park park) {
        this.park = park;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

    public UserInfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(UserInfo userinfo) {
        this.userinfo = userinfo;
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

    public User() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setPassword(String password) {
        this.password = password;
    }


}

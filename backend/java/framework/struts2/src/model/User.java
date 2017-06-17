package model;

import java.util.Date;

/**
 * Created by white on 17/6/16.
 */
public class User {
    private String name;
    private String password;
    private Date birthDay;
    public Integer[] getHobby() {
        return hobby;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public void setHobby(Integer[] hobby) {
        this.hobby = hobby;
    }

    private Integer[] hobby;

    public User() {
        System.out.println("实例化User");
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        System.out.println("注入password");
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("注入user name");
        this.name = name;
    }
}

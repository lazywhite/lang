package model;

import java.util.Date;

/**
 * Created by white on 17/6/16.
 */
public class User {
    private String name;
    private String password;
    private Date birthDay;
    private String[] hobby;

    public String getPortraitPath() {
        return portraitPath;
    }

    public void setPortraitPath(String portraitPath) {
        this.portraitPath = portraitPath;
    }

    private String portraitPath;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
    public User() {
        System.out.println("实例化User");
    }
}

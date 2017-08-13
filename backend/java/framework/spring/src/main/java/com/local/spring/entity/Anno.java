package com.local.spring.entity;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by white on 17/7/14.
 */
public class Anno {

    @NotEmpty(message="{anno.name.empty}")
    private String name;

    @Size(min=6, max=20, message="{password.length.error}")
    private String password;
    private Integer gender;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private Integer[] interest;

    public String getName() {
        return name;
    }

    public Anno(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Anno() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer[] getInterest() {
        return interest;
    }

    public void setInterest(Integer[] interest) {
        this.interest = interest;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Anno{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

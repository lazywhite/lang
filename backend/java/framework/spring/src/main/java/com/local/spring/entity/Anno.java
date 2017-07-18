package com.local.spring.entity;

import java.util.Date;

/**
 * Created by white on 17/7/14.
 */
public class Anno {

    private String name;
    private Integer gender;
    private Date birthday;
    private Integer[] interest;

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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
}

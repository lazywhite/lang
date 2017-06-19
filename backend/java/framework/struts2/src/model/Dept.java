package model;
import java.io.Serializable;
/*
 * Emp.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
+----------+-------------+------+-----+---------+-------+
| Field    | Type        | Null | Key | Default | Extra |
+----------+-------------+------+-----+---------+-------+
| deptno   | int(11)     | NO   |     | NULL    |       |
| deptname | varchar(30) | YES  |     | NULL    |       |
| loc      | varchar(30) | YES  |     | NULL    |       |
+----------+-------------+------+-----+---------+-------+

*/


public class Dept implements Serializable{
    private Integer deptno;

    public Dept() {
    }

    public Integer getDeptno() {

        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    private String deptname;
    private String loc;
}


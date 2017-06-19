package model;
import java.io.Serializable;
import java.util.Date;
/*
 * Emp.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
+----------+-------------+------+-----+---------+-------+
| Field    | Type        | Null | Key | Default | Extra |
+----------+-------------+------+-----+---------+-------+
| empno    | int(4)      | YES  |     | NULL    |       |
| ename    | varchar(30) | YES  |     | NULL    |       |
| job      | varchar(30) | YES  |     | NULL    |       |
| salary   | float       | YES  |     | NULL    |       |
| bonus    | double      | YES  |     | NULL    |       |
| sex      | varchar(10) | YES  |     | NULL    |       |
| hiredate | date        | YES  |     | NULL    |       |
| deptno   | int(4)      | YES  |     | NULL    |       |
+----------+-------------+------+-----+---------+-------+
*/

public class Emp implements Serializable{
    private Integer empno;
    private String ename;
    private String job;
    private Float salary;
    private Double bonus;
    private String sex;
    private Date hiredate;
    private Dept dept;

    public Emp() {
    }

    public Integer getEmpno() {

        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Dept getDept() {
        return dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "ename='" + ename + '\'' +
                '}';
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}


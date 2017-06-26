package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Date;

/**
 * Created by white on 17/6/26.
 */
@Entity
public class Empbak {

    private Integer empno;
    private String ename;
    private String job;
    private Double salary;
    private Double bonus;
    private String sex;
    private Integer age;
    private Date hiredate;
    private Integer manager;
    private Integer deptno;

    @Basic
    @Column(name = "empno")
    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    @Basic
    @Column(name = "ename")
    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    @Basic
    @Column(name = "job")
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Basic
    @Column(name = "salary")
    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "bonus")
    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "hiredate")
    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    @Basic
    @Column(name = "manager")
    public Integer getManager() {
        return manager;
    }

    public void setManager(Integer manager) {
        this.manager = manager;
    }

    @Basic
    @Column(name = "deptno")
    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Empbak empbak = (Empbak) o;

        if (empno != null ? !empno.equals(empbak.empno) : empbak.empno != null) return false;
        if (ename != null ? !ename.equals(empbak.ename) : empbak.ename != null) return false;
        if (job != null ? !job.equals(empbak.job) : empbak.job != null) return false;
        if (salary != null ? !salary.equals(empbak.salary) : empbak.salary != null) return false;
        if (bonus != null ? !bonus.equals(empbak.bonus) : empbak.bonus != null) return false;
        if (sex != null ? !sex.equals(empbak.sex) : empbak.sex != null) return false;
        if (age != null ? !age.equals(empbak.age) : empbak.age != null) return false;
        if (hiredate != null ? !hiredate.equals(empbak.hiredate) : empbak.hiredate != null) return false;
        if (manager != null ? !manager.equals(empbak.manager) : empbak.manager != null) return false;
        if (deptno != null ? !deptno.equals(empbak.deptno) : empbak.deptno != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = empno != null ? empno.hashCode() : 0;
        result = 31 * result + (ename != null ? ename.hashCode() : 0);
        result = 31 * result + (job != null ? job.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (bonus != null ? bonus.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (hiredate != null ? hiredate.hashCode() : 0);
        result = 31 * result + (manager != null ? manager.hashCode() : 0);
        result = 31 * result + (deptno != null ? deptno.hashCode() : 0);
        return result;
    }
}

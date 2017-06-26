package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by white on 17/6/26.
 */
@Entity
public class Dept {

    private int deptno;
    private String deptname;
    private String loc;

    @Basic
    @Column(name = "deptno")
    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    @Basic
    @Column(name = "deptname")
    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    @Basic
    @Column(name = "loc")
    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dept dept = (Dept) o;

        if (deptno != dept.deptno) return false;
        if (deptname != null ? !deptname.equals(dept.deptname) : dept.deptname != null) return false;
        if (loc != null ? !loc.equals(dept.loc) : dept.loc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = deptno;
        result = 31 * result + (deptname != null ? deptname.hashCode() : 0);
        result = 31 * result + (loc != null ? loc.hashCode() : 0);
        return result;
    }
}

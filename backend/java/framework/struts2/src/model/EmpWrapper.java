package model;

/**
 * Created by white on 17/6/19.
 */
public class EmpWrapper extends Emp{
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    private String deptName;

}

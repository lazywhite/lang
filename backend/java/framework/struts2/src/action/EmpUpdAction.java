package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.EmpDao;
import dao.impl.EmpDaoImpl;
import model.Emp;

/**
 * Created by white on 17/6/19.
 */
public class EmpUpdAction extends ActionSupport{
    private Emp emp;

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public Emp getEmp() {
        return emp;
    }

    private EmpDao ed = new EmpDaoImpl();
    @Override
    public String execute() throws Exception {
        ed.update(emp);
        return "success";
    }
}

package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.DeptDao;
import dao.EmpDao;
import dao.impl.DeptDaoImpl;
import dao.impl.EmpDaoImpl;
import model.Dept;
import model.Emp;

import java.util.List;

/**
 * Created by white on 17/6/19.
 */
public class EmpToUpdAction extends ActionSupport {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private Emp emp;

    public List<Dept> getDepts() {
        return depts;
    }

    public void setDepts(List<Dept> depts) {
        this.depts = depts;
    }

    private List<Dept> depts;

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    private EmpDao ed = new EmpDaoImpl();
    private DeptDao dd = new DeptDaoImpl();

    @Override
    public String execute() throws Exception {
        if(id != null && !"".equals(id)){
            emp = ed.getEmpById(id);
        }
        depts = dd.findAll();
        return "success";
    }
}

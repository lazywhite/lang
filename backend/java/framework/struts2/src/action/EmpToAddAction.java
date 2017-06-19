package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.DeptDao;
import dao.impl.DeptDaoImpl;
import model.Dept;

import java.util.List;

/**
 * Created by white on 17/6/19.
 */
public class EmpToAddAction extends ActionSupport {
    public List<Dept> getDepts() {
        return depts;
    }

    public void setDepts(List<Dept> depts) {
        this.depts = depts;
    }

    private List<Dept> depts;
    private DeptDao dd = new DeptDaoImpl();
    @Override
    public String execute() throws Exception {
        depts = dd.findAll();
        return "success";
    }
}

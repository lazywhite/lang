package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.EmpDao;
import dao.impl.EmpDaoImpl;
import model.Emp;

/**
 * Created by white on 17/6/19.
 */
public class EmpBatchDelAction extends ActionSupport {
    public String[] getEmpids() {
        return empids;
    }

    public void setEmpids(String[] empids) {
        this.empids = empids;
    }

    private String[] empids;
    private EmpDao ed = new EmpDaoImpl();

    @Override
    public String execute() throws Exception {
        if(empids != null && empids.length > 0){
            ed.batchDel(empids);
        }
        return "success";
    }
}

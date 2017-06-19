package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.EmpDao;
import dao.impl.EmpDaoImpl;

/**
 * Created by white on 17/6/19.
 */
public class EmpDelAction extends ActionSupport {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;
    private EmpDao ed = new EmpDaoImpl();

    @Override
    public String execute() throws Exception {
        if(id != null ){
            ed.del(id);
        }
        return "success";
    }
}

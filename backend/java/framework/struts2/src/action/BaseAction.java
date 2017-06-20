package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.EmpDao;
import dao.impl.EmpDaoImpl;
import model.Emp;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * Created by white on 17/6/19.
 */
public abstract class BaseAction extends ActionSupport implements RequestAware, SessionAware, ApplicationAware{
    protected Map<String, Object> request;
    protected Map<String, Object> session;
    protected Map<String, Object> application;

    @Override
    public abstract String execute() throws Exception;

    @Override
    public void setApplication(Map<String, Object> map) {
        this.application = map;
    }

    @Override
    public void setRequest(Map<String, Object> map) {
        this.request = map;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
}

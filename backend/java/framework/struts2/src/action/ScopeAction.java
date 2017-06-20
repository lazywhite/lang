package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * Created by white on 17/6/19.
 */
public abstract class ScopeAction extends BaseAction {

    @Override
    public String execute() throws Exception{
        return "success";
    }
}


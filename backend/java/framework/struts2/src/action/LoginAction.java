package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import model.User;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by white on 17/6/17.
 */
public class LoginAction extends ActionSupport{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    @Override
    public String execute() throws Exception {
        //类型与servlet的session不同
        Map<String, Object> session = ActionContext.getContext().getSession();
        Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
        ActionContext.getContext().getApplication();

        HttpServletRequest httpRequest = ServletActionContext.getRequest();
        HttpServletResponse httpResponse = ServletActionContext.getResponse();
        HttpSession httpSession = httpRequest.getSession();
        if (name != null) {
            return "success";
        }else{
            return "failed";
        }
    }
}

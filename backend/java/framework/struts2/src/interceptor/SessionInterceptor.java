package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import model.User;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

/**
 * Created by white on 17/6/22.
 */
public class SessionInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        HttpSession session = ServletActionContext.getRequest().getSession();
        User u = (User) session.getAttribute("user");
        if(u == null){
            System.out.println("user not logged in, redirect to login page");
            return "login";
        }
        String result = invocation.invoke();
        return result;
    }

}

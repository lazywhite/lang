package action;

import com.opensymphony.xwork2.ActionSupport;
import model.User;

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
            if (name != null) {
                return "success";
            }else{
                return "failed";
            }
    }
}

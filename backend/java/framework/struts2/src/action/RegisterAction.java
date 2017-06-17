package action;

import com.opensymphony.xwork2.ActionSupport;
import model.User;

import java.util.Arrays;

/**
 * Created by white on 17/6/17.
 */
public class RegisterAction extends ActionSupport{
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user;
    @Override
    public String execute() throws Exception {
            if (user != null) {
                System.out.println(user.getName());
                System.out.println(user.getPassword());
                System.out.println(Arrays.toString(user.getHobby()));
                System.out.println(user.getBirthDay());
                return "success";
            }else{
                return "registerPage";
            }
    }
}

package action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by white on 17/6/17.
 */
public class LoginAction extends ActionSupport{
    private String name;
    private String password;

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

    public void volidate(){
        super.validate();
        if("".equals(this.getName())){
            this.addFieldError("name", "用户名不能为空");
        }
        if("".equals(this.getPassword())){
            this.addFieldError("password", "密码不能为空");
        }

    }

    @Override
    public String execute() throws Exception {
        /*获取map类型的三大对象*/
//        Map<String, Object> session = ActionContext.getContext().getSession();
//        Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
//        Map<String, Object> application = ActionContext.getContext().getApplication();

        /*获取servlet类型的 三大对象 */
//        HttpServletRequest httpRequest = ServletActionContext.getRequest();
//        HttpServletResponse httpResponse = ServletActionContext.getResponse();
//        HttpSession httpSession = httpRequest.getSession();
        if (name != null) {
            return "success";
        }else{
            return "failed";
        }
    }
}

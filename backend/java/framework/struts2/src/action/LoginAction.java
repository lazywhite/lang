package action;

import model.User;

/**
 * Created by white on 17/6/17.
 */
public class LoginAction extends BaseAction{
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
        if ("admin".equals(name) && "1234".equals(password)) {
            User u = new User("admin", "1234");
            session.put("user", u);
            return "success";
        }else{
            return "login";
        }
    }

    @Override
    public void validate() {
        if(name == null || "".equals(name)){
            this.addFieldError("username", "名称不能为空");
            return;
        }
        super.validate();
    }
}

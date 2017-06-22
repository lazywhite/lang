package action;

/**
 * Created by white on 17/6/19.
 */
public class CheckCodeAction extends BaseAction {
    private String code;
    private Boolean flag;
    private String mm = "kadjf";
    public String getCode() {
        return code;
    }

    public String getMm() {
        return mm;
    }

    public void setMm(String mm) {
        this.mm = mm;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String execute() throws Exception{
        String validCode = (String)session.get("validCode");
        if (validCode.equals(code)){
            flag = true;
        }else{
            flag = false;
        }
        return "success";
    }
}


package action;

import model.User;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.util.UUID;

/**
 * Created by white on 17/6/17.
 */
public class RegisterAction extends BaseAction{
    private User user;
    // 下面两个属性必须要一起用, 并且如果File变量名是var, 则文件名的命名是varFileName
    private File portrait;
    private String portraitContentType;
    private String portraitFileName;

    public String getPortraitContentType() {
        return portraitContentType;
    }

    public void setPortraitContentType(String portraitContentType) {
        this.portraitContentType = portraitContentType;
    }


    public File getPortrait() {
        return portrait;
    }

    public void setPortrait(File portrait) {
        this.portrait = portrait;
    }

    public String getPortraitFileName() {
        return portraitFileName;
    }

    public void setPortraitFileName(String portraitFileName) {
        this.portraitFileName = portraitFileName;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String regPage(){
        return SUCCESS;
    }
    @Override
    public String execute() throws Exception {
        String dir = ServletActionContext.getServletContext().getRealPath("upload");
        String prefix=UUID.randomUUID().toString().replace("-", "");
        System.out.println(dir);
        System.out.println(portraitFileName);
        System.out.println(portraitContentType);
        File target = new File(dir, prefix+portraitFileName);
        System.out.println(target.getAbsolutePath());
        System.out.println(portrait.getAbsolutePath());
        FileUtils.copyFile(portrait, target);
        System.out.println(user);
        return SUCCESS;
    }

    //validate()会对所有方法起作用, validateExecute()则只会对execute()方法起作用
    public void validateExecute() {
        String pattern = "^\\w{6,10}$";
        if(user.getName() == null || !user.getName().matches(pattern)){
            this.addFieldError("name", "用户名不合法"); //必须要继承ActionSupport
            return;
        }
        if(portrait == null){
            this.addFieldError("portrait", "头像不能为空");
            return;
        }
        super.validate();
    }
}

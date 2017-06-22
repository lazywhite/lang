package action;

import model.User;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;

/**
 * Created by white on 17/6/17.
 */
public class RegisterAction extends BaseAction{
    private User user;
    // 下面两个属性必须要一起用, 并且如果File变量名是var, 则文件名的命名是varFileName
    private File portrait;
    private String portraitFileName;

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
        System.out.println(dir);
        System.out.println(portraitFileName);
        File target = new File(dir, portraitFileName);
        System.out.println(target.getAbsolutePath());
        System.out.println(portrait.getAbsolutePath());
        FileUtils.copyFile(portrait, target);
        System.out.println(user);
//        System.out.println("---------");
        return SUCCESS;
    }
}

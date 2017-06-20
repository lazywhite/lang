package action;

import com.opensymphony.xwork2.ActionSupport;
import model.User;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by white on 17/6/19.
 */
public class ScopeAction extends BaseAction {
    private String name;
    private Integer age;
    private Date birthDay;
    private List<User> list;
    private String sex;
    private String[] hobby;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    @Override
    public String execute() throws Exception{
        name = "bob";
        age = 20;
        sex = "女";
        birthDay = new Date();
        request.put("requestKey", "1000");
        session.put("sessionKey", "2000");
        application.put("appKey", 300);
        list = new ArrayList<>();
        list.add(new User("bob", "1234"));
        list.add(new User("marry", "1234"));
        list.add(new User("delian", "1234"));
        list.add(new User("hekafj", "1234"));
        hobby = new String[]{"10", "02", "03"};
        return "success";
    }
}


package action;

import model.Interest;
import model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private String selectedOptionValue;

    public List<Interest> getIntList() {
        return intList;
    }

    public void setIntList(List<Interest> intList) {
        this.intList = intList;
    }

    private List<Interest> intList;

    public String getSelectedOptionValue() {
        return selectedOptionValue;
    }

    public void setSelectedOptionValue(String selectedOptionValue) {
        this.selectedOptionValue = selectedOptionValue;
    }

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
        list.add(new User("marry", "123124"));
        list.add(new User("delian", "1231924"));
        list.add(new User("hekafj", "1231234"));
        selectedOptionValue = "1234";
        intList = new ArrayList<>();
        intList.add(new Interest(1, "吃"));
        intList.add(new Interest(2, "喝"));
        intList.add(new Interest(3, "玩"));
        intList.add(new Interest(4, "乐"));
        return "success";
    }
}


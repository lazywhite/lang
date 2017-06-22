package action;

import com.google.gson.Gson;
import model.User;

/**
 * Created by white on 17/6/17.
 */
public class JsonPostAction extends BaseAction{
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String execute() throws Exception {
//        System.out.println(jsonString);
        Gson gson = new Gson();
        User u = gson.fromJson(data, User.class);
        System.out.println(u);
        return SUCCESS;
    }
}

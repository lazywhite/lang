package action;

import com.google.gson.Gson;
import model.User;

/**
 * Created by white on 17/6/17.
 */
public class JsonGetAction extends BaseAction{
    private String jsonString;

    public String getJsonString() {
        return jsonString;
    }

    public void setJsonString(String jsonString) {
        this.jsonString = jsonString;
    }

    @Override
    public String execute() throws Exception {
//        System.out.println(jsonString);
        Gson gson = new Gson();
        User u = gson.fromJson(jsonString, User.class);
        System.out.println(u);
        return SUCCESS;
    }
}

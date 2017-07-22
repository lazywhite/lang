package local.mybatis.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by white on 17/7/17.
 */
public class Park implements Serializable {
    private static final long serialVersionUID = 3435799434508676095L;
    private Integer id;
    private String loc;
    private List<User> users;

    public Park() {
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "Park{" +
                "id=" + id +
                ", loc='" + loc + '\'' +
                '}';
    }
}

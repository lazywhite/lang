package entity;

/**
 * Created by white on 17/6/26.
 * +----------+-------------+------+-----+---------+-------+
 | Field    | Type        | Null | Key | Default | Extra |
 +----------+-------------+------+-----+---------+-------+
 | id       | int(11)     | NO   | PRI | NULL    |       |
 | uid      | int(11)     | YES  |     | NULL    |       |
 | location | varchar(30) | YES  |     | NULL    |       |
 +----------+-------------+------+-----+---------+-------+

 */
public class UserInfo {
    private Integer id;
    private String location;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public UserInfo() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}

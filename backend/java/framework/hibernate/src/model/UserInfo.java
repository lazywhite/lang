package model;

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
    private Integer uid;
    private String location;

    public UserInfo(Integer uid, String location) {
        this.uid = uid;
        this.location = location;
    }

    public UserInfo() {

    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "uid=" + uid +
                ", location='" + location + '\'' +
                '}';
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}

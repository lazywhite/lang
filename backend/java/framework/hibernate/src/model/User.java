package model;

/**
 * Created by white on 17/6/26.
 * +----------+-------------+------+-----+---------+----------------+
 | Field    | Type        | Null | Key | Default | Extra          |
 +----------+-------------+------+-----+---------+----------------+
 | id       | int(11)     | NO   | PRI | NULL    | auto_increment |
 | name     | varchar(30) | YES  |     | NULL    |                |
 | password | varchar(60) | YES  |     | NULL    |                |
 +----------+-------------+------+-----+---------+----------------+

 */

public class User {

    private Integer id;
    private String name;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public User() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setPassword(String password) {
        this.password = password;
    }


}

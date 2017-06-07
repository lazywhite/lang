package dao;

import model.User;
import java.sql.*;
/**
 * Created by white on 17/6/4.
 */

public class UserDao {
    public String driver;
    public String url;
    public String username;
    public String password;
    public UserDao(String driver, String url, String username, String password){
        this.driver = driver;
        this.url = url;
        this.username = username;
        this.password = password;
    }
    public User select(String uname, String pwd){
        try {
            String sql = "select * from user where name=? and password=md5(?) limit 1";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, uname);
            ps.setString(2, pwd);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                return u;
            }
            rs.close();
            ps.close();
            conn.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

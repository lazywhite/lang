package dao;

import model.User;
import java.sql.*;
/**
 * Created by white on 17/6/4.
 */

public class UserDao {
    public static final String driver = "com.mysql.jdbc.Driver";
    public static final String uri = "jdbc:mysql://localhost:3306/test?useSSL=false";
    public static final String uname = "root";
    public static final String pwd = "root";
    public User select(String username, String password){
        try {
            String sql = "select * from user where name=? and password=md5(?) limit 1";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(uri, uname, pwd);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
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

package dao;

import model.User;
import java.sql.*;
/**
 * Created by white on 17/6/4.
 */

public class UserDao extends BaseDao{
    public UserDao(String driver, String url, String username, String password){
        super(driver, url, username, password);
    }
}

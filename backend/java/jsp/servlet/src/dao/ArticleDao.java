package dao;

import model.User;
import java.sql.*;
/**
 * Created by white on 17/6/4.
 */

public class ArticleDao extends BaseDao{
    public ArticleDao(String driver, String url, String username, String password){
        super(driver, url, username, password);
    }
}

package dao;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestListener;
import java.sql.Connection;

/**
 * Created by white on 17/6/4.
 */

public class UserDao extends BaseDao{
    public UserDao(ServletRequest request) {
        super(request);
    }
}

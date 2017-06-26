import dao.impl.UserDaoHbmImpl;
import model.User;
import model.UserInfo;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.function.StandardSQLFunction;

import java.util.List;


/**
 * Created by white on 17/6/26.
 */
public class Main {
    public static void main(String[] args){
        UserDaoHbmImpl ud = new UserDaoHbmImpl();
        List<User> users = ud.getAll();
        for(User u:users){
            System.out.println(u);
        }
    }
}
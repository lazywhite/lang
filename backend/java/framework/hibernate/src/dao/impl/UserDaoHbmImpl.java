package dao.impl;

import dao.UserDao;
import model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

/**
 * Created by white on 17/6/26.
 */
public class UserDaoHbmImpl implements UserDao {
    @Override
    public User select(Integer id) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            return session.get(User.class, id);
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
        return null;
    }

    @Override
    public void update(User u) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.update(u);
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }

    }

    @Override
    public void delete(User u) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.delete(u);
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }

    }

    @Override
    public void create(User u) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.save(u);
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }

    }

    @Override
    public List<User> getAll(){
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Query q = session.createQuery("from User");//from 类名
            return q.list();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
        return null;
    }

}

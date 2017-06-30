package com.local.dao.impl;

import com.local.dao.UserDao;
import com.local.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.local.util.HibernateUtil;

import java.util.List;

/**
 * Created by white on 17/6/26.
 *
 * 增 删 改 必须要添加事务
 */
public class UserDaoHbmImpl implements UserDao {
    @Override
    public User findById(Integer id) {
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
            Transaction tx = session.beginTransaction();
            session.update(u);
            tx.commit();
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
            Transaction transaction = session.beginTransaction();
            session.delete(u);
            transaction.commit();
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
            Transaction transaction = session.beginTransaction();
            session.save(u);
            transaction.commit();
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

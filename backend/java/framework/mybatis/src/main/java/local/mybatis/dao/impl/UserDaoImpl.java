package local.mybatis.dao.impl;
/*
 * UserDaoImpl.java
 * Copyright (C) 2017 white <white@localhost>
 *
 * Distributed under terms of the MIT license.
 */

import local.mybatis.dao.UserDao;
import local.mybatis.entity.User;
import local.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private static SqlSessionFactory sessionFactory = MybatisUtil.getSessionFactory();

    @Override
    public User getUserById(int id) {
        SqlSession session = sessionFactory.openSession();
        try{
            User u = session.selectOne("user.getUserById", id);
            return u;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
        return null;
    }

    @Override
    public List<User> getUsers() {
        SqlSession session = sessionFactory.openSession();
        try{
            List<User> users = session.selectList("user.getUsers");
            return users;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
        return null;
    }

    @Override
    public void createUser(User u){
        SqlSession sqlSession = sessionFactory.openSession();
        try{
            sqlSession.insert("user.createUser", u);
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public void changeUserPassword(User u){
        SqlSession sqlSession = sessionFactory.openSession();
        try{
            sqlSession.update("user.changeUserPassword", u);
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }


    }

    @Override
    public void deleteUser(User u){
        SqlSession sqlSession = sessionFactory.openSession();
        try{
            sqlSession.delete("user.deleteUserById", u);
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }

    }

    @Override
    public User getUserByName(String name) {
        SqlSession sqlSession = sessionFactory.openSession();
        try{
            User u = sqlSession.selectOne("user.getUserByName", name);
            return u;
        }catch (Exception e){
            sqlSession.rollback();
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return null;
    }

    @Override
    public Integer getUsersCount() {
        SqlSession sqlSession = sessionFactory.openSession();
        try{
            int total = sqlSession.selectOne("user.getUsersCount");
            return total;
        }catch (Exception e){
            sqlSession.rollback();
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return null;
    }
}


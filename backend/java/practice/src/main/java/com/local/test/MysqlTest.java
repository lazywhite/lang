package com.local.test;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

public class MysqlTest {
    public static final String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
    public static final String user = "root";
    public static final String password = "root";

    public static void main(String[] args){

        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");//初始化mysql驱动
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        try{
            conn = DriverManager.getConnection(url, user, password); //获得连接
            Statement stmt = conn.createStatement();//生成语句
            String sql = "insert into user(name, password) values('test', 'test')";
            stmt.executeUpdate(sql);

            sql = "select * from user";
            ResultSet rs = stmt.executeQuery(sql);

            int id;
            String name, pwd;
            while(rs.next()){
                id = rs.getInt("id");
                name = rs.getString("name");
                pwd = rs.getString("password");
                System.out.println("info" + id + " : " +  name + " : "  + pwd);
            }

            sql = "delete from user where name='test'";
            stmt.executeUpdate(sql);
            rs.close();
            stmt.close();
            conn.close();

        }catch(SQLException e) {
            e.printStackTrace();
        }

    }
}

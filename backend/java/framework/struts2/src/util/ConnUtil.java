/*
 * ConnUtil.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 */

package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnUtil {
    public static String url;
    public static String dbuser;
    public static String dbpwd;
    public static String driverClass;

    static{
        Properties pro = new Properties();
        try{
            pro.load(ConnUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            url = pro.getProperty("url");
            dbuser = pro.getProperty("user");
            dbpwd = pro.getProperty("password");
            driverClass = pro.getProperty("driverClass");
            Class.forName(driverClass);

        }catch(Exception e){
            e.printStackTrace();
        }
    } 
	public static Connection getConn() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, dbuser, dbpwd);
        }catch(Exception e){
            e.printStackTrace();
        }
        return conn;
	}
}


package dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by white on 17/6/4.
 */

public class BaseDao {
    protected String driver;
    protected String url;
    protected String username;
    protected String password;
    protected Connection conn;

    public BaseDao(String driver, String url, String username, String password){
        this.driver = driver;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConn(){
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
            return conn;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public List<Map<String, Object>> query(String sql, Object... params){
        Connection conn;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = this.getConn();
            ps = conn.prepareStatement(sql);
            for(int i=1;i<=params.length;i++){
                ps.setObject(i, params[i-1]);
            }
            System.out.println(ps);
            rs = ps.executeQuery();
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            ResultSetMetaData rsm = rs.getMetaData();

            while(rs.next()){
                Map<String, Object> map = new HashMap<>();
                for(int i=1;i<=rsm.getColumnCount();i++){
                    map.put(rsm.getColumnName(i), rs.getObject(i));
                }
                list.add(map);
            }
            return list;
        }catch(Exception e) {
            e.printStackTrace();
        }finally{
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public int update(String sql, Object... params){
        Connection conn = null;
        PreparedStatement stat = null;
        try{
            conn = this.getConn();
            stat = conn.prepareStatement(sql);
            for(int i=1;i<=params.length;i++){
                stat.setObject(i, params[i-1]);
            }

            int n = stat.executeUpdate();
            System.out.println(stat);
            return n;
        }catch(SQLException e){
            e.printStackTrace();
            return 0;
        }finally{
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    public static void main(String[] args){

    }
}

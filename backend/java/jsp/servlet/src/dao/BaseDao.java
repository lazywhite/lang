package dao;


import javax.servlet.ServletRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BaseDao {
    private ServletRequest request;
    private Connection conn;
    public BaseDao(ServletRequest request) {
        this.request = request;
        this.conn = (Connection) request.getServletContext().getAttribute("conn");
    }
    public List<Map<String, Object>> query(String sql, Object... params){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
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
        PreparedStatement stat = null;
        try{
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
}

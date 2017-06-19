package dao.impl;

import dao.DeptDao;
import model.Dept;
import util.ConnUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by white on 17/6/19.
 */
public class DeptDaoImpl implements DeptDao {

    @Override
    public List<Dept> findAll() throws SQLException {
        List<Dept> list = new ArrayList<>();
        String sql = "select * from dept";
        Connection conn = ConnUtil.getConn();
        ResultSet rs = null;
        PreparedStatement ps = null;
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while(rs.next()){
            Dept d = new Dept();
            d.setDeptno(rs.getInt(1));
            d.setDeptname(rs.getString(2));
            d.setLoc(rs.getString(3));
            list.add(d);
        }
        rs.close();
        ps.close();
        conn.close();
        return list;
    }
}

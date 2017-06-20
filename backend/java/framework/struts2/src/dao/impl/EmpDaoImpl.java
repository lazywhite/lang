package dao.impl;

import dao.EmpDao;
import model.Dept;
import model.Emp;
import model.EmpWrapper;
import util.ConnUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by white on 17/6/19.
 */
public class EmpDaoImpl implements EmpDao {

    @Override
    public List<EmpWrapper> findEmpByPage(Integer curPage, Integer pageSize, Map<String, Object> map) throws SQLException {
        //Todo: 入职日期的范围搜索
        List<EmpWrapper> list = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        str.append("select empno, ename, job, salary, bonus, sex, hiredate, emp.deptno, deptname from emp ");
        str.append(" left join dept on emp.deptno = dept.deptno where 1=1 ");

        if(map.containsKey("name")){
            str.append(" and ename like '%"+map.get("name")+"%'");
        }
        if(map.containsKey("sex") && !"-1".equals(map.get("sex"))){
            str.append(" and sex = '" + map.get("sex") +"'");
        }
        str.append(" limit "+pageSize * (curPage -1)+", "+pageSize);
        String sql = str.toString();

        System.out.println(sql);

        Connection conn = ConnUtil.getConn();
        ResultSet rs = null;
        PreparedStatement ps = null;
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while(rs.next()){
            EmpWrapper e = new EmpWrapper();
            e.setEmpno(rs.getInt(1));
            e.setEname(rs.getString(2));
            e.setJob(rs.getString(3));
            e.setSalary(rs.getFloat(4));
            e.setBonus(rs.getDouble(5));
            e.setSex(rs.getString(6));
            e.setHiredate(rs.getDate(7));
            Dept dept = new Dept();
            dept.setDeptno(rs.getInt(8));
            e.setDept(dept);
            e.setDeptName(rs.getString(9));
            list.add(e);
        }
        rs.close();
        ps.close();
        conn.close();
        return list;
    }

    @Override
    public Integer countRecords(Map<String, Object> map) throws SQLException {
        Integer totalPage = 0;
        StringBuilder str = new StringBuilder();
        str.append("select count(*) from emp where 1=1 ");
        if(map.containsKey("name")){
            str.append(" and ename like '%"+map.get("name")+"%'");
        }
        if(map.containsKey("sex") && !"-1".equals(map.get("sex"))){
            str.append(" and sex = '" + map.get("sex") +"'");
        }
        String sql = str.toString();
        System.out.println(sql);
        Connection conn = ConnUtil.getConn();
        ResultSet rs = null;
        PreparedStatement ps = null;
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        if(rs.next()){
            totalPage = rs.getInt(1);
        }
        rs.close();
        ps.close();
        conn.close();
        return totalPage;
    }

    @Override
    public void add(Emp emp) throws SQLException {
        String sql = "insert into emp(ename, job, salary, bonus, sex, hiredate, deptno) values(?,?,?,?,?,?,?)";
        System.out.println(sql);
        Connection conn = ConnUtil.getConn();
        ResultSet rs = null;
        PreparedStatement ps = null;
        ps = conn.prepareStatement(sql);
        ps.setString(1, emp.getEname());
        ps.setString(2, emp.getJob());
        ps.setFloat(3, emp.getSalary());
        ps.setDouble(4, emp.getBonus());
        ps.setString(5, emp.getSex());
        ps.setDate(6,  new java.sql.Date(emp.getHiredate().getTime()));
        ps.setInt(7, emp.getDept().getDeptno());
        ps.executeUpdate();
        ps.close();
        conn.close();

    }

    @Override
    public void batchDel(String[] empids) throws SQLException {
        StringBuilder str = new StringBuilder();
        str.append("delete from emp where empno in (");
        str.append(String.join(",", empids));
        str.append(")");
        String sql = str.toString();
        System.out.println(sql);
        Connection conn = ConnUtil.getConn();
        ResultSet rs = null;
        PreparedStatement ps = null;
        ps = conn.prepareStatement(sql);
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    @Override
    public void del(String id) throws SQLException {
        String sql = "delete from emp where empno  = ?";
        System.out.println(sql);
        Connection conn = ConnUtil.getConn();
        ResultSet rs = null;
        PreparedStatement ps = null;
        ps = conn.prepareStatement(sql);
        ps.setString(1, id);
        ps.executeUpdate();
        ps.close();
        conn.close();

    }

    @Override
    public Emp getEmpById(String id) throws SQLException {
        Emp e = new Emp();
        String sql = "select * from emp where empno = ?";
        Connection conn = ConnUtil.getConn();
        ResultSet rs = null;
        PreparedStatement ps = null;
        ps = conn.prepareStatement(sql);
        ps.setString(1, id);
        rs = ps.executeQuery();
        if(rs.next()){
            e.setEmpno(rs.getInt(1));
            e.setEname(rs.getString(2));
            e.setJob(rs.getString(3));
            e.setSalary(rs.getFloat(4));
            e.setBonus(rs.getDouble(5));
            e.setSex(rs.getString(6));
            e.setHiredate(rs.getDate(7));
            Dept dept = new Dept();
            dept.setDeptno(rs.getInt(8));
            e.setDept(dept);
        }
        rs.close();
        ps.close();
        conn.close();
        return e;

    }

    @Override
    public void update(Emp emp) throws SQLException {
        //TODO: null值检测
        String sql = "update emp set ename=?, job=?, salary=?, bonus=?, sex=?, hiredate=?, deptno=?  where empno = ?";
        Connection conn = ConnUtil.getConn();
        ResultSet rs = null;
        PreparedStatement ps = null;
        ps = conn.prepareStatement(sql);
        ps.setString(1, emp.getEname());
        ps.setString(2, emp.getJob());
        ps.setFloat(3, emp.getSalary());
        ps.setDouble(4, emp.getBonus());
        ps.setString(5, emp.getSex());
        ps.setDate(6,  new java.sql.Date(emp.getHiredate().getTime()));
        ps.setInt(7, emp.getDept().getDeptno());
        ps.setInt(8, emp.getEmpno());
        System.out.println(sql);
        ps.executeUpdate();

        ps.close();
        conn.close();


    }
}

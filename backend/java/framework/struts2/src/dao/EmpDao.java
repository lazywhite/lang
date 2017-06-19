package dao;

import model.Emp;
import model.EmpWrapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by white on 17/6/19.
 */
public interface EmpDao {

    List<EmpWrapper> findEmpByPage(Integer curPage, Integer pageSize, Map<String, Object> map) throws SQLException;

    Integer countRecords(Map<String, Object> map) throws SQLException;

    void add(Emp emp) throws SQLException;

    void batchDel(String[] empids) throws SQLException;

    void del(String id) throws SQLException;

    Emp getEmpById(String id) throws SQLException;

    void update(Emp e) throws SQLException;
}

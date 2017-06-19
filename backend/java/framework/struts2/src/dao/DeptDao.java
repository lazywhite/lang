package dao;

import model.Dept;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by white on 17/6/19.
 */
public interface DeptDao {
    List<Dept> findAll() throws SQLException;
}

/*
 * TestHello.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 */
import com.local.test.ConnUtil;
import org.junit.*;
import static junit.framework.Assert.*;
import com.local.test.Main;

import java.sql.*;


public class MainTest {

    @Test
    public void testOracle(){
        Connection conn = ConnUtil.getConn();
        String sql = "{call \"flow\"()}"; // procedure 名称有双引号, 必须要带上
        CallableStatement cs = null;

        try {
            cs = conn.prepareCall(sql);
            cs.execute();
            cs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void testOracle02(){
        Connection conn = ConnUtil.getConn();
        String sql = "{call \"p_cursor\"(?, ?)}";
        CallableStatement cs = null;

        try {
            cs  = conn.prepareCall(sql);
            cs.setInt(1, 10);
            cs.registerOutParameter(2, Types.INTEGER);
            cs.execute();
            System.out.println(cs.getInt(2));

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void testOracle03(){
        Connection conn = ConnUtil.getConn();
        String sql = "select * from emp";
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(sql);
            ResultSet rt = (ResultSet) ps.executeQuery();
            while(rt.next()){
                System.out.println(rt.getInt(1));
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}


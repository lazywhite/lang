package listener;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by white on 17/6/11.
 */
@WebListener
public class AnnoListener implements ServletContextListener {

    /* web服务器启动就创建到数据库的连接, 并放入application对象 */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            ServletContext application = servletContextEvent.getServletContext();
            String driverClass = application.getInitParameter("driverClass");
            String url = application.getInitParameter("url");
            String username = application.getInitParameter("username");
            String password = application.getInitParameter("password");
            Class.forName(driverClass);
            Connection conn = DriverManager.getConnection(url, username, password);
            application.setAttribute("conn", conn);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext applicaiton = servletContextEvent.getServletContext();
        Connection conn = (Connection)applicaiton.getAttribute("conn");
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}

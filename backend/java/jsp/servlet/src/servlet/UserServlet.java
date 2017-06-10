package servlet;

/**
 * Created by white on 17/6/4.
 */
import dao.UserDao;
import model.User;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class UserServlet extends BaseServlet {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletRequest.setCharacterEncoding(stbEncoding); //解决浏览器到服务器的乱码问题
        String uname = servletRequest.getParameter("username");
        String pwd = servletRequest.getParameter("password");
        UserDao ud  = new UserDao(driverClass, url, username, password);
        String sql = "select name, password from user where name=? and password=md5(?)";
        List<Map<String, Object>> list = ud.query(sql, uname, pwd);
        servletResponse.setContentType("text/html; charset=utf-8");
        servletResponse.setCharacterEncoding(btsEncoding);//需要写在getWriter之前, 解决服务器到浏览器乱码问题
        PrintWriter out = servletResponse.getWriter();
        out.write("<!doctype html>");
        if(list.size() != 0){
            servletRequest.setAttribute("username", list.get(0).get("name"));
            //为页面传递额外的参数
            servletRequest.getRequestDispatcher("index.jsp?age=17&hobby=篮球").forward(servletRequest, servletResponse);
        }else{
            servletRequest.setAttribute("message", "用户名或密码错误");
            servletRequest.getRequestDispatcher("login.jsp").forward(servletRequest, servletResponse);
        }
    }

}

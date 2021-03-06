package servlet;

/**
 * Created by white on 17/6/4.
 */
import dao.UserDao;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class UserServlet extends BaseServlet {

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
//        servletRequest.setCharacterEncoding(stbEncoding); //解决浏览器到服务器的乱码问题
        String uname = request.getParameter("username");
        String pwd = request.getParameter("password");
        UserDao ud = new UserDao(request);
        String sql = "select name, password from user where name=? and password=md5(?)";
        List<Map<String, Object>> list = ud.query(sql, uname, pwd);

//        ud.update("update user set password=md5(?) where name=?", "1234", "bob");

//        servletResponse.setContentType("text/html; charset=utf-8");
//        servletResponse.setCharacterEncoding(btsEncoding);//需要写在getWriter之前, 解决服务器到浏览器乱码问题
        PrintWriter out = response.getWriter();
        out.write("<!doctype html>");
        if(list.size() != 0){
            request.setAttribute("username", list.get(0).get("name"));
            //为页面传递额外的参数
            request.getRequestDispatcher("index.jsp?age=17&hobby=篮球").forward(request, response);
        }else{
            request.setAttribute("message", "用户名或密码错误");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

}

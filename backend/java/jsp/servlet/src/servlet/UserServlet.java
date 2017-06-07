package servlet;

/**
 * Created by white on 17/6/4.
 */
import dao.UserDao;
import model.User;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class UserServlet extends BaseServlet {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletRequest.setCharacterEncoding(stbEncoding); //解决浏览器到服务器的乱码问题
        String uname = servletRequest.getParameter("username");
        String pwd = servletRequest.getParameter("password");
        UserDao ud  = new UserDao(driverClass, url, username, password);
        User u = ud.select(uname, pwd);
//        servletResponse.setContentType("text/html; charset=utf-8");
        servletResponse.setCharacterEncoding(btsEncoding);//需要写在getWriter之前, 解决服务器到浏览器乱码问题
        PrintWriter out = servletResponse.getWriter();
        out.write("<!doctype html>");
        if(u != null){
            out.write("<html><head><title></title><meta charset='utf-8' /></head><body><h1>success</h1></body></html>");
        }else{
            out.write("<html><head><title></title><meta charset='utf-8' /></head><body><h1>failed</h1></body></html>");
        }
    }

}

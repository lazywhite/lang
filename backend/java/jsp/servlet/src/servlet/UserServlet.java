package servlet;

/**
 * Created by white on 17/6/4.
 */
import dao.UserDao;
import model.User;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class UserServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("===============================servlet inited=======================");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletRequest.setCharacterEncoding("utf-8"); //解决浏览器到服务器的乱码问题
        String username = servletRequest.getParameter("username");
        String password = servletRequest.getParameter("password");
        UserDao ud  = new UserDao();
        User u = ud.select(username, password);
        servletResponse.setContentType("text/html; charset=utf-8");//需要写在getWriter之前, 解决服务器到浏览器乱码问题
        PrintWriter out = servletResponse.getWriter();
//        servletResponse.setCharacterEncoding("utf-8");
        out.write("<!doctype html>");
        if(u != null){
            out.write("<html><head><title></title><meta charset='utf-8' /></head><body><h1>success</h1></body></html>");
        }else{
            out.write("<html><head><title></title><meta charset='utf-8' /></head><body><h1>failed</h1></body></html>");
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("===============================servlet destroyed=======================");

    }
}

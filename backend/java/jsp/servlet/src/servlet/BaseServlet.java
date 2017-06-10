package servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by white on 17/6/6.
 */
public class BaseServlet implements Servlet {
    /* 浏览器到服务器的编码 */
    protected String btsEncoding;
    /* 服务器到浏览器的编码 */
    protected String stbEncoding;
    protected String driverClass;
    protected String url;
    protected String username;
    protected String password;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("===============================servlet inited=======================");
        btsEncoding = servletConfig.getInitParameter("btsEncoding");
        stbEncoding = servletConfig.getInitParameter("stbEncoding");

        ServletContext sc = servletConfig.getServletContext();
        driverClass = sc.getInitParameter("driverClass");
        url = sc.getInitParameter("url");
        username = sc.getInitParameter("username");
        password = sc.getInitParameter("password");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

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

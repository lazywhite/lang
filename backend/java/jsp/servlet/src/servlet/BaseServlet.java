package servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by white on 17/6/6.
 */
public class BaseServlet implements Servlet {

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

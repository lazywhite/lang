package servlet;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by white on 17/6/6.
 */
public class TestServlet extends BaseServlet{

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        Enumeration<String> en = servletConfig.getInitParameterNames();//获取所有web.xml中此servlet的init-param
        while(en.hasMoreElements()){
            String param = en.nextElement();
            System.out.println(param);
            System.out.println(servletConfig.getInitParameter(param));
        }
        System.out.println("servlet name: " + servletConfig.getServletName());


    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        Enumeration<String> pns = servletRequest.getParameterNames(); //post和get携带的参数都可通过此api获取
        while(pns.hasMoreElements()){
            String pn = pns.nextElement();
            System.out.println(pn);
            System.out.println(servletRequest.getParameter(pn));
        }

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}

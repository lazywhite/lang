package servlet;
import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Created by white on 17/6/6.
 */
@WebServlet(name="anno", value="/anno" , asyncSupported=true ,initParams = {
        @WebInitParam(name= "Site :", value="http://roseindia.net"),
        @WebInitParam(name= "Rose", value= "India")}, loadOnStartup = 0)
public class AnnoServlet implements Servlet {

    public AnnoServlet(){
        System.out.println("test servlet");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println(servletConfig.getInitParameter("Rose"));
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        ServletOutputStream out = servletResponse.getOutputStream();
        out.print("annotation driver web servlet");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
    }
}

package servlet;
import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * Created by white on 17/6/6.
 */
@WebServlet(name="anno", value="/anno" , asyncSupported=true ,initParams = {
        @WebInitParam(name= "Site", value="http://roseindia.net"),
        @WebInitParam(name= "Rose", value= "India")}, loadOnStartup = 0)
public class AnnoServlet extends HttpServlet{

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        ServletConfig config = getServletConfig();//获取servlet config
        ServletOutputStream out = servletResponse.getOutputStream();
        out.println("annotation driver web servlet");
        out.println(config.getInitParameter("Rose"));
        out.println(config.getInitParameter("Site"));
    }
}

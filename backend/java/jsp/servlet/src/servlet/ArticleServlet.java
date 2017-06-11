package servlet;


import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by white on 17/6/10.
 */
public class ArticleServlet extends HttpServlet {
    private String btsEncoding;
    private String stbEncoding;
    public void init() throws ServletException{
        btsEncoding = this.getInitParameter("btsEncoding");
        stbEncoding = this.getInitParameter("stbEncoding");
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        System.out.println("request method: "+  req.getMethod());//如果有get请求， doGet不会被调用
        System.out.println("remote user: " + req.getRemoteUser());
        System.out.println("request uri: " + req.getRequestURI());//返回请求的资源部分
        System.out.println("request url: " + req.getRequestURL().toString());//请求的完全路径
        System.out.println("request query string: " + req.getQueryString());//返回请求的参数部分
        System.out.println("context path: " + req.getContextPath()); //工程名
        System.out.println("path info: " + req.getPathInfo());//requestUri - contextPath
        System.out.println("servlet path: " + req.getServletPath());
        System.out.println("protocol: " + req.getProtocol());
        System.out.println("remote addr: " + req.getRemoteAddr());
        System.out.println("remote host: " + req.getRemoteHost());
        System.out.println("local addr: " + req.getLocalAddr());
        System.out.println("local port: " + req.getLocalPort()) ;
        System.out.println("server name: " + req.getServerName());
        System.out.println("server port: " + req.getServerPort());
        System.out.println("get header: " + req.getHeader("accept"));
        System.out.println("content length: " + req.getContentLength());
        System.out.println("content type: " + req.getContentType());
//        resp.sendRedirect(req.getContextPath() + "/login.do");
        HttpSession hs = req.getSession();
        String username;
        username = (String)hs.getAttribute("username");
        if(username == null) {
            System.out.println("setting username");
            hs.setAttribute("username", "test");
        }else{
            System.out.println(username);
        }
        hs.setMaxInactiveInterval(2 * 60 * 60);// 单位 秒
        System.out.println(req.getRequestedSessionId());

        Cookie c = new Cookie("cookie-key", "cookie-value");
        resp.addCookie(c);
        Cookie[] cs = req.getCookies();
        for(Cookie cc: cs){
            System.out.println(cc.getName() + ":" + cc.getValue());
        }

    }
}

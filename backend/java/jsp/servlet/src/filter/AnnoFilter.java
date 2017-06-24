package filter;

import javax.jws.WebParam;
import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName="annoFilter", urlPatterns = "/async*", initParams = {
        @WebInitParam(name="encoding", value="utf-8"),
        @WebInitParam(name="loginPage", value="/login.jsp")},
        dispatcherTypes = {DispatcherType.ASYNC})
public class AnnoFilter extends  HttpFilter{
    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("entering anno filter");
        chain.doFilter(req, resp);
        System.out.println("leaving anno filter");
    }

}


package servlet;
import executor.TestExecutor;
import listener.AsyncListener;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
    异步servlet跟filter会冲突
 */
@WebServlet(name="async", urlPatterns="/async", asyncSupported = true)
public class AsyncServlet extends HttpServlet{

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print("<title>异步调用示例</title>");
        out.println("进入servlet的时间: " + new java.util.Date() + "<br />");
        out.flush();

        AsyncContext ac = req.startAsync();
        ac.addListener(new AsyncListener());
        ac.setTimeout(30 * 1000);
        ac.start(new TestExecutor(ac));
        out.println("离开servlet时间: " + new java.util.Date() + "<br />");
        out.flush();
    }
}

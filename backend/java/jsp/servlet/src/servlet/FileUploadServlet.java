package servlet;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

/**
 * Created by white on 17/6/6.
 */
@WebServlet(name="upload", value="/upload" , asyncSupported=true ,initParams = {
        @WebInitParam(name= "uploadDir", value="upload")})
@MultipartConfig
public class FileUploadServlet extends HttpServlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        String name = req.getParameter("name"); //获取普通表单值
        Part part = req.getPart("portrait");//获取文件对象
        PrintWriter out = resp.getWriter();
        out.println("文件类型为: " + part.getContentType() + "<br />");
        out.println("文件大小为: " + part.getSize() + "<br />");
        String saveName = UUID.randomUUID().toString().replace("-", "") + part.getName();
        String outputPath = getServletContext().getRealPath("upload");
        System.out.println(part.getSubmittedFileName());
        System.out.println(outputPath);
        System.out.println(saveName);
//        part.write(outputPath);
    }
}

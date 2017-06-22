package action;

import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;

/**
 * Created by white on 17/6/19.
 */
public class DownloadAction extends BaseAction {
    private String filename;
    private InputStream inputStream;

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }


    public InputStream getInputStream() throws UnsupportedEncodingException, FileNotFoundException {
        filename = filename.replace("_", "%");
        filename = URLDecoder.decode(filename, "utf-8");
        System.out.println(filename);
        String realPath = ServletActionContext.getServletContext().getRealPath("upload");
        FileInputStream fs = new FileInputStream(new File(realPath + File.separator + filename));
        HttpServletResponse response = ServletActionContext.getResponse();
//        ServletActionContext.getActionContext().getApplication();
//        ServletActionContext.getRequest()
//        ServletActionContext.getRequest().getSession();
//        response.setHeader("Content-Disposition", "attachment;filename=" + filename);
        return fs;
    }

    public String getFilename() throws UnsupportedEncodingException {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public String execute() throws Exception{
        return "success";
    }
}


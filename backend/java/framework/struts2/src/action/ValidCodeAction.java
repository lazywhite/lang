package action;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import util.ImageUtil;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Map;

/**
 * Created by white on 17/6/19.
 */
public class ValidCodeAction extends BaseAction {
    private InputStream inputStream;

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }


    public InputStream getInputStream() throws UnsupportedEncodingException, FileNotFoundException {
        return inputStream;
    }

    @Override
    public String execute() throws Exception{
        Map<String, BufferedImage> map = ImageUtil.getImage();
        String  code = map.keySet().iterator().next();
        session.put("validCode", code);
        BufferedImage image = map.get(code);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //将验证码图片 压缩成JPEG格式
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(baos);
        encoder.encode(image);
        inputStream = new ByteArrayInputStream(baos.toByteArray());

        return "success";
    }
}


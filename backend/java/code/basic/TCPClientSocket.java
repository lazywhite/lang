/*
 * TCPClientSocket.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 */

import java.net.Socket;
import java.net.UnknownHostException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class TCPClientSocket {
    public static void main(String[] args) throws IOException, UnknownHostException{
        Socket s = new Socket("localhost", 10010);
        try{
            OutputStream os = s.getOutputStream();
            os.write("hello from client".getBytes());

            InputStream is = s.getInputStream();
            byte[] buf = new byte[1024];
            int len = is.read(buf);
            System.out.println(new String(buf, 0, len));

        }catch(Exception e){
            e.printStackTrace();
        }

        finally{
            s.close();
        }


    }
}


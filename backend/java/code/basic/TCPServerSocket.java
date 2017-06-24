package basic;
/*
 * ServerSocket.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 */

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TCPServerSocket {
    public static void main(String[] args)throws IOException{
        ServerSocket ss = new ServerSocket(10010);
        Socket s = ss.accept();

        try{
        String ip = s.getInetAddress().getHostAddress();
        System.out.println("ip=" +ip);

        InputStream in = s.getInputStream();
        byte[] buf = new byte[1024];
        int len = in.read(buf);

        System.out.println(new String(buf, 0, len));

        OutputStream  out = s.getOutputStream();
        String greeting = "hello from server";
        out.write(greeting.getBytes());

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            s.close();
            ss.close();
        }

    }
}


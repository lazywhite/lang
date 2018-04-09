/*
 * Copyright (C) 2018 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 */

import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetSocketAddress;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TCPServerSocket {

    public static void main(String[] args) throws IOException{
        try{

            InetSocketAddress addr = new InetSocketAddress("0.0.0.0", 3433);
            ServerSocket ss = new ServerSocket();
            ss.bind(addr);
            Socket s = ss.accept();

            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            String line;
            while((line = br.readLine()) != null){
                bw.write(line);
                bw.flush();
            }

        }catch(IOException e){
            e.printStackTrace();
        }finally{
            s.close();
            ss.close();
        }


    }
}


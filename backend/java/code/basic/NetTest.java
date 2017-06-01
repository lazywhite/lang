/*
 * NetTest.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 */
import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetTest {
    public static void main(String[] args) throws UnknownHostException{
        try{
            InetAddress i = InetAddress.getByName("localhost");
            System.out.println(i.getHostAddress());

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}


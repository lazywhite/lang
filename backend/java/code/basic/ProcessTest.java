/*
 * ProcessTest.java
 * Copyright (C) 2018 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 */

import java.io.*;

public class ProcessTest {
    public static void main(String[] args) throws IOException{
        try{

            Runtime r = Runtime.getRuntime();
            Process p = r.exec("ls");
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

            //p.pid() 
            //p.isAlive()
            //p.exitValue() return code
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }

    }

}


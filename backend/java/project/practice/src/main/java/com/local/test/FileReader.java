package com.local.test;
import java.io.*;

/**
 * Created by white on 16/8/29.
 */
public class FileReader {
    private BufferedReader reader;
    private FileInputStream fis;
    public FileReader(String fileName) throws FileNotFoundException, IOException{
        FileInputStream fis = new FileInputStream(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        this.reader = reader;
        this.fis = fis;
    }

    public void show(){
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }catch(Exception e){
            e.printStackTrace();

        }finally{
            try {
                reader.close();
                fis.close();
            }catch(Exception e) {
                e.printStackTrace();
            }
        }

    }
}

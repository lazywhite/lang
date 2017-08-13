package tool;

import java.io.*;
public class ExecOSCommand {

    public static void main(String args[]) {
        try {
            Process p = Runtime.getRuntime().exec("ls -al");
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

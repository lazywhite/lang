/*
 * DeSerializeTest.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerializeTest {
    public static final String filePath = "/Users/white/studentobj";
    public static void main(String[] args) throws FileNotFoundException{
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
            Student stu = (Student) ois.readObject();
            System.out.println(stu.toString());

        }catch(Exception e){
            e.printStackTrace();
        }

    }

}


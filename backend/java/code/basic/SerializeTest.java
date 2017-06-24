package basic;
/*
 * SerializeTest.java
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 */
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class SerializeTest {
    public static final String fpath = "/Users/white/studentobj";
    public static void main(String[] args) throws FileNotFoundException{
        Student stu = new Student(10, "张三", 45);
        stu.info = "this field will not get seirialized";
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fpath));
            oos.writeObject(stu);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}


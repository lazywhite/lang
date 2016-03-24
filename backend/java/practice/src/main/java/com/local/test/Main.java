package com.local.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
// TODO: use Iterator interface 
// TODO: CRUD of Datatype



public class Main{
        // Enum 
        public enum weekDay {Mon, Tue, Wed, Thu, Fri, Sat, Sun}
        //overload
        public static int test(int i, String name){
            return name.length() + i;
        }
        public static String test(String name, int i){
            return name + i;
        }
        public static void main(String[] args){
        for (String arg: args){
            System.out.print(arg + ' ');
        }
        Puppy inst = new Puppy("Jerry");
        inst.setAge(10);
        System.out.println("Age of puppy is: " + inst.getAge());
        inst = null;
        System.gc();
        // List
        ArrayList<Object> aList = new ArrayList<Object>();
        aList.add(100);
        aList.add("hello");
        aList.set(1, "world");
        System.out.println(aList.get(0));

        System.out.println(aList.toString());
        //HashSet
        HashSet<Object> mySet = new HashSet<Object>();
        mySet.add("omg");
        mySet.add(100);
        System.out.println("Size of set: " + mySet.size());
        // HashMap
        HashMap<String, Object> myDict = new HashMap<String, Object>();
        myDict.put("k1", "v1");
        myDict.put("k2", 100);
        for(String key: myDict.keySet()){
            System.out.println(key + ":" + myDict.get(key));
        }
        System.out.println(myDict);
        // String
        String testString = "hello world";
        System.out.println(testString);
        // Array
        double[] testArray = {1.0, 20.0, 30.0};
        for(int i=0;i<testArray.length;i++){
            System.out.println(testArray[i]);
        }
        for(double element: testArray){
            System.out.println("element is:" + element);
        }
        //Date 
        Date date = new Date();
        System.out.println(date.toString());
        //File
        String filename = "t.tmp";
        File f = new File(filename);
        // while loop
        int x = 10;
        while (x < 20){
            System.out.println("number of x is: " + x);
            x ++;
            if (x == 15){
                System.out.println("Loop break");
                break;
            }
        }
        // do while loop
        do {
            System.out.println("number of x is: " + x);
            x ++;
        }while (x<25);

        // Exception
        try{
            throw new MyException();
        }
        catch(Exception e)
        {
            System.out.println("Exception is:" + e.toString());
        }

        System.out.println(test(1, "dog"));
        System.out.println(test("dog", 1));
    }
}

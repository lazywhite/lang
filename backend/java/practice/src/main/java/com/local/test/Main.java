package com.local.test;

import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Date;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;
import java.io.*;
import java.util.stream.Collectors;
import java.util.Optional;

import redis.clients.jedis.Jedis;

public class Main{
       // Basic data type
       byte b = 64;
       char c = 'a';
       short s = 300;
       int i = 600;
       long l = 30000;
       boolean bl = true;
       float f = 3.4f;
       double d = 19.149;

        // Enum 
        public enum weekDay {Mon, Tue, Wed, Thu, Fri, Sat, Sun}
        // Method Overload
        public static int test(int i, String name){
            return name.length() + i;
        }
        public static String test(String name, int i){
            return name + i;
        }
        public static void main(String[] args) throws FileNotFoundException, IOException{
        for (String arg: args){
            System.out.print(arg + ' ');
        }
        weekDay day = weekDay.Mon;
        System.out.println(day);
        Puppy inst = new Puppy("Jerry");
        System.out.println("Initial age of puppy is: " + inst.getAge());

        inst.setAge(10);
        System.out.println("Age of puppy is: " + inst.getAge());
        inst = null;
        System.gc();
        // List
        Integer[] aList =  { 10, 20, 30 };
        System.out.println(Arrays.toString(aList));
        ArrayList<Object> bList = new ArrayList<Object>(Arrays.asList("a", 100));
        Character[] cList = { 'h', 'e', 'w'};
        //HashSet
        // initialize method 01
        HashSet<Object> mySet = new HashSet<Object>();
        mySet.add("omg");
        mySet.add(100);
        System.out.println("Size of set: " + mySet.size());
        
        // initialize method 02
        HashSet<String> hs = new HashSet<String>(Arrays.asList("ab", "cd"));
        hs.add("ef");
        System.out.println(hs.toString());

        // HashMap
        HashMap<String, Object> myDict = new HashMap<String, Object>();
        myDict.put("k1", "v1");
        myDict.put("k2", 100);
        // HashMap iteration
        for(String key: myDict.keySet()){
            System.out.println(key + ":" + myDict.get(key));
        }
        for (HashMap.Entry<String, Object> entry : myDict.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                System.out.format("%s: %s%n", key, value.toString());
        }
        // Array iteration
        for(int i=0;i<bList.size();i++){
            System.out.println(bList.get(i));
        }
        for(Object element: bList){
            System.out.println("element is:" + element);
        }
        //Date 
        Date date = new Date();
        System.out.println(date.toString());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));
        

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
        // Switch
        int month = 2;
        String monthString;
        switch (month) {
            case 1: monthString = "January";
                    break;
            case 2: monthString = "February";
                    break;
            case 3: monthString = "March";
                    break;
            default: monthString = "Invalid Month";
                    break;
        }
        System.out.println(monthString);

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
        showThing(cList);

        List<String> strList = new ArrayList<String>();
        strList.add("hello");
        strList.add("world");

        // Iterator
        System.out.println("Using Iterator interface");
        Iterator<String> iter = strList.iterator();
        while(iter.hasNext()){
            Object ele = iter.next();
            System.out.println(ele);
        }

        // Inheriance
        Father father = new Father("Bob");
        Child child  = new Child("June", 13);
        System.out.println(father.name);
        System.out.println(child.name);
        System.out.println(child.age);
        child.say();

        // generic class
        OrderedPair<Integer, Integer> op = new OrderedPair<Integer, Integer>(100, 200);
        System.out.println(op.getKey());
        System.out.println(op.getValue());

        // generic method
        OrderedPair<Integer, String> p1 = new OrderedPair<Integer, String>(10, "bob");
        OrderedPair<Integer, String> p2 = new OrderedPair<Integer, String>(20, "sol");
        System.out.println(Util.compareTo(p1, p2));


        System.out.println(doSum(10, 20, 30));
        System.out.println(doSum(20, 30));

        // File Input
//        FileReader file = new FileReader("/Users/white/access.log");
//        file.show();

//         Label
testLabel:
        for(int y=0;y<=10;y++){
            if (y == 5){
                break testLabel;
            }else{
                System.out.println(y);
            }
            
        }

        // Stream and Method Reference
        System.out.println("Using Stream API");
        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        System.out.println("Filtered List: " + filtered);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("Merged String: " + mergedString);


        // Optional class
        Integer value1 = null;
        Integer value2 = 10;
        Optional<Integer> a = Optional.ofNullable(value1);
        Optional<Integer> b = Optional.of(value2);

        System.out.println(optionalSum(a, b));


        //Redis usage
        Jedis jedis = RedisUtil.getJedis();
//      RedisUtil.testString(jedis);
        RedisUtil.testMap(jedis);
//      RedisUtil.testList(jedis);
//      RedisUtil.testSet(jedis);

        RedisUtil.close(jedis);

        //Mongodb Usage
        MongoUtil mu = new MongoUtil();
        mu.run();

    }
    // Generic method
    public static <T> void showThing(T[] eles){
        for (T ele: eles){
            System.out.println(ele);
        }
    }
    // variable number of parameter method
    public static int doSum(int... args){
        int sum = 0;
        for(int arg: args){
            sum += arg;
        }
        return sum;
    }
    
    public static Integer optionalSum(Optional<Integer> a, Optional<Integer> b){
        System.out.println("Using Optional class Interface");
        System.out.println("First parameter is present: " + a.isPresent());
        System.out.println("Second parameter is present: " + b.isPresent());

        Integer val1 = a.orElse(new Integer(0));
        Integer val2 = b.get();
        return val1 + val2;
    }
}

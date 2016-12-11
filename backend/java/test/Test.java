import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Iterator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
    public enum Color {Red, Blue}
    public static void main(String[] args){
        System.out.println("alkdjl");


        byte b = 64;
        char c = 'a';
        short s = 300;
        long l = 8340958;
        boolean bl = true;
        double d = 734;
        float f = 3.14f;

        String str = "hello";
        String name = "bob";

        System.out.println(test(10, str));
        System.out.println(greetPeople(name));


        Puppy p = new Puppy("Lo", 10);
        System.out.println(p.age);
        p.setAge(100);
        System.out.println(p.age);

        //List CRUD
        List<Integer> li = new ArrayList<Integer>(Arrays.asList(1,3,4,6));
        li.add(100);
        li.add(70);
        System.out.println(li.size());

        List<String> ls = new ArrayList<String>(Arrays.asList("good", "morning"));

        //Iterator interface
        Iterator<Integer> ii = li.iterator();
        while(ii.hasNext()){
            Integer ele = ii.next();
            System.out.println(ele);
        }
        //HashMap
        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("name", "bob");
        System.out.println(hm.toString());
        System.out.println(hm.get("name"));
        System.out.format("contains key: %b\n", hm.containsKey("name"));

        for (String key: hm.keySet()){
            System.out.format("key: %s, value: %s\n", key, hm.get(key));
        }
        //HashSet
        HashSet<String> hs = new HashSet<String>();
        hs.add("bob");
        hs.add("hb");
        System.out.format("hashset size: %s\n", hs.size());
        System.out.format("contains: %b\n", hs.contains("hb"));


        Circle cc = new Circle("circle", 10);
        System.out.println(cc.size());
        //Date
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));
        
        try{
            exceptionTest();
        }catch(Exception e){
            System.out.format("Cached MyException: %s\n", e);
        }

        Color cl = Color.Red;
        String color;
        switch (cl) {
            case Red: color = "red"; //must be Red, not Color.Red
                    break;
            case Blue: color = "blue";
                    break;
            default: color = "none";
                     break;
        }

        System.out.println(color);

        Pair<String, String> pair1 = new Pair<String, String>("name", "bob");
        System.out.format("key: %s, value: %s\n", pair1.getKey(), pair1.getValue());

        Pair<String, Integer> pair = new Pair<String, Integer>("name", 100);
        System.out.format("key: %s, value: %d\n", pair.getKey(), pair.getValue());

    }

    public static String greetPeople(String name){
        return "hello " + name;
    }
    public static int test(int i, String name){
        return name.length() + i;
    }
    public static void exceptionTest() throws MyException, Exception{
        throw new MyException("lkadjfal;fj");
    }
    public static <T> void printList(T[] list){
        for (T item: list){
            System.out.println(item);
        }
    }
}

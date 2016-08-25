import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Test {
    public static void main(String[] argv){
        System.out.println("hello world\n");

        List<String> names1 = new ArrayList<String>();
        names1.add("a");
        names1.add("b");
        names1.add("c");
        names1.add("d");
        names1.add("e");
        names1.add("f");

        List<String> names2 = new ArrayList<String>();
        names2.add("a");
        names2.add("b");
        names2.add("c");
        names2.add("d");
        names2.add("e");
        names2.add("f");

        Test tester = new Test();
        System.out.println("sort using java7");
        tester.sortUsingJava7(names1);
        System.out.println(names1);
        System.out.println("sort using java8");
        tester.sortUsingJava8(names2);
        System.out.println(names2);
        
        // lambda expression
        GreetingService greetingService = message ->
            System.out.println("hello " + message);
        greetingService.sayMessage("world");
        // method reference
        names1.forEach(System.out::println);
        names2.forEach(tester::appendChar);

        // create arrays of Integer, Double and Character
        Integer[] intArray = {1, 2, 3, 4};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        Character[] charArray = {'a', 'b', 'c', 'd'};

        printArray(intArray);
        printArray(doubleArray);
        printArray(charArray);

        
    }
    // generic method
    public static <T> void printArray(T[] inputArray){
        for (T element: inputArray){
            System.out.printf("%s ", element);
        }
            System.out.println();
            
    }

    //sort using java7
    private void sortUsingJava7(List<String> names){
        Collections.sort(names, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return s1.compareTo(s2);
            }
        });
    }

    //sort using java8
    private void sortUsingJava8(List<String> names){
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
    }

    interface GreetingService{
        void sayMessage(String message);
    }
    

    private String appendChar(String str){
        String result = str + "end";
        System.out.println(result);
        return result;
    }
}


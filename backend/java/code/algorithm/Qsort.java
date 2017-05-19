import java.util.ArrayList;  
import java.util.Arrays;  
import java.util.List;  

public class Qsort {  
    public static List<Integer> sort(List<Integer> l) {  
        if (l.size() == 0) return l;  
        Integer pivot = l.get(0);  
        List<Integer> lLower = new ArrayList<Integer>();  
        List<Integer> lHigher = new ArrayList<Integer>();  
        for (Integer e : l) {  
            if (e < pivot) {  
                lLower.add(e);  
            }  
            if (e > pivot) {  
                lHigher.add(e);  
            }  
        }  
        List<Integer> sorted = new ArrayList<Integer>();  
        sorted.addAll(sort(lLower));  
        sorted.add(pivot);  
        sorted.addAll(sort(lHigher));  
        return sorted;  
    }  
  
    public static void main(String[] args) {  
        List<Integer> a = Arrays.asList(3,5,7,4,23,4,56,23,6,1,81);  
        System.out.println(sort(a));  
    }  
}  

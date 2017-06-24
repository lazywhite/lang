import java.util.Arrays;

public class Main{
    public static void main(String[] args){
        Dog d1 = new Dog(50);
        Dog d2 = new Dog(20);
        Dog d3 = new Dog(30);
    
        Dog[] dList = {d1, d2, d3};
        printDogs(dList); 

        System.out.println("After sorting");
        Arrays.sort(dList, new DogSizeComparator());
        printDogs(dList); 
    }
    public static void printDogs(Dog[] dogs){
        for(Dog d :dogs){
            System.out.println(d.size + " ");
        }
    }
}

package basic.Comparator;
import java.util.Comparator;

public class DogSizeComparator implements Comparator<Dog>{
    @Override
    public int compare(Dog d1, Dog d2){
        return d1.size - d2.size;
    }
}

import java.util.Optional;
public class OptionalTest{
    public static void main(String[] args){
        Optional<String> hehe = Optional.ofNullable("hello");
        Optional<String> haha = Optional.ofNullable(null);

        getInfo(hehe); 
        getInfo(haha); 
    }

    public static void getInfo(Optional<String> s){
        if (s.isPresent()){
            System.out.println(s.get());
        }else{
            System.out.println(s.orElseGet(() -> "[none]"));
        }
    }
}

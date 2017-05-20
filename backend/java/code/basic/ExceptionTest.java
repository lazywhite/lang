public class ExceptionTest{
    public static void main(String[] args){
        try{
            throw new MyExp("test");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}

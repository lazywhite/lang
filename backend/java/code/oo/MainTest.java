
public class MainTest {
    public static void main(String[] args){
        Animal a = new Animal();
        System.out.println(a.name);
        System.out.println(a.age);
        Mammal m = new Mammal("good", 10, "Mouse");
        m.move();

        System.out.println(m.getCategory());
        System.out.println(m.toString());

    }
}

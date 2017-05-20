
public class Animal {
    String name;
    int age;

    public Animal(){
    }

    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void move(){
        System.out.println("animal moving");
    }

    @Override
    public String toString(){
        return this.name + " " + this.age + " ";
    }
}

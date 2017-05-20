
/**
 * Created by white on 17/5/20.
 */
public class Mammal extends Animal {
    String category;
    public  Mammal(String name, int age, String category){
        super(name, age);
        this.category = category;
    }

    public String getCategory(){
        return this.category;
    }
    @Override
    public void move(){
        super.move();
        System.out.println("mammal moving");
    }

    @Override
    public String toString(){
        return this.name + " " + this.age + " " + this.category;
    }
}

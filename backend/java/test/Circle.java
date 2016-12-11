public class Circle implements Shape, Photo{
    String name;
    double radius;
    public Circle(String name, double radius){
        this.name = name;
        this.radius = radius;
    }
    @Override
    public double size(){
        return this.radius * this.radius * 3.14;
    }
}

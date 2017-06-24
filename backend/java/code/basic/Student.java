package basic;
import java.io.Serializable;
/**
 * Created by white on 17/5/18.
 * 
 */
public class Student implements Comparable, Serializable{
    private int id;
    private String name;
    private int age;
    public transient String info;

    public Student(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        if(id > 0) {
            this.id = id;
        }
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        if(name instanceof String) {
            this.name = name;
        }
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        if(age > 0){
            this.age = age;
        }
    }
    @Override
    public int compareTo(Object obj){
        Student st = (Student)obj;
        if (this.id > st.id) {
            return 1;
        }else if(this.id == st.id){
            return 0;
        }else{
            return -1;
        }
    }

    @Override
    public String toString(){
        return "Student: " + this.getName()+ " Age: " + this.getAge()+ " id: " + this.getId() + " info: " + this.info;
    }
}

package oo.generic;

/**
 * Created by white on 17/5/19.
 */
public class Person<T> implements InterfaceTest<T> {
    private T name;
    public Person(T name){
        this.setName(name);
    }
    public void setName(T name){
        this.name = name;
    }

    @Override
    public T getName(){
        return this.name;
    }

}

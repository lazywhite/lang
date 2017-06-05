package model;

/**
 * Created by white on 17/6/4.
 */
import java.io.Serializable;

public class User implements  Serializable{
    private Integer id;
    private String name;

    public User(){
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

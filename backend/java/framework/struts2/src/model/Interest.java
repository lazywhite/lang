package model;
import java.io.Serializable;


public class Interest implements Serializable{
    private Integer intId;

    public Interest(Integer intId, String intName) {
        this.intId = intId;
        this.intName = intName;
    }

    public Integer getIntId() {
        return intId;
    }

    public void setIntId(Integer intId) {
        this.intId = intId;
    }

    public String getIntName() {
        return intName;
    }

    public void setIntName(String intName) {
        this.intName = intName;
    }

    private String intName;

}


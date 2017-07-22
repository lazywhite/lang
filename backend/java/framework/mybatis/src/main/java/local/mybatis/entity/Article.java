package local.mybatis.entity;

import java.io.Serializable;

/**
 * Created by white on 17/7/5.
 */
public class Article implements Serializable {


    private static final long  serialVersionUID = 5280688164610107575L;
    private Integer id;
    private String content;

    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}

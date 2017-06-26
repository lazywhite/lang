package dao;

import model.User;

import java.util.List;

/**
 * Created by white on 17/6/26.
 */
public interface UserDao {
    User select(Integer id);
    void update(User u);
    void delete(User u);
    void create(User u);

    List<User> getAll();
}

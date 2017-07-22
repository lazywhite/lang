package local.mybatis.dao;

import local.mybatis.entity.Article;
import local.mybatis.entity.Park;
import local.mybatis.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by white on 17/7/5.
 */
public interface ParkDao {

    Park getParkById(@Param("id") Integer id);
    void addUser(@Param("park") Park park, @Param("user")User user);

}

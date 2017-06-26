import dao.impl.UserDaoHbmImpl;
import entity.User;

import java.util.List;


/**
 * Created by white on 17/6/26.
 */
public class Main {
    public static void main(String[] args){
        UserDaoHbmImpl ud = new UserDaoHbmImpl();
        //查询
        User u1 = ud.findById(11);
        System.out.println(u1);
        //更新
        u1.setName("worrier");
        ud.update(u1);
        //新增
        User u2 = new User("marray", "password") ;
        ud.create(u2);
        System.out.println(u2.getId());
        //删除
        ud.delete(u2);
    }
}

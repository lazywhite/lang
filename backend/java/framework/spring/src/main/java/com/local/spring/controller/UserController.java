package com.local.spring.controller;

import com.local.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by white on 17/7/11.
 */
@Controller  //表示为bean, id为类名首字母小写
@Scope("prototype")
public class UserController {
    @Autowired //默认按照byType注入, 注意多实现类的情况
    private UserService userService;
}

package com.local.spring.controller;

import com.local.spring.entity.User;
import com.local.spring.service.UserService;
import com.local.spring.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.annotation.Scope;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Locale;

/**
 * Created by white on 17/7/11.
 */
@Controller  //表示为bean, id为类名首字母小写
@Scope("prototype")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired //默认按照byType注入, 注意多实现类的情况
    private UserService userService;

    private LocaleContextHolder  localeContextHolder;


    public String findUserById(int id) {
        User u = userService.findUserByID(id);
        return "userInfo";
    }

    public String findUsers(){
        List<User> users = userService.findAllUser();
        return "userList";
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "/user/toAdd";
    }

    @RequestMapping("/add")
    public ModelAndView toAdd(@Validated User u, BindingResult br) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/user/info");
        Locale locale = localeContextHolder.getLocale();
        System.out.println(locale);
        if (br.hasErrors()) {
            String code = br.getAllErrors().get(0).getDefaultMessage(); //{user.name.empty}
            MessageSource ms = (MessageSource) applicationContext.getBean("messageSource");
            System.out.println(ms.getMessage("user.name.empty", null,  locale));
        }
        return mav;
    }
}

package com.local.spring.handler;

import com.local.spring.entity.User;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by white on 17/7/13.
 */
public class TestHandler implements Controller {
    private String hello;
    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }


    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();
        List<User> list = new ArrayList<>();
        list.add(new User("bob", "1234"));
        list.add(new User("marry", "1234"));
        list.add(new User("alice", "1234"));
        mav.addObject("list", list);
        mav.addObject("person");
        mav.addObject("hello", hello);
        mav.setViewName("info");
        return mav;
    }
}

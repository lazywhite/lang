package com.local.spring.controller;

import com.alibaba.fastjson.JSON;
import com.local.spring.entity.Anno;
import com.local.spring.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by white on 17/7/14.
 */
@Controller
@RequestMapping("/anno")  /* 类似struts namespace TODO: no namespace*/
public class AnnoController {

    /* 返回值类型
        1. String
        2. void
        3. ModelAndView

        method 默认支持POST, GET, 写了就只支持一种
     */


    @RequestMapping(value="/list", method=RequestMethod.GET)
    public ModelAndView list(){
        ModelAndView mav = new ModelAndView();
//        md.setViewName("list");
//        ModelAndView mav = new ModelAndView("/anno/list"); //默认forward
//        ModelAndView mav = new ModelAndView("redirect:/anno/list.jsp"); //重定向, 必须写jsp后缀
        List<User> list = new ArrayList<>();
        list.add(new User("bob", "1234"));
        list.add(new User("marry", "1234"));
        list.add(new User("alice", "1234"));
        mav.addObject("list", list);
//        mav.setViewName("redirect:/anno/list.jsp");
        mav.setViewName("/anno/list");
        return mav;
    }

    @RequestMapping("/toAdd")
    public ModelAndView toAdd(){
        ModelAndView  mav = new ModelAndView();
        mav.setViewName("/anno/add4");
        return mav;
    }

    @RequestMapping("/add")
    public String add(Anno anno, @RequestParam("extra") String name){ //@RequestParam仅用在形参与表单中的name不一致情况下
        //将post数据封装成一个对象
        System.out.println(anno.getName());
        System.out.println(anno.getGender());
        System.out.println(Arrays.toString(anno.getInterest()));
        System.out.println(name);
        return "/anno/list.jsp"; //不走视图解析器
//        return "list";  //走视图解析器
        //return "forward:add" //转发
        //return "redirect:add" //重定向
    }

    @RequestMapping("/test")
    public void test(HttpServletRequest request, HttpServletResponse response, int id ) throws ServletException, IOException {
        //id也可以接受参数
        List<User> list = new ArrayList<>();
        list.add(new User("bob", "1234"));
        list.add(new User("marry", "1234"));
        list.add(new User("alice", "1234"));

        String st = JSON.toJSONString(list);
//        request.getRequestDispatcher("/anno/list.jsp").forward(request, response);
        PrintWriter pw = response.getWriter();
        pw.print(st);
    }
    @RequestMapping("/test02")
    public String test02(List<Anno> list){
        for(Anno anno: list){
            System.out.println(anno.getName());
        }
        return "/anno/list";
    }
    @RequestMapping("/test03")
    public String test03(Date birthday){
        System.out.println(birthday); //默认支持  "2016/07/01" 形式的Date
        return "/anno/list";

    }

    @RequestMapping("/test04")
    public String test04(String str, String username){
        System.out.println(str);
        System.out.println(username);
        return "/anno/list";
    }

    @RequestMapping("/json")
    @ResponseBody
    public Anno json(){
        Anno anno = new Anno();
        anno.setBirthday(new Date());
        anno.setGender(1);
        return anno;
    }
}

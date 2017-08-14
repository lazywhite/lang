package com.local.spring.controller;
import com.local.spring.entity.Anno;
import com.local.spring.service.AnnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by white on 17/7/14.
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes(value={"attr1", "locale"})
public class AnnoController {

    @Autowired
    AnnoService annoService;

    @ModelAttribute("share") //在每个方法执行前执行
    public Anno getAnno(){
        Random r = new Random();
        return new Anno("share", "1234" + r.nextInt(100));
    }

    @RequestMapping(value="/list", method=RequestMethod.GET)
    public ModelAndView list(){
        List<Anno> list = annoService.getList();
        ModelAndView mav = new ModelAndView("/anno/list", "list", list);
        return mav;
    }

    @RequestMapping("/form")
    public String form( String attr1){
        return "/anno/form";
    }

    @RequestMapping(value="/view")
    public String view(ModelMap map){
        System.out.println(map.get("attr1"));
        return "/anno/form";
    }
    //日期注入, 调用formatter转换
    @RequestMapping("/test03")
    public ModelAndView test03(@DateTimeFormat(pattern = "yyyy-MM-dd")Date  birthday, @ModelAttribute("extra") String extra){
        ModelAndView mav = new ModelAndView("/anno/info");
        System.out.println(birthday);
        mav.addObject("attr1", "attr1-value");
        return mav;
    }

    @RequestMapping("/i18n")
    public ModelAndView i18n(HttpServletRequest req){
        ModelAndView mav = new ModelAndView("/anno/i18n");
        Locale locale = Locale.US;
        mav.addObject("locale", locale);
        return mav;
    }


    //文件上传
    @ResponseBody
    @RequestMapping("/test06")
    public Map test06(MultipartFile portrait){
        Map<String, Object> map = new HashMap<>();
        map.put("name", portrait.getOriginalFilename());
        return map;
    }

    @RequestMapping("/test07/{id}/")
    public String test07(@PathVariable("id") int id){
        System.out.println(id);
        return "/anno/list";
    }

    //json返回
    @RequestMapping("/json")
    @ResponseBody
    public Anno json(){
        Anno anno = new Anno();
        anno.setBirthday(new Date());
        anno.setGender(1);
        return anno;
    }

    @RequestMapping("/home")
    public String home(){
        return "login";
    }
    @RequestMapping("/login")
    public ModelAndView login(Anno anno){
        ModelAndView mav = new ModelAndView("info");
        mav.addObject("anno", anno);
        return mav;
    }

}

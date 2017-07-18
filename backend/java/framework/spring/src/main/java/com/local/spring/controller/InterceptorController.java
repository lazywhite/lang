package com.local.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by white on 17/7/18.
 */

@Controller
@RequestMapping("/interceptor/")
public class InterceptorController {
    @RequestMapping("/test/")
    public String inter(){
        return "/index";
    }

}

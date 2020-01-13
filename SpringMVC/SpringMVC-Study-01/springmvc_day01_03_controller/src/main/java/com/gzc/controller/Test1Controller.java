package com.gzc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test1Controller {
    @RequestMapping("/t2")
    public String test(Model model){
        model.addAttribute("msg","Test1Controller");
        return "test";
    }
}

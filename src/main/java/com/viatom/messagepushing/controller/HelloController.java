package com.viatom.messagepushing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: HelloController
 * @author: qiujiawei
 * @date: 2020/7/20 10:03
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/test")
    public String Hello(Model model) {
        model.addAttribute("hello","hello world!!!");
        return "hello";
    }
}

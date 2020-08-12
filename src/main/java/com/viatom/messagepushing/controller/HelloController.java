package com.viatom.messagepushing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: HelloController
 * @author: qiujiawei
 * @date: 2020/7/20 10:03
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/test")
    public String hello(Model model) {
        model.addAttribute("hello", "hello world!!!");
        return "hello";
    }


    @GetMapping("/testCH")
    @ResponseBody
    public String testCh() {
        return "你好";
    }

    @GetMapping("testCH/{name}")
    @ResponseBody
    public String testCh(@PathVariable String name) {
        return name;
    }
}

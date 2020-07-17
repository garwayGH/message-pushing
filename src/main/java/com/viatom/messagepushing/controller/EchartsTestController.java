package com.viatom.messagepushing.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class EchartsTestController {

    @GetMapping("/echarts")
    public String testeCharts() {
        return "redirect:/echartstest.html";
    }

    @GetMapping("/pie")
    public String testePie() {
        return "redirect:/pie.html";
    }
}

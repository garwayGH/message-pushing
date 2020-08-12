package com.viatom.messagepushing.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class EchartsTestController {

    @GetMapping("/echarts")
    public String testCharts() {
        return "redirect:/echartstest.html";
    }

    @GetMapping("/pie")
    public String testPie() {
        return "redirect:/pie.html";
    }

    @GetMapping("/testCharts")
    public String charts() {
        return "echartstest";
    }
}

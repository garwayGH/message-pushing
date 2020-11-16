package com.viatom.messagepushing.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: HelloController
 * @author: qiujiawei
 * @date: 2020/7/20 10:03
 */
@Api(tags = "心跳检测")
@Controller
@RequestMapping("/api")
public class HeartBeatController {

    @ApiOperation(value = "推送服务心跳检测",response = String.class)
    @GetMapping("/heartBeat")
    @ResponseBody
    public String heartBeat() {
        return "心跳正常....";
    }
}

package com.viatom.messagepushing.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author qiujiawei
 * @description PushController
 * @date 2020/11/12 10:04
 */
@Api(tags = "后台消息推送")
@Controller
@RequestMapping("/push")
public class PushController {


    @ApiOperation(value = "根据用户id进行推送")
    @ApiImplicitParam(name = "userId",value = "用户id",required = true)
    @PostMapping("/ErOneAnalyzed/{userId}")
    public void pushEr1AnalyzedResult(@PathVariable("userId") int userId) {

    }

}

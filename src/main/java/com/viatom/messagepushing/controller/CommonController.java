package com.viatom.messagepushing.controller;

import com.viatom.messagepushing.common.Result;
import com.viatom.messagepushing.pojo.vo.BaseSearchConditional;
import com.viatom.messagepushing.service.AndroidNotificationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author qiujiawei
 * @description CommonController
 * @date 2020/11/27 11:21
 */
@Api(tags = "通用接口")
@Controller
@RequestMapping("/api")
public class CommonController {

    @Resource
    AndroidNotificationService androidNotificationService;

    @ApiOperation(value = "绑定userId和deviceToken",response = Result.class)
    @PostMapping("/bindDeviceToken")
    public Result<?> bindUserDeviceToken(@RequestBody BaseSearchConditional searchConditional) {
        int n = androidNotificationService.bindUserDeviceToken(searchConditional);

        return n > 0 ? Result.success() : Result.error();

    }
}

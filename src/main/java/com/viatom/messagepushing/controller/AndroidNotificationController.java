package com.viatom.messagepushing.controller;

import com.viatom.messagepushing.common.Result;
import com.viatom.messagepushing.pojo.vo.BaseSearchConditional;
import com.viatom.messagepushing.service.AndroidNotificationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author qiujiawei
 * @description AndroidNotificationController
 * @date 2020/11/18 11:44
 */
@Api(tags = "android端推送接口")
@RequestMapping("/android")
@RestController
public class AndroidNotificationController {

    @Resource
    AndroidNotificationService androidNotificationService;

    @ApiOperation(value = "绑定userId和deviceToken",response = Result.class)
    @PostMapping("/bindDeviceToken")
    public Result<?> bindUserDeviceToken(@RequestBody BaseSearchConditional searchConditional) {
        int n = androidNotificationService.bindUserDeviceToken(searchConditional);

        return n > 0 ? Result.success() : Result.error();

    }
}

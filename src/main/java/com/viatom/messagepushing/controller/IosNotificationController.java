package com.viatom.messagepushing.controller;

import com.viatom.messagepushing.common.Result;
import com.viatom.messagepushing.pojo.IosBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiujiawei
 * @description IosNotificationController
 * @date 2020/8/26 13:59
 */
@Api("ios接口")
@RequestMapping("/ios")
@RestController
public class IosNotificationController {

    @ApiOperation(value = "iosBean",notes = "ios推送")
    @PostMapping("/unicast")
    public Result<?> sendUnicast(IosBean iosBean) {

        return null;
    }
}

package com.viatom.messagepushing.controller;

import com.viatom.messagepushing.common.Result;
import com.viatom.messagepushing.pojo.push.IosBean;
import com.viatom.messagepushing.service.IosNotificationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author qiujiawei
 * @description IosNotificationController
 * @date 2020/8/26 13:59
 */
@Api(tags = "ios端推送接口")
@RequestMapping("/ios")
@RestController
public class IosNotificationController {

    @Resource
    IosNotificationService iosNotificationService;

    @ApiOperation(value = "ios单播推送",response = Result.class)
    @PostMapping("/unicast")
    public Result<?> sendUnicast(@RequestBody IosBean iosBean) {
        return iosNotificationService.sendIosUnicast(iosBean);
    }
}

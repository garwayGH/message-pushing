package com.viatom.messagepushing.controller;

import com.viatom.messagepushing.common.Result;
import com.viatom.messagepushing.pojo.vo.BaseSearchConditional;
import com.viatom.messagepushing.pojo.vo.PushSearchConditional;
import com.viatom.messagepushing.service.AndroidNotificationService;
import com.viatom.messagepushing.service.CommonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author qiujiawei
 * @description CommonController
 * @date 2020/11/27 11:21
 */
@Api(tags = "通用接口")
@Slf4j
@RestController
@RequestMapping("/api")
public class CommonController {

    @Resource
    AndroidNotificationService androidNotificationService;

    @Resource
    CommonService commonService;

    @ApiOperation(value = "绑定userId和deviceToken",response = Result.class)
    @PostMapping("/bindDeviceToken")
    public Result<?> bindUserDeviceToken(@RequestBody BaseSearchConditional searchConditional) {
        int n = androidNotificationService.bindUserDeviceToken(searchConditional);

        return n > 0 ? Result.success() : Result.error();

    }

    @ApiOperation(value = "版本升级推送", response = Result.class)
    @PostMapping("/versionPush")
    public Result<?> versionPush(@RequestBody PushSearchConditional conditional) {
        commonService.versionPush(conditional);
        return Result.success();
    }
}

package com.viatom.messagepushing.controller;

import com.viatom.messagepushing.common.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiujiawei
 * @description IosNotificationController
 * @date 2020/8/26 13:59
 */
@RequestMapping("/ios")
@RestController
public class IosNotificationController {

    @PostMapping("/unicast")
    public Result<?> sendUnicast() {

        return null;
    }
}

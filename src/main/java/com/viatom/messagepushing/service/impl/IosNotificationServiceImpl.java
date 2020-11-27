package com.viatom.messagepushing.service.impl;

import com.viatom.messagepushing.common.Result;
import com.viatom.messagepushing.pojo.push.IosBean;
import com.viatom.messagepushing.service.IosNotificationService;
import com.viatom.messagepushing.umengpush.IosPush;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author qiujiawei
 * @description IosNotificationServiceImpl
 * @date 2020/8/26 14:12
 */
@Service
public class IosNotificationServiceImpl implements IosNotificationService {

    @Resource
    private IosPush iosPush;

    @Override
    public Result<?> sendIosUnicast(IosBean iosBean) {
        iosPush.sendIosUnicast(iosBean);
        return Result.success();
    }
}

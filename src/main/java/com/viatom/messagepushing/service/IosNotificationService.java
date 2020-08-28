package com.viatom.messagepushing.service;

import com.viatom.messagepushing.common.Result;

/**
 * @author qiujiawei
 * @description IosNotificationService
 * @date 2020/8/26 14:08
 */
public interface IosNotificationService {

    /**
     * 单播
     * @return
     */
    Result<?> sendIosUnicast();
}

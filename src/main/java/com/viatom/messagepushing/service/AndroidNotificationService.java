package com.viatom.messagepushing.service;

import com.viatom.messagepushing.pojo.vo.BaseSearchConditional;

/**
 * @author qiujiawei
 * @description AndroidNotificationService
 * @date 2020/11/18 14:10
 */
public interface AndroidNotificationService {

    /**
     * 绑定用户的友盟deviceToken
     * @param searchConditional
     * @return
     */
    int bindUserDeviceToken(BaseSearchConditional searchConditional);
}

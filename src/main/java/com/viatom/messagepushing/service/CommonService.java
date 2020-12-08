package com.viatom.messagepushing.service;

import com.viatom.messagepushing.pojo.vo.PushSearchConditional;

/**
 * @author qiujiawei
 * @description CommonService
 * @date 2020/12/1 10:15
 */
public interface CommonService {

    /**
     * 版本推送
     * @param conditional
     * @return
     */
    void versionPush(PushSearchConditional conditional);
}

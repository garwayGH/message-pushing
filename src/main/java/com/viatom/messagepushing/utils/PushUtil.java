package com.viatom.messagepushing.utils;

import com.viatom.messagepushing.umengpush.AbstractUmengNotification;
import com.viatom.messagepushing.umengpush.push.ios.AbstractIosNotification;

/**
 * @author qiujiawei
 * @description PushUtil
 * @date 2020/11/10 16:25
 */
public class PushUtil {

    /**
     * 根据properties来设置友盟推送的生产/测试模式
     * @param notification
     * @throws Exception
     */
    public static void changeModeByPropertied(AbstractUmengNotification notification) throws Exception{
        GetPropertiesUtil getPropertiesUtil = GetBeanUtil.getBean(GetPropertiesUtil.class);
        if (getPropertiesUtil.getProductMode()) {
            notification.setProductionMode();
        }else {
            notification.setTestMode();
        }
    }


}

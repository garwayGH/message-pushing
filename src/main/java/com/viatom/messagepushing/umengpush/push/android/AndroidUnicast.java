package com.viatom.messagepushing.umengpush.push.android;

import com.viatom.messagepushing.umengpush.vo.constants.Constants;

/**
 * 安卓单播
 * @author qiujiawei
 * @description AndroidUnicast
 * @date 2020/8/24 10:27
 */
public class AndroidUnicast extends AbstractAndroidNotification{

    public AndroidUnicast(String appKey,String appMasterSecret) throws Exception {
        this.setAppMasterSecret(appMasterSecret);
        this.setPredefinedKeyValue(Constants.UmengRootParam.APP_KEY.getFieldName(), appKey);
        this.setPredefinedKeyValue(Constants.UmengRootParam.TYPE.getFieldName(), Constants.CastType.UNICAST.getCastType());
    }

    public void setDeviceToken(String token) throws Exception {
        this.setPredefinedKeyValue(Constants.UmengRootParam.DEVICE_TOKENS.getFieldName(), token);
    }
}

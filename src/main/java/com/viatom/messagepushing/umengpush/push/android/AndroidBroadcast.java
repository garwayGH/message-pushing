package com.viatom.messagepushing.umengpush.push.android;

import com.viatom.messagepushing.umengpush.vo.constants.Constants;

/**
 * Android广播
 * @author qiujiawei
 * @description AndroidBroadcast
 * @date 2020/12/1 10:47
 */
public class AndroidBroadcast extends AbstractAndroidNotification{

    public AndroidBroadcast(String appKey,String appMasterSecret) throws Exception{
        this.setAppMasterSecret(appMasterSecret);
        this.setPredefinedKeyValue(Constants.UmengRootParam.APP_KEY.getFieldName(), appKey);
        this.setPredefinedKeyValue(Constants.UmengRootParam.TYPE.getFieldName(), Constants.CastType.BROADCAST.getCastType());
    }
}

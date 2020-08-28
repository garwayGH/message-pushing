package com.viatom.messagepushing.umengpush.push.ios;

import com.viatom.messagepushing.umengpush.vo.constants.Constants;

/**
 * @author qiujiawei
 * @description IosBroadcast
 * @date 2020/8/24 11:27
 */
public class IosBroadcast extends AbstractIosNotification{

    public IosBroadcast(String appKey,String appMasterSecret) throws Exception {
        this.setAppMasterSecret(appMasterSecret);
        this.setPredefinedKeyValue(Constants.UmengRootParam.APP_KEY.getFieldName(), appKey);
        this.setPredefinedKeyValue(Constants.UmengRootParam.TYPE.getFieldName(), Constants.CastType.BROADCAST.getCastType());
    }

}

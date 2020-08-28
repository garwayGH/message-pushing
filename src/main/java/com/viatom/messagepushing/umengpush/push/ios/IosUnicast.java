package com.viatom.messagepushing.umengpush.push.ios;

import com.viatom.messagepushing.umengpush.vo.constants.Constants;

/**
 * ios单播
 * @author qiujiawei
 * @description IosUnicast
 * @date 2020/8/20 17:06
 */
public class IosUnicast extends AbstractIosNotification {

    public IosUnicast(String appKey,String appMasterSecret) throws Exception {
        this.setAppMasterSecret(appMasterSecret);
        this.setPredefinedKeyValue(Constants.UmengRootParam.APP_KEY.getFieldName(), appKey);
        this.setPredefinedKeyValue(Constants.UmengRootParam.TYPE.getFieldName(), Constants.CastType.UNICAST.getCastType());
    }

    public void setDeviceToken(String token) throws Exception {
        this.setPredefinedKeyValue(Constants.UmengRootParam.DEVICE_TOKENS.getFieldName(), token);
    }

}

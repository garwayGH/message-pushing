package com.viatom.messagepushing.umengpush.push.ios;

import com.viatom.messagepushing.umengpush.vo.constants.Constants;

/**
 * ios组播
 * @author qiujiawei
 * @description IosGroupcast
 * @date 2020/8/24 11:33
 */
public class IosGroupcast extends AbstractIosNotification {

    public IosGroupcast(String appKey,String appMasterSecret) throws Exception {
        this.setAppMasterSecret(appMasterSecret);
        this.setPredefinedKeyValue(Constants.UmengRootParam.APP_KEY.getFieldName(), appKey);
        this.setPredefinedKeyValue(Constants.UmengRootParam.TYPE.getFieldName(), Constants.CastType.GROUP_CAST.getCastType());
    }

    public void setFilter(String filter) throws Exception {
        this.setPredefinedKeyValue(Constants.UmengRootParam.FILTER.getFieldName(), filter);
    }
}

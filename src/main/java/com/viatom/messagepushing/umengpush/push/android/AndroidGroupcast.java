package com.viatom.messagepushing.umengpush.push.android;

import com.viatom.messagepushing.umengpush.vo.Filter;
import com.viatom.messagepushing.umengpush.vo.constants.Constants;

/**
 * @author qiujiawei
 * @description AndroidGroupcast
 * @date 2020/8/31 9:44
 */
public class AndroidGroupcast extends AbstractAndroidNotification{

    public AndroidGroupcast(String appKey,String appMasterSecret) throws Exception {
        this.setAppMasterSecret(appMasterSecret);
        this.setPredefinedKeyValue(Constants.UmengRootParam.APP_KEY.getFieldName(), appKey);
        this.setPredefinedKeyValue(Constants.UmengRootParam.TYPE.getFieldName(), Constants.CastType.GROUP_CAST.getCastType());
    }

    public void setFilter(Filter filter) throws Exception {
        this.setPredefinedKeyValue(Constants.UmengRootParam.FILTER.getFieldName(), filter);
    }
}

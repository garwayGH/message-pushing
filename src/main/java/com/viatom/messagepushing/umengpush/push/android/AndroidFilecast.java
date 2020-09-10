package com.viatom.messagepushing.umengpush.push.android;

import com.viatom.messagepushing.umengpush.vo.constants.Constants;

/**
 * @author qiujiawei
 * @description AndroidFilecast
 * @date 2020/8/31 9:59
 */
public class AndroidFilecast extends AbstractAndroidNotification{

    public AndroidFilecast(String appKey,String appMasterSecret) throws Exception {
        this.setAppMasterSecret(appMasterSecret);
        this.setPredefinedKeyValue(Constants.UmengRootParam.APP_KEY.getFieldName(), appKey);
        this.setPredefinedKeyValue(Constants.UmengRootParam.TYPE.getFieldName(), Constants.CastType.FILE_CAST.getCastType());
    }

    public void setFileId(String fileId) throws Exception {
        this.setPredefinedKeyValue(Constants.UmengRootParam.FILE_ID.getFieldName(), fileId);
    }
}

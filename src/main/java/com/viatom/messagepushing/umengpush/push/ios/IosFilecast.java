package com.viatom.messagepushing.umengpush.push.ios;

import com.viatom.messagepushing.umengpush.vo.constants.Constants;

/**
 * ios文件播
 * @author qiujiawei
 * @description IosFilecast
 * @date 2020/8/24 14:11
 */
public class IosFilecast extends AbstractIosNotification {

    public IosFilecast(String appKey,String appMasterSecret) throws Exception {
        this.setAppMasterSecret(appMasterSecret);
        this.setPredefinedKeyValue(Constants.UmengRootParam.APP_KEY.getFieldName(), appKey);
        this.setPredefinedKeyValue(Constants.UmengRootParam.TYPE.getFieldName(), Constants.CastType.FILE_CAST.getCastType());
    }

    public void setFileId(String fileId) throws Exception {
        this.setPredefinedKeyValue(Constants.UmengRootParam.FILE_ID.getFieldName(), fileId);
    }
}

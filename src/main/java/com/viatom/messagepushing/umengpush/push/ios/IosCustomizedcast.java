package com.viatom.messagepushing.umengpush.push.ios;

import com.viatom.messagepushing.umengpush.vo.constants.Constants;

/**
 * 通过alias进行推送
 * @author qiujiawei
 * @description IosCustomizedcast
 * @date 2020/8/24 14:02
 */
public class IosCustomizedcast extends AbstractIosNotification {

    public IosCustomizedcast(String appKey,String appMasterSecret) throws Exception {
        this.setAppMasterSecret(appMasterSecret);
        this.setPredefinedKeyValue(Constants.UmengRootParam.APP_KEY.getFieldName(), appKey);
        this.setPredefinedKeyValue(Constants.UmengRootParam.TYPE.getFieldName(), Constants.CastType.CUSTOMIZED_CAST.getCastType());
    }

    public void setAlias(String alias,String aliasType) throws Exception {
        this.setPredefinedKeyValue(Constants.UmengRootParam.ALIAS.getFieldName(), alias);
        this.setPredefinedKeyValue(Constants.UmengRootParam.ALIA_TYPE.getFieldName(), aliasType);
    }

    public void setFileId(String fileId,String aliasType) throws Exception {
        this.setPredefinedKeyValue(Constants.UmengRootParam.FILE_ID.getFieldName(), fileId);
        this.setPredefinedKeyValue(Constants.UmengRootParam.ALIA_TYPE.getFieldName(), aliasType);
    }
}

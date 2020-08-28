package com.viatom.messagepushing.umengpush.push.ios;

import com.viatom.messagepushing.umengpush.vo.constants.Constants;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author qiujiawei
 * @description IosListcast
 * @date 2020/8/24 14:25
 */
public class IosListcast extends AbstractIosNotification {

    public IosListcast(String appKey,String appMasterSecret) throws Exception {
        this.setAppMasterSecret(appMasterSecret);
        this.setPredefinedKeyValue(Constants.UmengRootParam.APP_KEY.getFieldName(), appKey);
        this.setPredefinedKeyValue(Constants.UmengRootParam.TYPE.getFieldName(), Constants.CastType.LIST_CAST.getCastType());
    }

    public void setDeviceTokens(List<String> tokens) throws Exception {
        if (!StringUtils.isEmpty(tokens)) {
            String token = String.join(",", tokens);
            this.setPredefinedKeyValue(Constants.UmengRootParam.DEVICE_TOKENS.getFieldName(), token);
        }
    }
}

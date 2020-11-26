package com.viatom.messagepushing.umengpush;

import com.viatom.messagepushing.pojo.IosBean;
import com.viatom.messagepushing.umengpush.push.ios.IosBroadcast;
import com.viatom.messagepushing.umengpush.push.ios.IosCustomizedcast;
import com.viatom.messagepushing.umengpush.push.ios.IosUnicast;
import com.viatom.messagepushing.utils.PushUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author qiujiawei
 * @description IosPushUtil
 * @date 2020/8/20 17:14
 */
@Slf4j
@Component
public class IosPush {

    private final PushClient client = new PushClient();

    private static String appKey;

    private static String appMasterSecret;


//    apiKey:2207987
//    apiSecurity:kYyrBofUws

    @Value("${iosAppKey}")
    public void setAppKey(String appKey) {
        IosPush.appKey = appKey;
    }

    @Value("${iosAppMasterSecret}")
    public void setAppMasterSecret(String appMasterSecret) {
        IosPush.appMasterSecret = appMasterSecret;
    }


    /**
     * ios单播推送
     * 测试device token ：6e7e81c33876f3ada6d9d8c01f96496bcefa7c50c8c1244ec6509726ba50e095
     */
    public void sendIosUnicast(IosBean iosBean) {
        try {
            IosUnicast iosUnicast = new IosUnicast(appKey, appMasterSecret);
            iosUnicast.setDeviceToken(iosBean.getDeviceTokens());
            iosUnicast.setAlert(iosBean.getTitle(), iosBean.getSubtitle(), iosBean.getBody());
            iosUnicast.setBadge(0);
            iosUnicast.setSound("default");
            iosUnicast.setDescription(iosBean.getDescription());
            PushUtil.changeModeByPropertied(iosUnicast);
            client.send(iosUnicast);
        } catch (Exception e) {
            log.error("ios单播推送异常：", e);
        }

    }

    /**
     * ios列播
     * @param iosBean
     */
    public void sendIosListcast(IosBean iosBean) {
        this.sendIosUnicast(iosBean);
    }

    /**
     * ios广播
     * @param iosBean
     */
    public void sendBroadcast(IosBean iosBean) {
        try {

            IosBroadcast iosBroadcast = new IosBroadcast(appKey, appMasterSecret);
            iosBroadcast.setAlert(iosBean.getTitle(),iosBean.getSubtitle(),iosBean.getBody());
            iosBroadcast.setBadge(0);
            iosBroadcast.setSound("default");
            iosBroadcast.setDescription(iosBean.getDescription());
            PushUtil.changeModeByPropertied(iosBroadcast);
            client.send(iosBroadcast);
        } catch (Exception e) {
            log.error("ios广播推送异常：", e);
        }
    }

    /**
     * 别名播
     * @param iosBean
     */
    public void sendCustomizedcast(IosBean iosBean) {
        try {
            IosCustomizedcast iosCustomizedcast = new IosCustomizedcast(appKey, appMasterSecret);
            iosCustomizedcast.setAlert(iosBean.getTitle(), iosBean.getSubtitle(), iosBean.getBody());
            iosCustomizedcast.setBadge(0);
            iosCustomizedcast.setSound("default");
            iosCustomizedcast.setDescription(iosBean.getDescription());
            iosCustomizedcast.setAlias(iosBean.getAlias(), iosBean.getAliasType());
            PushUtil.changeModeByPropertied(iosCustomizedcast);
            client.send(iosCustomizedcast);
        } catch (Exception e) {
            log.error("ios别名播推送异常：", e);
        }
    }


}

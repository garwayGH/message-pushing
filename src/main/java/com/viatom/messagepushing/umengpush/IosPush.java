package com.viatom.messagepushing.umengpush;

import com.viatom.messagepushing.umengpush.push.ios.IosUnicast;
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


    @Value("${iosAppKey}")
    public void setAppKey(String appKey) {
        IosPush.appKey = appKey;
//        log.info("appKey是{}",IosPush.appKey);
    }

    @Value("${iosAppMasterSecret}")
    public void setAppMasterSecret(String appMasterSecret) {
        IosPush.appMasterSecret = appMasterSecret;
//        log.info("appMasterSecret是{}",IosPush.appMasterSecret);
    }


    /**
     * ios单播推送
     * 测试device token ：6e7e81c33876f3ada6d9d8c01f96496bcefa7c50c8c1244ec6509726ba50e095
     */
    public void sendIosUnicast(String deviceToken) {
        try {
            IosUnicast iosUnicast = new IosUnicast(appKey, appMasterSecret);
            iosUnicast.setDeviceToken(deviceToken);
            iosUnicast.setAlert("ios测试", "测试", "测试测试");
            iosUnicast.setBadge(0);
            iosUnicast.setSound("default");
            iosUnicast.setTestMode();
            client.send(iosUnicast);
        } catch (Exception e) {
            log.error("ios单播推送异常：", e);
        }

    }


}

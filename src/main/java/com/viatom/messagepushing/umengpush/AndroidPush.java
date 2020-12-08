package com.viatom.messagepushing.umengpush;

import com.viatom.messagepushing.pojo.push.AndroidBean;
import com.viatom.messagepushing.umengpush.push.android.AndroidBroadcast;
import com.viatom.messagepushing.umengpush.vo.constants.Constants;
import com.viatom.messagepushing.utils.GetBeanUtil;
import com.viatom.messagepushing.utils.GetPropertiesUtil;
import com.viatom.messagepushing.utils.PushUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author qiujiawei
 * @description AndroidPush
 * @date 2020/12/1 10:22
 */
@Slf4j
@Component
public class AndroidPush {

    private final PushClient client = new PushClient();

    private static String appKey;

    private static String appMasterSecret;

    @Value("${androidAppKey}")
    public void setAppKey(String appKey) {
        AndroidPush.appKey = appKey;
    }

    @Value("${androidAppMasterSecret}")
    public void setAppMasterSecret(String appMasterSecret) {
        AndroidPush.appMasterSecret = appMasterSecret;
    }


    /**
     * 广播
     * @param androidBean
     * @return
     */
    public void sendBroadcast(AndroidBean androidBean) {
        try {
            AndroidBroadcast androidBroadcast = new AndroidBroadcast(appKey, appMasterSecret);
            androidBroadcast.setTicker(androidBean.getTicker());
            androidBroadcast.setTitle(androidBean.getTitle());
            androidBroadcast.setText(androidBean.getText());
            androidBroadcast.setDescription(androidBean.getDescription());
            androidBroadcast.goAppAfterOpen();
            androidBroadcast.setDisplayType(Constants.DisplayType.NOTIFICATION);
            PushUtil.changeModeByPropertied(androidBroadcast);

            client.send(androidBroadcast);
        } catch (Exception e) {
            log.error("Android广播推送异常", e);
        }
    }
}

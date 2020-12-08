package com.viatom.messagepushing.service.impl;

import com.viatom.messagepushing.pojo.push.AndroidBean;
import com.viatom.messagepushing.pojo.push.IosBean;
import com.viatom.messagepushing.pojo.vo.PushSearchConditional;
import com.viatom.messagepushing.service.CommonService;
import com.viatom.messagepushing.umengpush.AndroidPush;
import com.viatom.messagepushing.umengpush.IosPush;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author qiujiawei
 * @description CommonServiceImpl
 * @date 2020/12/1 10:16
 */
@Service
public class CommonServiceImpl implements CommonService {

    @Resource
    IosPush iosPush;

    @Resource
    AndroidPush androidPush;

    @Override
    public void versionPush(PushSearchConditional conditional) {
        //判断app类型
        if (conditional.getAppType() == 1) {
            IosBean iosBean = new IosBean();
            iosBean.setTitle(conditional.getTitle());
            iosBean.setSubtitle("");
            iosBean.setBody(conditional.getText());
            iosBean.setDescription("");

            iosPush.sendBroadcast(iosBean);
        } else {
            AndroidBean androidBean = new AndroidBean();
            androidBean.setTicker(conditional.getTicker());
            androidBean.setTitle(conditional.getTitle());
            androidBean.setText(conditional.getText());
            androidBean.setDescription(conditional.getDescription());
            androidPush.sendBroadcast(androidBean);
        }
    }
}

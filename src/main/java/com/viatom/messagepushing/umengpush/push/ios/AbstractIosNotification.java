package com.viatom.messagepushing.umengpush.push.ios;

import com.google.common.collect.Maps;
import com.viatom.messagepushing.umengpush.AbstractUmengNotification;
import com.viatom.messagepushing.umengpush.vo.Policy;
import com.viatom.messagepushing.umengpush.vo.constants.Constants;
import com.viatom.messagepushing.umengpush.vo.ios.Alert;
import com.viatom.messagepushing.umengpush.vo.ios.Aps;
import com.viatom.messagepushing.umengpush.vo.ios.IosPayLoad;
import com.viatom.messagepushing.umengpush.vo.ios.IosPolicy;
import com.viatom.messagepushing.utils.ReflectUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

/**
 * @author qiujiawei
 * @description AbstractIosNotifacation
 * @date 2020/8/20 9:12
 */
@Slf4j
public abstract class AbstractIosNotification extends AbstractUmengNotification {

    /**
     * 设置aps属性
     */
    protected static final HashSet<String> APS_KEYS = new HashSet<>(Arrays.asList("alert","badge", "sound", "contentAvailable"));


    @Override
    public boolean setPredefinedKeyValue(String fieldName, Object value) throws Exception {
        if (ROOT_KEYS.contains(fieldName)) {
            //设置umengRoot的基础属性
            this.setObjectFields(fieldName, this.umengRoot, value);
        } else if (APS_KEYS.contains(fieldName)) {
            //设置payLoad的属性
            IosPayLoad payLoad = getPayLoad();
            Aps aps = getAps(payLoad);

            this.setObjectFields(fieldName, aps, value);

        } else if (POLICY_KEYS.contains(fieldName)) {
            //设置policy的属性
            Policy policy;

            if (null != umengRoot.getPolicy()) {
                policy = umengRoot.getPolicy();
            } else {
                policy = new IosPolicy();
                umengRoot.setPolicy(policy);
            }

            IosPolicy iosPolicy = (IosPolicy) policy;
            this.setObjectFields(fieldName, iosPolicy, value);

        } else {
            if ("payLoad".equals(fieldName) || "aps".equals(fieldName) || "policy".equals(fieldName)) {
                throw new Exception("无需设置自定义对象 " + fieldName + " 属性,只需要设置基础属性。");
            } else {
                throw new Exception("未知属性名：" + fieldName);
            }
        }
        return true;
    }

    private Aps getAps(IosPayLoad iosPayLoad) {
        Aps aps;
        if (null != iosPayLoad.getAps()) {
            aps = iosPayLoad.getAps();
        } else {
            aps = new Aps();
            iosPayLoad.setAps(aps);
        }
        return aps;
    }

    private IosPayLoad getPayLoad() {
        IosPayLoad payLoad;
        if (null != this.umengRoot.getPayLoad()) {
            payLoad = (IosPayLoad)this.umengRoot.getPayLoad();
        } else {
            payLoad = new IosPayLoad();
            this.umengRoot.setPayLoad(payLoad);
        }
        return payLoad;
    }

    /**
     * 设置自定义键值
     * @param fieldName
     * @param value
     * @return
     * @throws Exception
     */
    public void setCustomizedField(String fieldName, String value) throws Exception {
        IosPayLoad payLoad = getPayLoad();
        Map<String,Object> map = Maps.newHashMap();
        map.put(fieldName, value);
        IosPayLoad target = (IosPayLoad) ReflectUtil.getTarget(payLoad, map);
        this.umengRoot.setPayLoad(target);
    }


    /**
     * 设置接口参数alert为字符串类型时的值
     * @param token
     * @throws Exception
     */
    public void setAlert(String token) throws Exception {
        this.setPredefinedKeyValue(Constants.IosParam.ALERT.getFieldName(), token);
    }


    /**
     * 设置接口参数alert为自定义对象类型时的值
     *
     * @param title
     * @param subtitle
     * @param body
     * @throws Exception
     */
    public void setAlert(String title, String subtitle, String body) throws Exception {
        Alert alert = new Alert();
        alert.setTitle(title);
        alert.setSubtitle(subtitle);
        alert.setBody(body);
        this.setPredefinedKeyValue(Constants.IosParam.ALERT.getFieldName(), alert);
    }

    public void setBadge(Integer badge) throws Exception {
        setPredefinedKeyValue(Constants.IosParam.BADGE.getFieldName(), badge);
    }

    public void setSound(String sound) throws Exception {
        setPredefinedKeyValue(Constants.IosParam.SOUND.getFieldName(), sound);
    }

    public void setContentAvailable(Integer contentAvailable) throws Exception {
        setPredefinedKeyValue(Constants.IosParam.CONTENT_AVAILABLE.getFieldName(), contentAvailable);
    }
}

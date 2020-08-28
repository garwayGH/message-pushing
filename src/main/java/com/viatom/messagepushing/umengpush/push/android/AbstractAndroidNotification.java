package com.viatom.messagepushing.umengpush.push.android;

import com.viatom.messagepushing.umengpush.AbstractUmengNotification;
import com.viatom.messagepushing.umengpush.vo.android.AndroidPayLoad;
import com.viatom.messagepushing.umengpush.vo.android.AndroidPolicy;
import com.viatom.messagepushing.umengpush.vo.android.Body;
import com.viatom.messagepushing.umengpush.vo.constants.Constants;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @author qiujiawei
 * @description AbstractAndroidNotification
 * @date 2020/8/21 15:31
 */
@Slf4j
public abstract class AbstractAndroidNotification extends AbstractUmengNotification {

    /**
     *  设置displayType的值
     */
    protected static final HashSet<String> PAYLOAD_KEYS = new HashSet<>(Collections.singletonList("displayType"));
    /**
     * 设置body的属性
     */
    protected static final HashSet<String> BODY_KEYS = new HashSet<>(Arrays.asList("ticker", "title", "text", "builderId", "icon",
                                                                    "largeIcon", "img", "playVibrate", "playLights", "playSound",
                                                                    "sound", "afterOpen", "url", "activity", "custom"));


    @Override
    public boolean setPredefinedKeyValue(String fieldName, Object value) throws Exception {
        if (ROOT_KEYS.contains(fieldName)) {
            this.setObjectFields(fieldName,this.umengRoot, value);
        } else if (PAYLOAD_KEYS.contains(fieldName)) {

            AndroidPayLoad payLoad = getPayLoad();
            this.setObjectFields(fieldName, payLoad, value);

        } else if (BODY_KEYS.contains(fieldName)) {

            AndroidPayLoad payLoad = getPayLoad();
            Body body = getBody(payLoad);

            this.setObjectFields(fieldName, body, value);
        } else if (POLICY_KEYS.contains(fieldName)) {
            AndroidPolicy policy;

            if (null != umengRoot.getPolicy()) {
                policy = (AndroidPolicy)umengRoot.getPolicy();
            }else {
                policy = new AndroidPolicy();
                umengRoot.setPolicy(policy);
            }

            this.setObjectFields(fieldName, policy, value);
        }else {
            if ("payLoad".equals(fieldName) || "aps".equals(fieldName) || "policy".equals(fieldName)) {
                throw new Exception("无需设置自定义对象 " + fieldName + " 属性,只需要设置基础属性。");
            } else {
                throw new Exception("未知属性名：" + fieldName);
            }
        }
        return true;
    }


    /**
     * 设置自定义key-value
     * @param value 自定义key-value map
     * @throws Exception
     */
    public void setExtraField(String key,String value) throws Exception {
        AndroidPayLoad payLoad = getPayLoad();
        Map<String, String> extra;

        if (null != payLoad.getExtra()) {
            extra = payLoad.getExtra();
        }else {
            extra = new HashMap<String, String>(5);
            payLoad.setExtra(extra);
        }
        extra.put(key, value);
    }

    public void setDisplayType(Constants.DisplayType dt) throws Exception {
        setPredefinedKeyValue(Constants.AndroidParam.DISPLAY_TYPE.getFieldName(), dt.getDisplayType());
    }

    /**
     * 通知栏提示文字
     * @param ticker 提示文字
     * @throws Exception
     */
    public void setTicker(String ticker) throws Exception{
        setPredefinedKeyValue(Constants.AndroidParam.TICKER.getFieldName(), ticker);
    }

    /**
     * 通知标题
     * @param title 标题
     * @throws Exception
     */
    public void setTitle(String title) throws Exception {
        setPredefinedKeyValue(Constants.AndroidParam.TITLE.getFieldName(), title);
    }

    /**
     * 通知文字描述
     * @param text 描述
     * @throws Exception
     */
    public void setText(String text) throws Exception {
        setPredefinedKeyValue(Constants.AndroidParam.TEXT.getFieldName(), text);
    }

    /**
     * 用于标识该通知采用的样式。使用该参数时, 必须在SDK里面实现自定义通知栏样式。
     * @param builderId 标识
     * @throws Exception
     */
    public void setBuilderId(Integer builderId) throws Exception {
        setPredefinedKeyValue(Constants.AndroidParam.BUILDER_ID.getFieldName(), builderId);
    }

    /**
     * 状态栏图标ID, R.drawable.[smallIcon],如果没有, 默认使用应用图标。
     * @param icon 图表ID
     * @throws Exception
     */
    public void setIcon(String icon) throws Exception {
        setPredefinedKeyValue(Constants.AndroidParam.ICON.getFieldName(), icon);
    }

    /**
     * 通知栏拉开后左侧图标ID
     * @param largeIcon 左侧图标ID
     * @throws Exception
     */
    public void setLargeIcon(String largeIcon) throws Exception {
        setPredefinedKeyValue(Constants.AndroidParam.LARGE_ICON.getFieldName(), largeIcon);
    }

    /**
     * 通知栏大图标的URL链接。该字段的优先级大于largeIcon。该字段要求以http或者https开头。
     * @param img url
     * @throws Exception
     */
    public void setImg(String img) throws Exception {
        setPredefinedKeyValue(Constants.AndroidParam.IMG.getFieldName(), img);
    }

    /**
     * 收到通知是否震动,默认为"true"
     * @param playVibrate bool
     * @throws Exception
     */
    public void setPlayVibrate(Boolean playVibrate) throws Exception {
        setPredefinedKeyValue(Constants.AndroidParam.PLAY_VIBRATE.getFieldName(), playVibrate.toString());
    }

    /**
     * 收到通知是否闪灯,默认为"true"
     * @param playLights bool
     * @throws Exception
     */
    public void setPlayLights(Boolean playLights) throws Exception {
        setPredefinedKeyValue(Constants.AndroidParam.PLAY_LIGHTS.getFieldName(), playLights.toString());
    }

    /**
     * 收到通知是否发出声音,默认为"true"
     * @param playSound bool
     * @throws Exception
     */
    public void setPlaySound(Boolean playSound) throws Exception {
        setPredefinedKeyValue(Constants.AndroidParam.PLAY_SOUND.getFieldName(), playSound.toString());
    }

    /**
     * 通知声音，R.raw.[sound]. 如果该字段为空，采用SDK默认的声音
     * @param sound 声音
     * @throws Exception
     */
    public void setSound(String sound) throws Exception {
        setPredefinedKeyValue(Constants.AndroidParam.SOUND.getFieldName(), sound);
    }

    public void setPlaySound(String sound) throws Exception {
        setPlaySound(true);
        setSound(sound);
    }

    /**
     * 点击"通知"的后续行为，默认为打开app。原始接口
     * @param action 行为枚举类
     * @throws Exception
     */
    public void setAfterOpenAction(Constants.AfterOpenAction action) throws Exception {
        setPredefinedKeyValue(Constants.AndroidParam.AFTER_OPEN.getFieldName(), action.toString());
    }

    /**
     * 当after_open=go_url时，必填。
     * 通知栏点击后跳转的URL，要求以http或者https开头
     * @param url url
     * @throws Exception
     */
    public void setUrl(String url) throws Exception {
        setPredefinedKeyValue(Constants.AndroidParam.URL.getFieldName(), url);
    }

    /**
     * 当after_open=go_activity时，必填
     * 通知栏点击后打开的Activity
     * @param activity
     * @throws Exception
     */
    public void setActivity(String activity) throws Exception {
        setPredefinedKeyValue(Constants.AndroidParam.ACTIVITY.getFieldName(), activity);
    }

    /**
     * 点击"通知"的后续行为，默认为打开app。
     * @throws Exception
     */
    public void goAppAfterOpen() throws Exception {
        setAfterOpenAction(Constants.AfterOpenAction.go_app);
    }

    public void goUrlAfterOpen(String url) throws Exception {
        setAfterOpenAction(Constants.AfterOpenAction.go_url);
        setUrl(url);
    }
    public void goActivityAfterOpen(String activity) throws Exception {
        setAfterOpenAction(Constants.AfterOpenAction.go_activity);
        setActivity(activity);
    }

    public void goCustomAfterOpen(String custom) throws Exception {
        setAfterOpenAction(Constants.AfterOpenAction.go_custom);
        setCustomField(custom);
    }
    public void goCustomAfterOpen(Map<String,String> custom) throws Exception {
        setAfterOpenAction(Constants.AfterOpenAction.go_custom);
        setCustomField(custom);
    }

    /**
     * 当display_type=message时, 必填
     * 当display_type=notification且
     * after_open=go_custom时，必填
     * 用户自定义内容，可以为字符串或者JSON格式。
     * @param custom
     * @throws Exception
     */
    public void setCustomField(String custom) throws Exception {
        setPredefinedKeyValue(Constants.AndroidParam.CUSTOM.getFieldName(), custom);
    }

    public void setCustomField(Map<String, String> custom) throws Exception {
        setPredefinedKeyValue(Constants.AndroidParam.CUSTOM.getFieldName(), custom);
    }

    private Body getBody(AndroidPayLoad payLoad) {
        Body body;
        if (null != payLoad.getBody()) {
            body = payLoad.getBody();
        }else {
            body = new Body();
            payLoad.setBody(body);
        }
        return body;
    }

    private AndroidPayLoad getPayLoad() {
        AndroidPayLoad payLoad;
        if (null != this.umengRoot.getPayLoad()) {
            payLoad = (AndroidPayLoad)this.umengRoot.getPayLoad();
        } else {
            payLoad = new AndroidPayLoad();
            this.umengRoot.setPayLoad(payLoad);
        }
        return payLoad;
    }




}

package com.viatom.messagepushing.umengpush;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.viatom.messagepushing.umengpush.vo.UmengRoot;
import com.viatom.messagepushing.umengpush.vo.constants.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author qiujiawei
 * @description UmengNotification
 * @date 2020/8/19 11:26
 */
@Slf4j
public abstract class AbstractUmengNotification {


    /**
     * 用于构造整个请求字符串的jackson类
     */
    protected final ObjectMapper rootJson = new ObjectMapper();

    /**
     * json参数对象
     */
    protected final UmengRoot umengRoot = new UmengRoot();

    /**
     * app master secret
     */
    protected String appMasterSecret;

    /**
     * 用于设置json根节点的键
     */
    protected static final HashSet<String> ROOT_KEYS = new HashSet<>(Arrays.asList("appKey", "timestamp", "type", "deviceTokens", "alias", "aliasType", "fileId",
            "filter", "productionMode", "feedback", "description", "thirdpartyId", "miPush", "miActivity", "channelProperties"));

    /**
     * 用于设置json策略节点的键
     */
    protected static final HashSet<String> POLICY_KEYS = new HashSet<>(Arrays.asList("startTime", "expireTime", "maxSendNum","apnsCollapseId"));

    /**
     * 设置请求json的预定义键值，及额外键（安卓）和定制键（IOS）
     * 由子类去实现逻辑
     * @param fieldName 键
     * @param value 值
     * @return
     * @throws Exception
     */
    public abstract boolean setPredefinedKeyValue(String fieldName, Object value) throws Exception;

    public void setAppMasterSecret(String secret) {
        appMasterSecret = secret;
    }

    public String getPostBody() {
        String postJson = "";
        try {
            postJson = this.rootJson.writeValueAsString(this.umengRoot);

        } catch (JsonProcessingException e) {
            log.error("对象转换为json异常：", e);
        }
        return postJson;
    }

    protected final String getAppMasterSecret(){
        return appMasterSecret;
    }

    protected void setProductionMode(Boolean prod) throws Exception {
        setPredefinedKeyValue(Constants.UmengRootParam.PRODUCTION_MODE.getFieldName(), prod.toString());
    }

    /**
     * 正式模式
     * @throws Exception
     */
    public void setProductionMode() throws Exception {
        setProductionMode(true);
    }

    /**
     * 测试模式
     * @throws Exception
     */
    public void setTestMode() throws Exception {
        setProductionMode(false);
    }

    /**
     * 发送消息描述
     * @param description
     * @throws Exception
     */
    public void setDescription(String description) throws Exception {
        setPredefinedKeyValue(Constants.UmengRootParam.DESCRIPTION.getFieldName(), description);
    }

    /**
     * 定时发送时间，若不填写表示立即发送。格式: "YYYY-MM-DD hh:mm:ss"。
     * @param startTime 发送时间
     * @throws Exception
     */
    public void setStartTime(String startTime) throws Exception {
        setPredefinedKeyValue(Constants.PolicyParam.START_TIME.getFieldName(), startTime);
    }

    /**
     * 消息过期时间,格式: "YYYY-MM-DD hh:mm:ss"。
     * @param expireTime 过期时间
     * @throws Exception
     */
    public void setExpireTime(String expireTime) throws Exception {
        setPredefinedKeyValue(Constants.PolicyParam.EXPIRE_TIME.getFieldName(), expireTime);
    }

    /**
     * 发送限速，每秒发送的最大条数。
     * @param num 条数
     * @throws Exception
     */
    public void setMaxSendNum(Integer num) throws Exception {
        setPredefinedKeyValue(Constants.PolicyParam.MAX_SEND_NUM.getFieldName(), num);
    }

    /**
     * 厂商弹窗activity
     * @param activity 厂商
     * @throws Exception
     */
    public void setChannelActivity(String activity) throws Exception{
        setPredefinedKeyValue(Constants.UmengRootParam.MI_PUSH.getFieldName(), "true");
        setPredefinedKeyValue(Constants.UmengRootParam.MI_ACTIVITY.getFieldName(),activity );
    }

    /**
     * 厂商属性配置
     * @param channelId id
     * @throws Exception
     */
    public void setChannelProperties(String channelName, String channelId) throws Exception {
        Map<String, String> channelProperties;

        if (null != this.umengRoot.getChannelProperties()) {
            channelProperties = this.umengRoot.getChannelProperties();
        } else {
            channelProperties = new HashMap<>(1);
            this.umengRoot.setChannelProperties(channelProperties);
        }

        channelProperties.put(channelName, channelId);
    }

    /**
     * 通过反射设置接口参数类的属性
     * @param fieldName 属性名
     * @param obj 需要属性注入的对象
     * @param value 属性值
     * @param <T>
     */
    @SuppressWarnings("unchecked")
    protected <T> void setObjectFields(String fieldName, T obj, Object value) {
        try {
            Class<? extends T> clazz = (Class<T>) obj.getClass();
            //首字母大写
            String capitalize = StringUtils.capitalize(fieldName);
            //根据字段名获取对象Field Class
            Field declaredField = clazz.getDeclaredField(fieldName);
            //获取属性类型
            Class<?> type = declaredField.getType();
            //调用set方法属性注入
            Method method = clazz.getMethod("set" + capitalize, type);
            method.setAccessible(true);
            if (value != null) {
                method.invoke(obj, this.cast(type,value));
            }else {
                method.invoke(obj, null);
            }

        } catch (NoSuchFieldException e) {
            log.error("获取class属性异常：", e);
        } catch (NoSuchMethodException e) {
            log.error("获取class方法异常：", e);
        } catch (IllegalAccessException e) {
            log.error("非法访问class属性或方法：", e);
        } catch (InvocationTargetException e) {
            log.error("调用目标异常：",e);
        }
    }

    /**
     * 类型判断和转换
     * @param clazz
     * @param obj
     * @param <T>
     * @return
     */
    protected <T> T cast(Class<T> clazz, Object obj) {
        if (clazz.isInstance(obj)) {
            return clazz.cast(obj);
        }
        return null;
    }
}

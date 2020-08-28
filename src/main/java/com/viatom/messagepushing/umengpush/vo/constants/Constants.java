package com.viatom.messagepushing.umengpush.vo.constants;

/**
 *
 * @author qiujiawei
 * @date 2020/08/21
 */
public class Constants {

    /**
     * 基础根节点
     * 统一管理接口请求参数在转换成json前用到的fieldName值
     */
    public enum UmengRootParam {
        /**
         *
         */
        APP_KEY("appKey"),
        TIMESTAMP("timestamp"),
        TYPE("type"),
        DEVICE_TOKENS("deviceTokens"),
        ALIA_TYPE("aliaType"),
        ALIAS("alias"),
        FILE_ID("fileId"),
        FILTER("filter"),
        PAY_LOAD("payLoad"),
        POLICY("policy"),
        PRODUCTION_MODE("productionMode"),
        DESCRIPTION("description"),
        MI_PUSH("miPush"),
        MI_ACTIVITY("miActivity"),
        CHANNEL_PROPERTIES("channelProperties");



        UmengRootParam(String fieldName) {
            this.fieldName = fieldName;
        }

        /**
         * 字段名
         */
        private final String fieldName;

        public String getFieldName() {
            return this.fieldName;
        }
    }

    /**
     * IOS
     * 统一管理接口请求参数在转换成json前用到的fieldName值
     */
    public enum IosParam {
        /**
         *
         */
        APS("aps"),
        KEY1("key1"),
        ALERT("alert"),
        BADGE("badge"),
        SOUND("sound"),
        CONTENT_AVAILABLE("contentAvailable"),
        CATEGORY("category"),
        TITLE("title"),
        SUBTITLE("subtitle"),
        BODY("body");


        IosParam(String fieldName) {
            this.fieldName = fieldName;
        }

        private final String fieldName;

        public String getFieldName() {
            return this.fieldName;
        }
    }

    /**
     * Android
     * 统一管理接口请求参数在转换成json前用到的fieldName值
     */
    public enum AndroidParam {
        /**
         *
         */
        DISPLAY_TYPE("displayType"),
        BODY("body"),
        EXTRA("extra"),
        TICKER("ticker"),
        TITLE("title"),
        TEXT("text"),
        ICON("icon"),
        LARGE_ICON("largeIcon"),
        IMG("img"),
        SOUND("sound"),
        BUILDER_ID("builderId"),
        PLAY_VIBRATE("playVibrate"),
        PLAY_LIGHTS("playLights"),
        PLAY_SOUND("playSound"),
        AFTER_OPEN("afterOpen"),
        URL("url"),
        ACTIVITY("activity"),
        CUSTOM("custom");

        AndroidParam(String fieldName) {
            this.fieldName = fieldName;
        }

        private final String fieldName;

        public String getFieldName() {
            return this.fieldName;
        }
    }


    /**
     *
     */
    public enum PolicyParam {
        /**
         *
         */
        START_TIME("startTime"),
        EXPIRE_TIME("expireTime"),
        OUT_BIZ_NO("outBizNo"),
        /**
         * 这个参数安卓才会用到
         */
        MAX_SEND_NUM("maxSendNum"),
        /**
         * 这个参数IOS才会用到
         */
        APNS_COLLAPSE_ID("apnsCollapseId"),;

        PolicyParam(String fieldName) {
            this.fieldName = fieldName;
        }

        private final String fieldName;

        public String getFieldName() {
            return this.fieldName;
        }
    }

    /**
     * 消息发送类型
     */
    public enum CastType {
        /**
         * 单播
         */
        UNICAST("unicast"),
        /**
         * 列播
         */
        LIST_CAST("listcast"),
        /**
         * 文件播
         */
        FILE_CAST("filecast"),
        /**
         * 广播
         */
        BROADCAST("broadcast"),
        /**
         * 组播
         */
        GROUP_CAST("groupcast"),
        /**
         * 通过alias进行推送
         */
        CUSTOMIZED_CAST("customizedcast");

        CastType(String castType) {
            this.castType = castType;
        }

        private final String castType;

        public String getCastType() {
            return this.castType;
        }
    }

    /**
     * 安卓消息类型
     */
    public enum DisplayType{
        /**
         * 通知:消息送达到用户设备后，由友盟SDK接管处理并在通知栏上显示通知内容。
         */
        NOTIFICATION("notification"),
        /**
         * 消息:消息送达到用户设备后，消息内容透传给应用自身进行解析处理。
         */
        MESSAGE("message");

        DisplayType(String displayType){
            this.displayType = displayType;
        }

        private final String displayType;

        public String getDisplayType(){
            return this.displayType;
        }
    }

    /**
     * 点击"通知"的后续行为，默认为打开app。
     */
    public enum AfterOpenAction{
        /**
         *打开应用
         */
        go_app,
        /**
         * 跳转到URL
         */
        go_url,
        /**
         * 打开特定的activity
         */
        go_activity,
        /**
         * 用户自定义内容。
         */
        go_custom
    }


    /**
     * 友盟过滤条件开放字段
     */
    public enum FilterField {
        /**
         * 应用版本
         */
        APP_VERSION("app_version"),
        /**
         * 渠道
         */
        CHANNEL("channel"),
        /**
         * 设备型号
         */
        DEVICE_MODEL("device_model"),
        /**
         * 省
         */
        PROVINCE("province"),
        /**
         * 用户标签
         */
        TAG("tag"),
        /**
         * 国家和地区
         */
        COUNTRY("country"),
        /**
         * 语言
         */
        LANGUAGE("language"),
        /**
         * 一段时间内活跃
         */
        LAUNCH_FROM("launch_from"),
        /**
         * 一段时间内不活跃
         */
        NOT_LAUNCH_FROM("not_launch_from");

        FilterField(String field) {
            this.field = field;
        }

        private final String field;

        public String getField() {
            return this.field;
        }

    }

}

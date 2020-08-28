package com.viatom.messagepushing.umengpush.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

/**
 * 友盟接口基础参数封装类
 * @author qiujiawei
 * @description UmengBase
 * @date 2020/8/19 16:21
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UmengRoot {

    /**
     * 应用唯一标识 必填
     */
    @JsonProperty("appkey")
    private String appKey;

    /**
     * 时间戳 必填
     */
    private String timestamp;

    /**
     * 发送消息类型，其值可为：
     *          unicast-单播
     *          listcast-列播，要求不超过500个device_token
     *          filecast-文件播，多个device_token可通过文件形式批量发送
     *          broadcast-广播
     *          groupcast-组播，按照filter筛选用户群, 请参照filter参数
     *          customizedcast，通过alias进行推送，包括以下两种case:
     *              - alias: 对单个或者多个alias进行推送
     *              - file_id: 将alias存放到文件后，根据file_id来推送
     *
     */
    private String type;

    /**
     * 当type=unicast时, 必填, 表示指定的单个设备
     * 当type=listcast时, 必填, 要求不超过500个, 以英文逗号分隔
     */
    @JsonProperty("device_tokens")
    private String deviceTokens;

    /**
     * 当type=customizedcast时, 必填
     * alias的类型, alias_type可由开发者自定义, 开发者在SDK中
     * 调用setAlias(alias, alias_type)时所设置的alias_type
     */
    @JsonProperty("alias_type")
    private String aliaType;

    /**
     * 当type=customizedcast时, 选填(此参数和file_id二选一)
     * 开发者填写自己的alias, 要求不超过500个alias, 多个alias以英文逗号间隔
     * 在SDK中调用setAlias(alias, alias_type)时所设置的alias
     */
    private String alias;

    /**
     * 当type=filecast时，必填，file内容为多条device_token，以回车符分割
     * 当type=customizedcast时，选填(此参数和alias二选一)
     * file内容为多条alias，以回车符分隔。注意同一个文件内的alias所对应
     * 的alias_type必须和接口参数alias_type一致。
     * 使用文件播需要先调用文件上传接口获取file_id，参照"文件上传"
     */
    @JsonProperty("file_id")
    private String fileId;

    /**
     * 当type=groupcast时，必填，用户筛选条件，如用户标签、渠道等
     * filter的内容长度最大为3000B）
     */
    private Filter filter;

    /**
     * 必填，具体消息内容(iOS最大为2012B)
     */
    @JsonProperty("payload")
    private PayLoad payLoad;

    /**
     * 可选，发送策略
     */
    private Policy policy;

    /**
     * 可选，正式/测试模式。默认为true
     * 测试模式只对“广播”、“组播”类消息生效，其他类型的消息任务（如“文件播”）不会走测试模式
     * 测试模式只会将消息发给测试设备。测试设备需要到web上添加。
     */
    @JsonProperty("production_mode")
    private String productionMode;

    /**
     * 可选，发送消息描述，建议填写。
     */
    private String description;

    /**
     * 可选，默认为false。当为true时，表示MIUI、EMUI、Flyme系统设备离线转为系统下发
     */
    @JsonProperty("mipush")
    private String miPush;

    /**
     * 可选，mipush值为true时生效，表示走系统通道时打开指定页面acitivity的完整包路径。
     */
    @JsonProperty("mi_activity")
    private String miActivity;

    /**
     * 可选，厂商通道相关的特殊配置
     */
    @JsonProperty("channel_properties")
    private Map<String,String> channelProperties;

}

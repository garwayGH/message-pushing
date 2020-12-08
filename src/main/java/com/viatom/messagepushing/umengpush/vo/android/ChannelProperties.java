package com.viatom.messagepushing.umengpush.vo.android;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 可选，厂商通道相关的特殊配置
 * @author qiujiawei
 * @description ChannelProperties
 * @date 2020/8/20 9:32
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChannelProperties {


    /**
     * 小米channel_id，具体使用及限制请参考小米推送文档
     * https://dev.mi.com/console/doc/detail?pId=2086
     */
    @JsonProperty("xiaomi_channel_id")
    private String xiaomiChannelId;

    /**
     * vivo消息分类：0 运营消息，1 系统消息， 需要到vivo申请，具体使用及限制参考
     * [vivo消息推送分类功能说明]
     * (https://dev.vivo.com.cn/documentCenter/doc/359 "vivo消息推送分类功能说明")
     */
    @JsonProperty("vivo_classification")
    private String vivoClassification;

    /**
     * android8以上推送消息需要新建通道，否则消息无法触达用户。
     * push sdk 6.0.5及以上创建了默认的通道:upush_default，
     * 消息提交厂商通道时默认添加该通道。如果要自定义通道名称或使用私信，
     * 请自行创建通道，推送消息时携带该参数
     * 具体可参考 [oppo通知通道适配] https://open.oppomobile.com/wiki/doc#id=10289
     */
    @JsonProperty("oppo_channel_id")
    private String oppoChannelId;
}

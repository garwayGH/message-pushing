package com.viatom.messagepushing.umengpush.vo.ios;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.viatom.messagepushing.umengpush.vo.Policy;
import lombok.Data;

import java.util.Date;

/**
 * 发送策略
 * @author qiujiawei
 * @description Policy
 * @date 2020/8/19 17:30
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IosPolicy implements Policy {

    /**
     * 可选，定时发送时间，若不填写表示立即发送。
     * 定时发送时间不能小于当前时间
     * 格式: "yyyy-MM-dd HH:mm:ss"。
     * 注意，start_time只对任务生效。
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("start_time")
    private Date startTime;

    /**
     * 可选，消息过期时间，其值不可小于发送时间或者
     * start_time(如果填写了的话),
     * 如果不填写此参数，默认为3天后过期。格式同start_time
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("expire_time")
    private Date expireTime;

    /**
     * 可选，消息发送接口对任务类消息的幂等性保证。
     * 强烈建议开发者在发送任务类消息时填写这个字段，友盟服务端会根据这个字段对消息做去重避免重复发送。
     * 同一个appkey下面的多个消息会根据out_biz_no去重，不同发送任务的out_biz_no需要保证不同，否则会出现后发消息被去重过滤的情况。
     * 注意，out_biz_no只对任务类消息有效。
     */
    @JsonProperty("out_biz_no")
    private String outBizNo;

    /**
     * 可选，多条带有相同apns_collapse_id的消息，iOS设备仅展示
     * 最新的一条，字段长度不得超过64bytes
     */
    @JsonProperty("apns_collapse_id")
    private String apnsCollapseId;
}

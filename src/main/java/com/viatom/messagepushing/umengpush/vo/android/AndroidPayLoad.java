package com.viatom.messagepushing.umengpush.vo.android;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.viatom.messagepushing.umengpush.vo.PayLoad;
import lombok.Data;

import java.util.Map;

/**
 * 具体消息内容(Android最大为1840B)
 * @author qiujiawei
 * @description AndroidPayLoad
 * @date 2020/8/19 17:47
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AndroidPayLoad implements PayLoad {

    /**
     * 必填，消息类型: notification(通知)、message(消息)
     */
    @JsonProperty("display_type")
    private String displayType;

    /**
     * 必填，消息体。
     */
    private Body body;

    /**
     * 可选，JSON格式，用户自定义key-value。
     * 只对"通知"(display_type=notification)生效。
     * 可以配合通知到达后，打开App/URL/Activity使用。
     */
    private Map<String,String> extra;
}

package com.viatom.messagepushing.umengpush.vo.ios;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * APNs定义
 * @author qiujiawei
 * @description Aps
 * @date 2020/8/19 17:03
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Aps {

    /**
     * 当content-available=1时(静默推送)，可选; 否则必填。
     * 可为自定义对象类型和字符串类型
     * 对象类型属性详见 Alert类
     */
    @JsonProperty("alert")
    private Object alert;


    private Integer badge;

    private String sound;
    /**
     * 代表静默推送
     */
    @JsonProperty("content-available")
    private Integer contentAvailable;

    /**
     * 注意: ios8才支持该字段。
     */
    private String category;
}

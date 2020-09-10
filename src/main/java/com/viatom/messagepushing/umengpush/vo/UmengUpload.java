package com.viatom.messagepushing.umengpush.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 友盟文件上传
 * @author qiujiawei
 * @description UmengUpload
 * @date 2020/8/28 15:05
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UmengUpload {

    @JsonProperty("appkey")
    private String appKey;

    private String timestamp;

    private String content;
}

package com.viatom.messagepushing.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author qiujiawei
 * @description IosBean
 * @date 2020/9/2 14:51
 */
@Data
@ApiModel("ios推送")
public class IosBean {

    @ApiModelProperty(value = "设备tokens", notes = "设备tokens", dataType = "String", required = true)
    private String deviceTokens;

    @ApiModelProperty(value = "标题", notes = "标题", dataType = "String", required = true)
    private String title;

    @ApiModelProperty(value = "副标题", notes = "副标题", dataType = "String", required = true)
    private String subtitle;

    @ApiModelProperty(value = "消息体", notes = "消息体", dataType = "String", required = true)
    private String body;

    @ApiModelProperty(value = "消息描述", notes = "消息描述", dataType = "String", required = false)
    private String description;
}

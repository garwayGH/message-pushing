package com.viatom.messagepushing.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 封装前端字段
 * @author qiujiawei
 * @description BaseSearchConditional
 * @date 2020/11/23 10:51
 */
@Data
@ApiModel("前端请求字段封装")
public class BaseSearchConditional {

    @ApiModelProperty(notes = "用户ID", dataType = "int", required = true)
    private int userId;

    @ApiModelProperty(notes = "设备token", dataType = "String", required = true)
    private String deviceToken;
}

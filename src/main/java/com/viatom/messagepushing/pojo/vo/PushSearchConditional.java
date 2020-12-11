package com.viatom.messagepushing.pojo.vo;

import lombok.Data;

/**
 * @author qiujiawei
 * @description PushSearchConditional
 * @date 2020/12/3 9:41
 */
@Data
public class PushSearchConditional {

    private String appType;
    private String version;
    private String title;
    private String ticker;
    private String text;
    private String date;
    private String description;
}

package com.viatom.messagepushing.pojo.push;

import lombok.Data;

/**
 * @author qiujiawei
 * @description AndroidBean
 * @date 2020/12/1 10:38
 */
@Data
public class AndroidBean {

    private String deviceTokens;
    private String title;
    private String subtitle;
    private String body;
    private String description;
    private String text;
    private String ticker;


}

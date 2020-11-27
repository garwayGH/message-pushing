package com.viatom.messagepushing.pojo.iwown;

import lombok.Data;

/**
 * @author qiujiawei
 * @description ClientInfo
 * @date 2020/11/27 16:33
 */
@Data
public class ClientInfo {
    private int ciId;
    private int applicationId;
    private int clientType;
    private String version;
    private String versionCode;
    private String downloadUrl;
    private String upgradeMemo;
    private String knowledgeTagUpdateTime;
    private String previousHistoryUpdateTime;
    private String appType;
    private String appChannel;
    private int valId;
    private int forceUpgrade;
    private String described;

}

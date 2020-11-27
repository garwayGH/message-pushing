package com.viatom.messagepushing.pojo.push;

import lombok.Data;

/**
 * @author qiujiawei
 */
@Data
public class User {

    private int id;
    private int userId;
    private String deviceToken;
    private String createTime;
}

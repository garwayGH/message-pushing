package com.viatom.messagepushing.umengpush.vo.ios;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * 当content-available=1时(静默推送)，可选; 否则必填。
 * 可为JSON类型和字符串类型
 * @author qiujiawei
 * @description Alert
 * @date 2020/8/19 17:21
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Alert {

    private String title;

    private String subtitle;

    private String body;
}

package com.viatom.messagepushing.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author qiujiawei
 * @description PushDataBaseProperties
 * @date 2020/11/27 13:59
 */
@Data
@Component
@ConfigurationProperties(prefix = "spring.datasource.push", ignoreInvalidFields = true)
public class PushDataBaseProperties {

    private String driverClassName;
    private String url;
    private String username;
    private String password;
    private String type;

}

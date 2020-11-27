package com.viatom.messagepushing.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author qiujiawei
 * @description IwownDataBaseProperties
 * @date 2020/11/27 14:22
 */
@Data
@Component
@ConfigurationProperties(prefix = "spring.datasource.db2")
public class IwownDataBaseProperties {

    private String driverClassName;
    private String url;
    private String username;
    private String password;
    private String type;

}

package com.viatom.messagepushing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * PropertySource注解用于开发环境，
 * 如果是测试环境和生产环境则指定读取
 * conf文件夹下的message-pushing.properties
 */
@SpringBootApplication
@EnableTransactionManagement
@PropertySources({@PropertySource(value = "classpath:/message-pushing.properties",ignoreResourceNotFound = true,encoding = "utf-8")})
public class MessagePushingApplication {


    public static void main(String[] args) {
        SpringApplication.run(MessagePushingApplication.class, args);

    }

}

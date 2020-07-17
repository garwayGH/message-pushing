package com.viatom.messagepushing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.viatom.messagepushing.mapper")
public class MessagePushingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessagePushingApplication.class, args);
    }

}

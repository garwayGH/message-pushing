package com.viatom.messagepushing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author qiujiawei
 * @description SwaggerConfig
 * @date 2020/8/24 15:20
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //controller包路径
                .apis(RequestHandlerSelectors.basePackage("com.viatom.messagepushing.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("消息推送后台接口文档")
                //创建人
                .contact(new Contact("qiujiawei", "", ""))
                //版本号
                .version("1.0")
                //描述
                .description("Android和IOS消息推送")
                .build();
    }
}

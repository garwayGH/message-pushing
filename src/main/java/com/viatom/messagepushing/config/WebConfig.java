package com.viatom.messagepushing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * SpringMVC配置类
 * @author qiujiawei
 * @date 2020/01/17
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 注册编码转换器Bean
     * @return StringHttpMessageConverter
     */
    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        return new StringHttpMessageConverter(StandardCharsets.UTF_8);
    }



    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //将所有/static/** 访问都映射到classpath:/static/ 目录下
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/versionPush/**")
                //允许跨域的域名，可以用*表示允许任何域名使用
                .allowedOrigins("*")
                //允许任何方法（post、get等）
                .allowedMethods("*")
                //允许任何请求头
                .allowedHeaders("*")
                //带上cookie信息
                .allowCredentials(true)
                //maxAge(3600)表明在3600秒内，不需要再发送预检验请求，可以缓存该结果
                .exposedHeaders(HttpHeaders.SET_COOKIE).maxAge(3600L);
    }

    /**
     * 添加转换器
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(responseBodyConverter());
    }

    

}

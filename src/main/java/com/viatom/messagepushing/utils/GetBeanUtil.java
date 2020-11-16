package com.viatom.messagepushing.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author qiujiawei
 * @description 获取Spring容器里的bean
 * @date 2020/11/10 11:11
 */
@Component
public class GetBeanUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (GetBeanUtil.applicationContext == null) {
            GetBeanUtil.applicationContext = applicationContext;
        }
    }

    /**
     *
     * @param beanName bean名称
     * @return
     */
    public static Object getBean(String beanName){
        return applicationContext.getBean(beanName);
    }

    /**
     *
     * @param classType 类类型
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> classType) {
        return applicationContext.getBean(classType);
    }
}

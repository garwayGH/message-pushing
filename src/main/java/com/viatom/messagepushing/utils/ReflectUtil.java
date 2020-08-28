package com.viatom.messagepushing.utils;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.springframework.cglib.beans.BeanGenerator;
import org.springframework.cglib.beans.BeanMap;

import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qiujiawei
 * @description 动态添加实体类的属性
 * @date 2020/8/25 14:19
 */
@Slf4j
public class ReflectUtil {

    public static Object getTarget(Object dest, Map<String, Object> addProperties) {
        PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
        PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(dest);
        HashMap<String, Class> propertyMap = Maps.newHashMap();
        for (PropertyDescriptor d : descriptors) {
            if (!"class".equalsIgnoreCase(d.getName())) {
                propertyMap.put(d.getName(), d.getPropertyType());
            }
        }
        //添加额外属性
        addProperties.forEach((k, v) -> propertyMap.put(k, v.getClass()));
        //生成动态bean
        DynamicBean dynamicBean = new DynamicBean(dest.getClass(), propertyMap);
        //添加旧值
        propertyMap.forEach((k,v) -> {
            try {
                //过滤额外属性
                if (!addProperties.containsKey(k)) {
                    dynamicBean.setValue(k, propertyUtilsBean.getNestedProperty(dest, k));
                }
            } catch (Exception e) {
                log.error("添加就属性异常：", e);
            }
        });

        //添加额外值
        addProperties.forEach((k,v) -> {
            try {
                dynamicBean.setValue(k,v);
            } catch (Exception e) {
                log.error("添加额外值异常：", e);
            }
        });

        return dynamicBean.getTarget();
    }

    public static class DynamicBean {
        /**
         * 目标对象
         */
        private final Object target;

        /**
         * 集合属性
         */
        private final BeanMap beanMap;

        public DynamicBean(Class superClass, Map<String, Class> propertyMap) {
            this.target = generateBean(superClass, propertyMap);
            this.beanMap = BeanMap.create(this.target);
        }

        /**
         * bean 添加属性
         * @param property
         * @param value
         */
        public void setValue(String property, Object value) {
            beanMap.put(property, value);
        }

        /**
         * 获取属性值
         *
         * @param property
         * @return
         */
        public Object getValue(String property) {
            return beanMap.get(property);
        }

        /**
         * 获取对象
         *
         * @return
         */
        public Object getTarget() {
            return this.target;
        }

        /**
         * 根据属性生成对象
         *
         * @param superclass
         * @param propertyMap
         * @return
         */
        private Object generateBean(Class superclass, Map<String, Class> propertyMap) {
            BeanGenerator generator =new BeanGenerator();
            if(null != superclass) {
                generator.setSuperclass(superclass);
            }
            BeanGenerator.addProperties(generator, propertyMap);
            return generator.create();
        }
    }

}

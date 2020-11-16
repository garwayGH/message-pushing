package com.viatom.messagepushing.common;

import java.lang.annotation.*;

/**
 * @author qiujiawei
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PushTag {
    String value() default "";
}

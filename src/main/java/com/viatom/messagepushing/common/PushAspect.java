package com.viatom.messagepushing.common;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author qiujiawei
 * @description PushAspect
 * @date 2020/11/5 17:10
 */
@Component
@Aspect
@Slf4j
public class PushAspect {

    @Pointcut("@annotation(com.viatom.messagepushing.common.PushTag)")
    public void pointCut() {}


    @AfterThrowing(pointcut = "pointCut()",throwing = "e")
    public void doAfterThrowingAdvice(JoinPoint joinPoint, Throwable e) {
        log.info("异常通知");
        log.info("代理方法：{},异常信息：{}",joinPoint.getSignature().getName(),e.toString());
    }
}

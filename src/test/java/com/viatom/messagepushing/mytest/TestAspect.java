package com.viatom.messagepushing.mytest;

import com.viatom.messagepushing.common.PushTag;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Component;

/**
 * @author qiujiawei
 * @description TestAspect
 * @date 2020/11/16 16:39
 */
@Component
public class TestAspect {


    public void testA() {
//        TestAspect testAspect = (TestAspect)AopContext.currentProxy();
//        this.testB();
        System.out.println("testA=============");
        this.testB();

    }

    @PushTag
    public void testB() {
        System.out.println("testB=============");
        int a = 1 / 0;
    }



}

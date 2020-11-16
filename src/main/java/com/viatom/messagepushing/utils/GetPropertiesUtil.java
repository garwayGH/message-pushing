package com.viatom.messagepushing.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author qiujiawei
 * @description getPropertiesUtil
 * @date 2020/11/10 16:30
 */
@Component
public class GetPropertiesUtil {

    private static boolean productMode;

    public boolean getProductMode() {
        return productMode;
    }

    @Value("${productMode}")
    public void setProductMode(boolean productMode) {
        GetPropertiesUtil.productMode = productMode;
    }


}

package com.viatom.messagepushing.mapper.push;

import com.viatom.messagepushing.pojo.vo.BaseSearchConditional;
import org.springframework.stereotype.Repository;

/**
 * @author qiujiawei
 */
@Repository
public interface UserMapper {

    /**
     * 绑定用户的友盟deviceToken
     * @param searchConditional
     * @return
     */
    int bindUserDeviceToken(BaseSearchConditional searchConditional);

}

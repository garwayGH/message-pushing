package com.viatom.messagepushing.mapper;

import com.viatom.messagepushing.pojo.User;

/**
 * @author qiujiawei
 */

public interface UserMapper {

    User getUserByPhone(String phone);
}

package com.viatom.messagepushing.mapper;

import com.viatom.messagepushing.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author qiujiawei
 */
@Repository
public interface UserMapper {

    User getUserByPhone(String phone);
}

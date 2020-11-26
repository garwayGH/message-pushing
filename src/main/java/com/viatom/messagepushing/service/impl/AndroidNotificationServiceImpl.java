package com.viatom.messagepushing.service.impl;

import com.viatom.messagepushing.mapper.UserMapper;
import com.viatom.messagepushing.pojo.vo.BaseSearchConditional;
import com.viatom.messagepushing.service.AndroidNotificationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author qiujiawei
 * @description AndroidNotificationServiceImpl
 * @date 2020/11/18 14:11
 */
@Service
public class AndroidNotificationServiceImpl implements AndroidNotificationService {

    @Resource
    UserMapper userMapper;

    @Override
    public int bindUserDeviceToken(BaseSearchConditional searchConditional) {

        return userMapper.bindUserDeviceToken(searchConditional);
    }
}

package com.viatom.messagepushing.controller;


import com.viatom.messagepushing.mapper.UserMapper;
import com.viatom.messagepushing.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiujiawei
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/getUser/{phone}")
    public User getUserByPhone(@PathVariable String phone) {
        User user = userMapper.getUserByPhone(phone);
        log.info("获取的用户为：{}",user.toString());
        return user;
    }


    @GetMapping("/test")
    public String test() {
        int a = 1 / 0;
        return "test";
    }
}

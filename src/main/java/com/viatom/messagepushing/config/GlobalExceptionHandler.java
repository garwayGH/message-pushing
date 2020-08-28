package com.viatom.messagepushing.config;


import com.viatom.messagepushing.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常捕捉
 * @author qiujiawei
 * @date 2020/01/17
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result globalException(Exception e) {
        log.error("全局捕捉的异常为:",e);

        return Result.error();
    }
}

package com.viatom.messagepushing.umengpush.vo;

import com.viatom.messagepushing.mapper.UserMapper;
import com.viatom.messagepushing.utils.GetBeanUtil;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author qiujiawei
 * @description OKHttp异步请求的回调函数
 * @date 2020/11/10 10:05
 */
@Slf4j
public class MyCallBack implements Callback {

    private UserMapper userMapper = GetBeanUtil.getBean(UserMapper.class);

    public UserMapper getUserMapper() {
        return this.userMapper;
    }

    @Override
    public void onFailure(Call call, IOException e) {
        log.error("http请求异常：", e);
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        boolean successful = response.isSuccessful();
        if (successful) {
            ResponseBody body = response.body();
            int code = response.code();
            log.info("code======{}", code);
            if (body != null) {
                BufferedReader br = new BufferedReader(new InputStreamReader(body.byteStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                log.info("请求友盟接口返回结果：{}", sb.toString());
                br.close();
            }
            response.close();
        }
    }



}

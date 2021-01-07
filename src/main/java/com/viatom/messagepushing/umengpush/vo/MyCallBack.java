package com.viatom.messagepushing.umengpush.vo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.viatom.messagepushing.mapper.push.UserMapper;
import com.viatom.messagepushing.utils.GetBeanUtil;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * @author qiujiawei
 * @description OKHttp异步请求的回调函数
 * @date 2020/11/10 10:05
 */
@Slf4j
public class MyCallBack implements Callback {

    private UserMapper userMapper = GetBeanUtil.getBean(UserMapper.class);



    @Override
    public void onFailure(Call call, IOException e) {
        log.error("http请求异常：", e);
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        boolean successful = response.isSuccessful();
        ResponseBody body = response.body();


        if (body != null) {
            BufferedReader br = new BufferedReader(new InputStreamReader(body.byteStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            //返回结果json
            String resultJson = sb.toString();
            if (successful) {
                log.info("请求友盟接口返回结果：{}", resultJson);
            }else {
                ObjectMapper objectMapper = new ObjectMapper();
                Map<?,?> map = objectMapper.readValue(resultJson, Map.class);
                if (map.containsKey("data")) {
                    Map<?,?> data = (Map<?,?>)map.get("data");
                    String errorCode = (String) data.get("error_code");
                    String errorMsg = (String) data.get("error_msg");
                    log.info("友盟推送失败，errorCode:{},errorMsg:{}",errorCode,errorMsg);
                }
            }
            br.close();
        }
        response.close();
    }



}

package com.viatom.messagepushing.umengpush;

import com.viatom.messagepushing.umengpush.vo.constants.Constants;
import com.viatom.messagepushing.utils.OkHttpUtil;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.util.DigestUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * 推送类
 * @author qiujiawei
 * @description PushClient
 * @date 2020/8/19 14:55
 */
@Slf4j
public class PushClient {
    /**
     * 用户代理
     */
    private static final String USER_AGENT = "Mozilla/5.0";

    /**
     * http工具类
     */
    private final OkHttpUtil okHttpUtil = OkHttpUtil.getInstance();

    /**
     * 友盟域名
     */
    private static final String HOST = "http://msg.umeng.com";

    /**
     * 文件上传路径
     */
    private static final String UPLOAD_PATH = "/upload";

    /**
     * post请求路径
     */
    private static final String POST_PATH = "/api/send";

    /**
     * 发送推送请求体
     * @param notification 消息
     * @return
     * @throws Exception
     */
    public boolean send(AbstractUmengNotification notification) throws Exception {
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
        notification.setPredefinedKeyValue(Constants.UmengRootParam.TIMESTAMP.getFieldName(), timestamp);
        String url = HOST + POST_PATH;
        String postBody = notification.getPostBody();
        String sign = DigestUtils.md5DigestAsHex(("POST" + url + postBody+ notification.getAppMasterSecret()).getBytes(StandardCharsets.UTF_8));
        url = url + "?sign=" + sign;

        Headers headers = new Headers.Builder()
                                     .add("User-Agent", USER_AGENT)
                                     .build();

        okHttpUtil.doAsyncPost(url, headers, postBody, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                log.error("http请求异常：", e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                boolean successful = response.isSuccessful();
                if (successful) {
                    ResponseBody body = response.body();
                    if (body != null) {
                        BufferedReader br = new BufferedReader(new InputStreamReader(body.byteStream()));
                        StringBuilder sb = new StringBuilder();
                        String line = "";
                        while ((line = br.readLine()) != null) {
                            sb.append(line);
                        }
                        System.out.println(sb.toString());
                    }
                    int code = response.code();
                    System.out.println("code======" + code);
                }
            }
        });

        return true;
    }


}

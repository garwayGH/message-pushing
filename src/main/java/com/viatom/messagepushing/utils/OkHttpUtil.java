package com.viatom.messagepushing.utils;

import okhttp3.*;

import java.util.concurrent.TimeUnit;

/**
 * @description: OkHttpUtil 单例
 * @author: qiujiawei
 * @date: 2020/8/7 9:54
 */
public class OkHttpUtil {

    private volatile static OkHttpUtil okHttpUtil = null;
    private static OkHttpClient okHttpClient = null;
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");


    private OkHttpUtil() {

    }

    /**
     * 创建单例
     * @return okHttpUtil
     */
    public static OkHttpUtil getInstance() {
        if (okHttpUtil == null) {
            synchronized (OkHttpUtil.class) {
                if (okHttpUtil == null) {
                    okHttpUtil = new OkHttpUtil();
                    if (okHttpClient == null) {
                        okHttpClient = new OkHttpClient.Builder()
                                                       .connectTimeout(30L, TimeUnit.SECONDS)
                                                       .readTimeout(30L,TimeUnit.SECONDS)
                                                       .build();
                    }
                }
            }
        }
        return okHttpUtil;
    }

    /**
     *
     * @param url 路径
     * @param headers 请求头
     * @param callback 异步回调函数
     */
    public void doAsyncGet(String url, Headers headers, Callback callback) {
        //新建request对象
        Request.Builder builder = new Request.Builder().url(url);

        if (headers != null) {
            builder.headers(headers);
        }

        Request request = builder.build();
        okHttpClient.newCall(request).enqueue(callback);
    }

    /**
     *
     * @param url 路径
     * @param callback 回调函数
     */
    public void doAsyncGet(String url, Callback callback) {
        this.doAsyncGet(url, null, callback);
    }

    /**
     *
     * @param url 路径
     * @param headers 请求头
     * @param json json字符串
     * @param callback 异步回调函数
     */
    public void doAsyncPost(String url, Headers headers,String json, Callback callback) {
        RequestBody requestBody = RequestBody.create(MEDIA_TYPE, json);
        Request.Builder builder = new Request.Builder()
                                             .url(url)
                                             .post(requestBody);

        if (headers != null) {
            builder.headers(headers);
        }

        Request request = builder.build();
        okHttpClient.newCall(request).enqueue(callback);
    }

    /**
     *
     * @param url 路径
     * @param json json字符串
     * @param callback 异步回调函数
     */
    public void doAsyncPost(String url, String json, Callback callback) {
        this.doAsyncPost(url, null, json, callback);
    }


    /**
     * post同步请求
     * @param url
     * @param headers
     * @param json
     * @return
     * @throws Exception
     */
    public Response doSyncPost(String url,Headers headers, String json) throws Exception {
        RequestBody requestBody = RequestBody.create(MEDIA_TYPE, json);
        Request.Builder builder = new Request.Builder()
                .url(url)
                .post(requestBody);

        if (headers != null) {
            builder.headers(headers);
        }

        Request request = builder.build();
        return okHttpClient.newCall(request).execute();
    }

    public Response doSyncPost(String url, String json) throws Exception{
        return this.doSyncPost(url, null, json);
    }
}

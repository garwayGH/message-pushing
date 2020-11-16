package com.viatom.messagepushing;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Maps;
import com.viatom.messagepushing.umengpush.IosPush;
import com.viatom.messagepushing.umengpush.vo.Filter;
import com.viatom.messagepushing.umengpush.vo.MyCallBack;
import com.viatom.messagepushing.umengpush.vo.ios.Aps;
import com.viatom.messagepushing.umengpush.vo.ios.IosPayLoad;
import com.viatom.messagepushing.utils.GetBeanUtil;
import com.viatom.messagepushing.utils.GetPropertiesUtil;
import com.viatom.messagepushing.utils.ReflectUtil;
import okhttp3.OkHttpClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.nio.channels.ServerSocketChannel;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class MessagePushingApplicationTests {


    @Autowired
    DataSource  dataSource;

    @Resource
    IosPush iosPush;

    @Resource
    GetPropertiesUtil getPropertiesUtil;

    @Value("${iosAppKey}")
    String appKey;

    @Value("${iosAppMasterSecret}")
    String appMasterSecret;
    @Test
    void contextLoads() throws SQLException {
//        Connection con = dataSource.getConnection();
//        System.out.println(con);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDateTime dateTime = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
//        Date date = new Date();
//        long l = 1596107040000L;
//        date.setTime(l);
//        Instant instant = date.toInstant();
//        LocalDateTime dateTime1 = LocalDateTime.ofInstant(instant, ZoneOffset.of("+8"));
//        String format = dateTime.format(formatter);
//
//        System.out.println(dateTime1.format(formatter));
//        System.out.println(appKey);
//        System.out.println(appMasterSecret);

//        MyCallBack myCallBack = new MyCallBack();
//        System.out.println("=============" + myCallBack.getUserMapper().toString());

//        boolean productMode = getPropertiesUtil.getProductMode();
        GetPropertiesUtil propertiesUtil = GetBeanUtil.getBean(GetPropertiesUtil.class);

        System.out.println(propertiesUtil.getProductMode());

    }

    @Test
    void test01() throws Exception {
        OkHttpClient client = new OkHttpClient();
        client.newBuilder().readTimeout(30, TimeUnit.SECONDS).build();

    }

    @Test
    void test02() throws Exception {
        Filter filter = new Filter.Builder()
                .and("test1", "test1")
                .and("test2", "test2")
                .or("or1", "o1")
                .or("or2", "or2")
                .orNot("on1", "on1")
                .not("not1","not1")
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(filter);
        System.out.println(s);
    }


    public static void main(String[] args) throws Exception{
        IosPayLoad iosPayLoad = new IosPayLoad();
        Aps aps = new Aps();
        aps.setBadge(1);
        aps.setCategory("11");
        aps.setSound("0");
        iosPayLoad.setAps(aps);
        HashMap<String, Object> map = Maps.newHashMap();
        map.put("key2", "test2");
        map.put("key3", "test3");
        iosPayLoad = (IosPayLoad)ReflectUtil.getTarget(iosPayLoad, map);
        ObjectMapper objectMapper = new ObjectMapper();

        String s = objectMapper.writeValueAsString(iosPayLoad);
        System.out.println(s);
    }

    @Test
    void test03() throws Exception{
        ServerSocketChannel channel = ServerSocketChannel.open();
    }


}

package com.viatom.messagepushing;

import com.github.pagehelper.PageHelper;
import okhttp3.OkHttpClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class MessagePushingApplicationTests {


    @Autowired
    DataSource  dataSource;

    @Test
    void contextLoads() throws SQLException {
//        Connection con = dataSource.getConnection();
//        System.out.println(con);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        Date date = new Date();
        long l = 1596107040000L;
        date.setTime(l);
        Instant instant = date.toInstant();
        LocalDateTime dateTime1 = LocalDateTime.ofInstant(instant, ZoneOffset.of("+8"));
        String format = dateTime.format(formatter);

        System.out.println(dateTime1.format(formatter));

    }

    @Test
    void test01() throws Exception {
        OkHttpClient client = new OkHttpClient();
        client.newBuilder().readTimeout(30, TimeUnit.SECONDS).build();

    }

}

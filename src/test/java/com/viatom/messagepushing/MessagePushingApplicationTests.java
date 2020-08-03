package com.viatom.messagepushing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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
        String format = dateTime.format(formatter);
        System.out.println(format);

    }

}

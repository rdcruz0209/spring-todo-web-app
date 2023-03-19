package com.webapplicationprojects.springboot.todowebapp.configuration;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
@Slf4j
public class DateSQLFormat {

    @PostConstruct
    public void init() {
//        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));   // It will set UTC timezone
        log.info(System.getProperty("user.timezone", "EST"));
        log.info("Spring boot application running in UTC timezone :" + new Date()); // It will print UTC timezone;
    }
}

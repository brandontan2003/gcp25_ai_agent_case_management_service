package com.gcp.agent25.cases.management.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.TimeZone;

import static com.gcp.agent25.common.core.constant.CommonConstant.BASE_PACKAGE;
import static com.gcp.agent25.common.core.constant.CommonConstant.DEFAULT_TIMEZONE;


@SpringBootApplication
@ComponentScan(basePackages = BASE_PACKAGE)
public class CaseManagementServiceApplication {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone(DEFAULT_TIMEZONE));
        SpringApplication.run(CaseManagementServiceApplication.class, args);
    }

}

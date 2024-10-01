package com.hnu.webmanagementdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class WebManagementdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebManagementdemoApplication.class, args);
    }

}

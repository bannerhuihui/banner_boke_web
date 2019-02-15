package com.banner.boke.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.banner.boke.web.mapper")
public class BannerBokeWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(BannerBokeWebApplication.class, args);
    }

}


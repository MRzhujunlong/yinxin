package com.yinxin.yinxinsysteam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.yinxin.yinxinsysteam.MapperInterf")
@ServletComponentScan
public class YinxinsysteamApplication  extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(YinxinsysteamApplication.class, args);
    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(YinxinsysteamApplication.class);
    }
}

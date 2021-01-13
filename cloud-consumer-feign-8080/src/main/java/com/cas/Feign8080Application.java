package com.cas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: xianglong[1391086179@qq.com]
 * @date: 下午12:05 2021/1/13
 * @version: V1.0
 * @review:
 */
@SpringBootApplication
@EnableFeignClients
public class Feign8080Application {

    public static void main(String[] args) {
        SpringApplication.run(Feign8080Application.class, args);
    }
}

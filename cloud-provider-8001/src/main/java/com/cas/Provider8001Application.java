package com.cas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: xianglong[1391086179@qq.com]
 * @date: 下午6:45 2021/1/12
 * @version: V1.0
 * @review:
 */
@EnableEurekaClient
@SpringBootApplication
public class Provider8001Application {

    public static void main(String[] args) {
        SpringApplication.run(Provider8001Application.class, args);
    }

}

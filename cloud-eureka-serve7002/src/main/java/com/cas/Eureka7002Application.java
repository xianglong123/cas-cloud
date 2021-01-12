package com.cas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: xianglong[1391086179@qq.com]
 * @date: 下午7:34 2021/1/12
 * @version: V1.0
 * @review:
 */
@SpringBootApplication
@EnableEurekaServer
public class Eureka7002Application {

    public static void main(String[] args) {
        SpringApplication.run(Eureka7002Application.class, args);
    }

}

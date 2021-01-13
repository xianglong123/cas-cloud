package com.cas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: xianglong[1391086179@qq.com]
 * @date: 下午6:05 2021/1/13
 * @version: V1.0
 * @review:
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class Hystrix8001Application {

    public static void main(String[] args) {
        SpringApplication.run(Hystrix8001Application.class, args);
    }

}

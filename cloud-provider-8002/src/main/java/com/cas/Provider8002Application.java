package com.cas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: xianglong[1391086179@qq.com]
 * @date: 下午6:45 2021/1/12
 * @version: V1.0
 * @review:
 */
@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
public class Provider8002Application {

    public static void main(String[] args) {
        SpringApplication.run(Provider8002Application.class, args);
    }

}

package com.cas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: xianglong[1391086179@qq.com]
 * @date: 下午10:22 2021/1/14
 * @version: V1.0
 * @review:
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClient3355Application {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClient3355Application.class, args);
    }

}

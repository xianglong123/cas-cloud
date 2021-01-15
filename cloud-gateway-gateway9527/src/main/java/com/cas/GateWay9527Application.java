package com.cas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: xianglong[1391086179@qq.com]
 * @date: 下午5:01 2021/1/14
 * @version: V1.0
 * @review:
 */
@SpringBootApplication
@EnableEurekaClient
public class GateWay9527Application {

    public static void main(String[] args) {
        SpringApplication.run(GateWay9527Application.class, args);
    }

}

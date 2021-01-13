package com.cas;

import com.rule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author: xianglong[1391086179@qq.com]
 * @date: 下午8:56 2021/1/12
 * @version: V1.0
 * @review:
 */
@SpringBootApplication
@RibbonClient(name = "CLOUD-PRIVIDER-SERVICE", configuration = MySelfRule.class)
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

}

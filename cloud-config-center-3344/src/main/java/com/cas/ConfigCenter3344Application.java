package com.cas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @author: xianglong[1391086179@qq.com]
 * @date: 下午9:52 2021/1/14
 * @version: V1.0
 * @review:
 */
@SpringBootApplication
@EnableConfigServer
@RefreshScope
public class ConfigCenter3344Application {

    public static void main(String[] args) {
        SpringApplication.run(ConfigCenter3344Application.class, args);
    }

}

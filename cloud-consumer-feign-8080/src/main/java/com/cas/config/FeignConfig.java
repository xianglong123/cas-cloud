package com.cas.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: xianglong[1391086179@qq.com]
 * @date: 下午12:39 2021/1/13
 * @version: V1.0
 * @review:
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}

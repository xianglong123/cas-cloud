package com.cas.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: xianglong[1391086179@qq.com]
 * @date: 下午9:11 2021/1/12
 * @version: V1.0
 * @review:
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced // @LoadBalanced 起到负载均衡的效果，不然多个服务无法确定连接哪台，策略：轮训
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}

package com.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: xianglong[1391086179@qq.com]
 * @date: 上午9:30 2021/1/13
 * @version: V1.0
 * @review: 不允许放在启动内包与子包下，放平行包下。不然会改所有策略
 * 启动类打注解：@RibbonClient(name = "CLOUD-PRIVIDER-SERVICE", configuration = MySelfRule.class)
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        // 定义为随机 一共有5种内置策略
        return new RandomRule();
    }

}

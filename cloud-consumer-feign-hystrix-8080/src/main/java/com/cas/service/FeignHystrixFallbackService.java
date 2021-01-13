package com.cas.service;

import org.springframework.stereotype.Component;

/**
 * @author: xianglong[1391086179@qq.com]
 * @date: 下午7:39 2021/1/13
 * @version: V1.0
 * @review: 为每一个feign接口写兜底方法，服务降级
 */
@Component
public class FeignHystrixFallbackService implements FeignHystrixService{
    @Override
    public String ok() {
        return "fallback ok !! 😭";
    }

    @Override
    public String timeout() {
        return "fallback timeout !！ 😭";
    }
}

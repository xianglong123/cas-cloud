package com.cas.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: xianglong[1391086179@qq.com]
 * @date: 下午12:10 2021/1/13
 * @version: V1.0
 * @review: feign接口调用，得加@FeignClient注解，value是服务名
 * <p>
 * feign的接口，可以是controller,也可以是service
 * fallback 统一为这个服务做兜底的方法
 */
@Component
@FeignClient(value = "CLOUD-PRIVIDER-SERVICE", fallback = FeignHystrixFallbackService.class)
public interface FeignHystrixService {

    @RequestMapping("/ok/hys")
    public String ok();

    @RequestMapping("/timeout/hys")
    public String timeout();

    @RequestMapping("/breaker/{id}")
    public String breaker(@PathVariable("id") Integer id);
}

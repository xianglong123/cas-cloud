package com.cas.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author: xianglong[1391086179@qq.com]
 * @date: 下午12:10 2021/1/13
 * @version: V1.0
 * @review: feign接口调用，得加@FeignClient注解，value是服务名
 * <p>
 * feign的接口，可以是controller,也可以是service
 */
@FeignClient(value = "CLOUD-PRIVIDER-SERVICE", contextId = "yjm")
public interface FeignCustomService {

    @PostMapping("/getName")
    public String getName();

    @PostMapping("/header")
    public String header();

    @PostMapping("/timeout")
    public String timeout() throws InterruptedException;

}

package com.cas.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.cas.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class FeignController {

    @Resource
    private OrderService orderService;

    @GetMapping("/feign/get/{id}")
    @SentinelResource(value = "feign", fallback = "deal_fallback")
    public String echo(@PathVariable Long id) {
//        int a = 10/0;
        return orderService.echo(id);
    }

    public String deal_fallback(@PathVariable Long id, Throwable throwable) {
        return "deal_fallback --- 服务报错";
    }


}
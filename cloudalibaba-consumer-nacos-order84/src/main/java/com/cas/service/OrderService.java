package com.cas.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author xiang_long
 * @version 1.0
 * @date 2021/7/31 1:27 下午
 * @desc
 */
@Service
@FeignClient(value = "nacos-payment-provider", fallback = OrderFallBackService.class)
public interface OrderService {

    @GetMapping(value = "/get/{id}")
    public String echo(@PathVariable Long id);

}

package com.cas.service;

import org.springframework.stereotype.Component;

/**
 * @author xiang_long
 * @version 1.0
 * @date 2021/7/31 1:33 下午
 * @desc
 */
@Component
public class OrderFallBackService implements OrderService{


    @Override
    public String echo(Long id) {
        return "OrderFallBackService -- 服务降级";
    }
}

package com.cas.controller;

import com.cas.service.FeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: xianglong[1391086179@qq.com]
 * @date: 下午12:13 2021/1/13
 * @version: V1.0
 * @review: Feign, 底层已经配置好ribbon做负载
 */
@RestController
@Slf4j
public class CommonController {

    @Resource
    private FeignService feignService;

    @RequestMapping("/getName/feign")
    public String getName() {
        return feignService.getName();
    }

    @RequestMapping("/timeout/feign")
    public String timeout() throws InterruptedException {
        return feignService.timeout();
    }

}

package com.cas.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author: xianglong[1391086179@qq.com]
 * @date: 下午8:57 2021/1/12
 * @version: V1.0
 * @review:
 */
@Slf4j
@RestController
public class CommonController {

    public static final String COMMON_URL = "http://CLOUD-PRIVIDER-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/getName")
    public String getName() {
        return restTemplate.getForObject(COMMON_URL + "/getName", String.class, String.class);
    }

    @GetMapping("/discovery")
    public Object discovery() {
        return restTemplate.getForObject(COMMON_URL + "/discovery", Object.class, Object.class);
    }


}

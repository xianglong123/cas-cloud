package com.cas.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xianglong[1391086179@qq.com]
 * @date: 下午10:23 2021/1/14
 * @version: V1.0
 * @review:
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${master.data}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return configInfo;
    }

}

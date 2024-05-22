package com.cas.controller;

import com.cas.service.FeignCustomService;
import com.cas.service.FeignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * @author: xianglong[1391086179@qq.com]
 * @date: 下午12:13 2021/1/13
 * @version: V1.0
 * @review: Feign, 底层已经配置好ribbon做负载
 */
@RestController
public class CommonController {
    private static final Logger log = LoggerFactory.getLogger(CommonController.class);

    @Resource
    private FeignService feignService;
    @Resource
    private FeignCustomService customerFeign;


    @RequestMapping("/getName/feign")
    public String getName() {
        return feignService.getName();
    }

    @RequestMapping("/timeout/feign")
    public String timeout() throws InterruptedException {
        log.info("time-start=[{}]", LocalDateTime.now());
        String timeout = feignService.timeout();
        log.info("time-end=[{}]", LocalDateTime.now());
        return timeout;
    }

    @RequestMapping("/timeout/diy")
    public String timeoutDiy() throws InterruptedException {
        log.info("time-start=[{}]", LocalDateTime.now());
        String timeout = customerFeign.timeout();
        log.info("time-end=[{}]", LocalDateTime.now());
        return timeout;
    }

    /**
     * 传递header通过feign接口
     * @return
     */
    @RequestMapping("/header/feign")
    public String header() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        request.setAttribute("name", "111111");
        return feignService.header();
    }

}

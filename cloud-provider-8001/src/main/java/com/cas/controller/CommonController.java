package com.cas.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: xianglong[1391086179@qq.com]
 * @date: 下午6:47 2021/1/12
 * @version: V1.0
 * @review:
 */
@Controller
public class CommonController {
    private static final Logger log = LoggerFactory.getLogger(CommonController.class);

    @Resource
    private DiscoveryClient discoveryClient;

    @ResponseBody
    @PostMapping("/getName")
    public String getName() {
        return "hello, my port is 8001";
    }

    @GetMapping("/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        services.forEach(a -> log.info("******element: [{}]", a));
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PRIVIDER-SERVICE");
        instances.forEach(a -> log.info(a.getServiceId() + "\t" + a.getHost() + "\t" + a.getPort() + "\t" + a.getUri()));
        return this.discoveryClient;
    }

    @ResponseBody
    @PostMapping("/timeout")
    public String timeout() throws InterruptedException {
        Thread.sleep(12000);
        return "timeout, my port is 8001";
    }


    @ResponseBody
    @RequestMapping("/header")
    public String header() {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        String name = request.getHeader("name");
        return "hello, my port is 8001, header=[" + name + "]";
    }

}

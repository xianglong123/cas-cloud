package com.cas.controller;

import com.cas.lb.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author: xianglong[1391086179@qq.com]
 * @date: 上午11:59 2021/1/13
 * @version: V1.0
 * @review: ribbon + RestTemplate
 */
@RestController
public class LBController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;


    /**
     * 自定义复杂策略
     * 策略类 com.cas.lb.LoadBalancer
     * http://localhost:8080/getName/lb
     * @return
     */
    @GetMapping("/getName/lb")
    public String getNameLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PRIVIDER-SERVICE");

        if (instances == null || instances.size() <= 0) {
            return null;
        }

        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/getName", String.class);
    }


}

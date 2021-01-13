package com.cas.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author: xianglong[1391086179@qq.com]
 * @date: 上午11:41 2021/1/13
 * @version: V1.0
 * @review:
 */
public interface LoadBalancer {

    public ServiceInstance instances(List<ServiceInstance> serviceInstances);
}

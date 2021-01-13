package com.cas.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: xianglong[1391086179@qq.com]
 * @date: 下午6:08 2021/1/13
 * @version: V1.0
 * @review:
 */
@Service
public class CommonService {

    public String ok() {
        return Thread.currentThread().getName() + " ok! 😊";
    }

    @HystrixCommand(fallbackMethod = "timeoutHandler", commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String timeout() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  Thread.currentThread().getName() + " timeout! 😊 耗时：3s";
    }

    /**
     * 上面的timeout方法超时或者报错都会通过 timeoutHandler兜底
     * @return
     */
    public String timeoutHandler() {
        return  Thread.currentThread().getName() + " 方法超时或者报错执行兜底方法 timeoutHandler! 😭 ";
    }


    @HystrixCommand(fallbackMethod = "breaker_fallback", commandProperties = {
        @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 开启断路器
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数超过峰值，熔断器将会从关闭到open
        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间范围
        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), // 失败频率达到多少后跳闸
    })
    public String breaker(Integer id) {

        if (id < 0) {
            throw new RuntimeException("**** id 不能为负数");
        }
        String uuid = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + uuid;
    }

    public String breaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能为负数，请稍后再试，id: " + id;
    }


}

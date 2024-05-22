package com.cas.config;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;
import com.netflix.hystrix.HystrixCommandProperties;

public class MyHystrixCommand extends HystrixCommand<String> {

    public MyHystrixCommand() {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                    .andCommandKey(HystrixCommandKey.Factory.asKey("ExampleCommand"))
                    .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("ExampleThreadPool"))
                    .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
                        .withCoreSize(10)  // 线程池核心线程数
                        .withMaximumSize(15)  // 线程池最大线程数
                        .withKeepAliveTimeMinutes(1)  // 非核心线程闲置超时时间
                        .withQueueSizeRejectionThreshold(5))  // 队列大小拒绝阈值
                    .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionTimeoutInMilliseconds(1000)));  // 命令执行超时时间
    }

    @Override
    protected String run() throws Exception {
        // 要执行的业务逻辑
        return "Success";
    }

    @Override
    protected String getFallback() {
        // 降级逻辑
        return "Fallback";
    }
}

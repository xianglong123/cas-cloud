package com.cas.controller;

import com.cas.service.FeignHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.cas.mq.RabbitMQConfig.DEAD_LETTER_EXCHANGE;
import static com.cas.mq.RabbitMQConfig.DEAD_LETTER_QUEUEA_ROUTING_KEY;

/**
 * @author: xianglong[1391086179@qq.com]
 * @date: 下午12:13 2021/1/13
 * @version: V1.0
 * @review: Feign, 底层已经配置好ribbon做负载
 */
@Slf4j
@RestController
//@DefaultProperties(defaultFallback = "Global_timeoutHandler")
public class CommonController {

    @Resource
    private FeignHystrixService feignHystrixService;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/ok/feign/hys")
    public String ok() {
        return feignHystrixService.ok();
    }

    @RequestMapping("/timeout/feign/hys")
//    @HystrixCommand(fallbackMethod = "timeoutHandler", commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    public String timeout() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return feignHystrixService.timeout();
    }


    /**
     * 上面的timeout方法超时或者报错都会通过 timeoutHandler兜底
     *
     * @return
     */
    public String timeoutHandler() {
        return Thread.currentThread().getName() + " 方法超时或者报错执行兜底方法2000 timeoutHandler! 😭 ";
    }

    public String Global_timeoutHandler() {
        return "Global_timeoutHandler !! 😭";
    }


    // -------------- 限流测试 start ---------------------------
    @HystrixCommand(
            fallbackMethod = "fallbackMethod",
            threadPoolKey = "myServiceThreadPool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "12"),
                    @HystrixProperty(name = "maxQueueSize", value = "30"),
            },
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
            })
    @RequestMapping("/limit")
    public String limit() {
        try {
//            System.out.println(Thread.currentThread().getName() + "---1----1----");
            Thread.sleep(300);
            // 引入mq查看效率
            rabbitTemplate.convertAndSend(DEAD_LETTER_EXCHANGE, DEAD_LETTER_QUEUEA_ROUTING_KEY, "123456");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "ok";
    }

    public String fallbackMethod() {
        System.out.println("降级被触发");
        // 降级逻辑
        return "Fallback";
    }


    /**
     * 对照组，高并发的正常业务模拟
     * @return
     */
    @RequestMapping("/limit_ok")
    public String limit_ok() {
        try {
            System.out.println(Thread.currentThread().getName() + "---1----1----");
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "ok";
    }
}

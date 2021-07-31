package com.cas;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cas.handler.CustomerBlockHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author xiang_long
 * @version 1.0
 * @date 2021/7/31 10:51 上午
 * @desc
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinelApplication.class, args);
    }

    @RestController
    public class FlowLimitController {

        private final Logger log = LoggerFactory.getLogger(FlowLimitController.class);

        @GetMapping("/testA")
        public String testA() throws InterruptedException {
            Thread.sleep(400);
            return "---------testA";
        }


        @GetMapping("/testB")
        public String testB() {
            return "---------testB";
        }

        @GetMapping("/testD")
        public String testD() {
            log.info("testD 测试异常比例");
            int a = 10/0;
            return "---------testD";
        }


        @GetMapping("/testE")
        public String testE() {
            log.info("testD 测试数");
            int a = 10/0;
            return "---------testD";
        }

        @GetMapping("/testHotKey")
        @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
        public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                                 @RequestParam(value = "p2", required = false) String p2
                                 ) {
            return "--------testHotKey";
        }

        public String deal_testHotKey(String p1, String p2, BlockException exception) {
            return "--------deal_testHotKey, 不好了，热点数据熔断了";
        }

    }


    @RestController
    public class RateLimitController {

        @GetMapping("/rateLimit")
        @SentinelResource(value = "rateLimit", blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerException")
        public String rateLimit() {
            return "rateLimit 按客户自定义处理";
        }

    }

}

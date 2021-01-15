package cas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: xianglong[1391086179@qq.com]
 * @date: 下午6:17 2021/1/15
 * @version: V1.0
 * @review:
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamConsumer8803Application {

    public static void main(String[] args) {
        SpringApplication.run(StreamConsumer8803Application.class, args);
    }

}

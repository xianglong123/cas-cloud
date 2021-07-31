package com.cas;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosProviderDemoApplication.class, args);
    }

    @RestController
    public class EchoController {

        @Value("${server.port}")
        private String port;

        public HashMap<Long, String> map = new HashMap<>();

        {
            map.put(1L, "d");
            map.put(2L, "e");
            map.put(3L, "f");
        }


        @GetMapping(value = "/get/{id}")
        public String echo(@PathVariable Long id) {
            return "Hello Nacos Discovery " + id + "- value -" + map.get(id) + " port:" + port;
        }
    }
}
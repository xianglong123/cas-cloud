package com.cas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosProviderDemoApplication.class, args);
    }

    @RestController
    public class EchoController {

        @GetMapping(value = "/echo/{string}")
        public String echo(@PathVariable String string) {
            return "Hello Nacos Discovery " + string;
        }

        @RequestMapping("/getName")
        public String getName(@RequestParam("uname") String uname) {
            return "hello " + uname + ", my port is 9001";
        }

        @RequestMapping("/sign")
        public String sign(@RequestBody User user) {
            return "hello " + user.getUname() + ", my port is 9001";
        }

    }


    public static class User{

        public User() {}

        private String uname;

        public String getUname() {
            return uname;
        }

        public void setUname(String uname) {
            this.uname = uname;
        }
    }
}
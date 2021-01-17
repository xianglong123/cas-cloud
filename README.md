# cas-cloud

### 环境
    技术模版：就是学习用的，如果需要用就直接拉取改改就能用。
    技术：springboot:2.2.1.RELEASE   +   springcloud:Hoxton.SR1   +    springcloud-alibaba:2.2.1.RELEASE
    
    环境：java8
    构建工具： gradle6.4.1
    仓库：https://maven.aliyun.com/repository/public/

    这个项目去掉了dao层，所有模块都能很简单的启动起来，很适合cloud初学者下载配合视频学习效果更佳，
    视频资源：https://www.bilibili.com/video/BV18E411x7eT?from=search&seid=3900752421887932066
---

### 模块总结
    springcloud模块：
    include 'cloud-provider-8001'
    include 'cloud-eureka-serve7001'
    include 'cloud-eureka-serve7002'
    include 'cloud-provider-8002'
    include 'cloud-consumer-8080'
    include 'cloud-consumer-feign-8080'
    include 'cloud-provider-hystrix-8001'
    include 'cloud-consumer-feign-hystrix-8080'
    include 'cloud-gateway-gateway9527'
    include 'cloud-config-center-3344'
    include 'cloud-config-client-3355'
    include 'cloud-stream-rabbitmq-provider-8801'
    include 'cloud-stream-rabbitmq-consumer-8802'
    include 'cloud-stream-rabbitmq-consumer-8803'
    
    
    springcloud-alibaba模块：
    include 'cloudalibaba-provider-9001'
    include 'cloudalibaba-consumer-nacos-8083'
    include 'cloudalibaba-config-nacos-client-3377'
    include 'cloudalibaba-sentinel-service-8401'
    include 'cloudalibaba-provider-nacos-9003'
    include 'cloudalibaba-consumer-feign-8084'
    
    项目里面已经下载有nacos和sentinel两个运行jar包，路径：项目根/static/zip/nacos  + 项目根/static/zip/sentinel
    附有启动脚本：
    nacos相关启动/停止脚本=========》项目根/static/zip/nacos_start.sh + 项目根/static/zip/nacos_stop.sh
    
    sentinel相关启动/停止脚本=======》项目根/static/zip/sentinel_start.sh + 项目根/static/zip/sentinel_stop.sh
    
    
    这里记录几个有用的官网：
    springcloud官网：https://spring.io/projects/spring-cloud
    nacos官网： https://nacos.io/zh-cn/docs/quick-start.html
    springcloud-alibaba中文文档： https://github.com/alibaba/spring-cloud-alibaba/blob/master/README-zh.md
---
  
### 鸣谢
    各位道友，涨薪加油。如果这个项目对你有一点点帮助，帮我点个start,满足一下小小的虚荣心。。。

---

package com.cas.service;

import cn.hutool.core.util.IdUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author: xianglong[1391086179@qq.com]
 * @date: 下午5:58 2021/1/15
 * @version: V1.0
 * @review:
 */
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider{

    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String uuid = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(uuid).build());
        System.out.println("***** uuid: " + uuid);
        return null;
    }
}

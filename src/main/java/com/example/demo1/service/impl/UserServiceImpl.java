package com.example.demo1.service.impl;


import com.example.demo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Override
    public String producer(){
        String message = UUID.randomUUID().toString().replaceAll("-","");
        ListenableFuture future = kafkaTemplate.send("app_log", message);
        future.addCallback(o -> System.out.println("send-消息发送成功：" + message),
        throwable -> System.out.println("消息发送失败：" + message));
        return message;
    }
}

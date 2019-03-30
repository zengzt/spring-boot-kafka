package com.example.demo1.kafkaconsumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class Consumer {
    //启动的时候就会一直去获取了
    @KafkaListener(topics = "app_log")
    public void consumer(ConsumerRecord<?, ?> record)throws Exception{
        System.out.printf("topic = %s, offset = %d, value = %s \n", record.topic(), record.offset(), record.value());
    }
}

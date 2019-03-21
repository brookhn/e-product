package com.pp.server.Listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class KafkaReceive {

    @KafkaListener(topics = "test")
    public void listen(ConsumerRecord<?, ?> record)
    {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent())
        {
            Object message = kafkaMessage.get();
            System.out.println("message ------:"+message);
            System.out.println("record ------:"+record);
        }
    }
}

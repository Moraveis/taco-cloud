package com.spring.action.tacocloud.consumer;

import com.spring.action.tacocloud.domain.TacoOrder;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderListener {

    @KafkaListener(topics = "tacocloud.orders.topic")
    public void handle(TacoOrder order) {
        log.info("Basic handler - Kafka received message={}", order);
    }

    @KafkaListener(topics = "tacocloud.orders.topic")
    public void handle(TacoOrder order, ConsumerRecord<String, TacoOrder> record) {
        log.info("ConsumerRecord handler - Received from partition {} with timestamp {}", record.partition(), record.timestamp());
    }

    @KafkaListener(topics = "tacocloud.orders.topic")
    public void handle(TacoOrder order, Message<TacoOrder> message) {
        MessageHeaders headers = message.getHeaders();
        log.info("Message handler - Received from partition {} with timestamp {}", headers.get(KafkaHeaders.RECEIVED_PARTITION_ID), headers.get(KafkaHeaders.RECEIVED_TIMESTAMP));
    }
}

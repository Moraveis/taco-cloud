package com.spring.action.tacocloud.producer;

import com.spring.action.tacocloud.domain.TacoOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaOrderMessageProducer implements OrderMessagingProducer {

    private final KafkaTemplate<String, TacoOrder> kafkaTemplate;

    @Override
    public void sendOrder(TacoOrder order) {
        kafkaTemplate.sendDefault(order);
    }
}

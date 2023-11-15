package com.spring.action.tacocloud.producer;

import com.spring.action.tacocloud.domain.TacoOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RabbitOrderMessagingProducer implements OrderMessagingProducer {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void sendOrder(TacoOrder order) {
        rabbitTemplate.convertAndSend("tacocloud.order", order);
    }
}

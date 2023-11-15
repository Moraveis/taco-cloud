package com.spring.action.tacocloud.consumer;

import com.spring.action.tacocloud.domain.TacoOrder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class RabbitOrderConsumer {

    private final RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "tacocloud.order.queue")
    public void receiveOrder(TacoOrder order) {
        log.info("RabbitOrderConsumer received message={}", order);
    }

}

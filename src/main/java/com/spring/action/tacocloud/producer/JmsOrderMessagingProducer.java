package com.spring.action.tacocloud.producer;

import com.spring.action.tacocloud.domain.TacoOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JmsOrderMessagingProducer implements OrderMessagingProducer {

    private final JmsTemplate jmsTemplate;
    // private final Destination destinationQueue;

    @Override
    public void sendOrder(TacoOrder order) {
        // jmsTemplate.send(destinationQueue, session -> session.createObjectMessage(order));
        jmsTemplate.convertAndSend("tacocloud.order.queue", order);
    }
}

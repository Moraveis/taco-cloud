package com.spring.action.tacocloud.service;

import com.spring.action.tacocloud.domain.TacoOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

@Service
@RequiredArgsConstructor
public class JmsOrderMessagingService implements OrderMessagingService {

    private final JmsTemplate jmsTemplate;
    // private final Destination destinationQueue;

    @Override
    public void sendOrder(TacoOrder order) {
        // jmsTemplate.send(destinationQueue, session -> session.createObjectMessage(order));
        jmsTemplate.convertAndSend("tacocloud.order.queue", order);
    }
}

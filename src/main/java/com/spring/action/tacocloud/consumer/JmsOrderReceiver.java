package com.spring.action.tacocloud.consumer;

import com.spring.action.tacocloud.domain.TacoOrder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

@Component
@RequiredArgsConstructor
@Slf4j
public class JmsOrderReceiver {

    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = "tacocloud.order.queue")
    public void receiveOrder(TacoOrder order) throws JMSException {
        log.info("Received message={}", order);
    }

}

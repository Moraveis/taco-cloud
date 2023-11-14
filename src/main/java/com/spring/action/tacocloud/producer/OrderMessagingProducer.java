package com.spring.action.tacocloud.producer;

import com.spring.action.tacocloud.domain.TacoOrder;

public interface OrderMessagingProducer {

    public void sendOrder(TacoOrder order);
}

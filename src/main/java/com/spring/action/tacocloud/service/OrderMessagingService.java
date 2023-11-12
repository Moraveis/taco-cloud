package com.spring.action.tacocloud.service;

import com.spring.action.tacocloud.domain.TacoOrder;

public interface OrderMessagingService {

    public void sendOrder(TacoOrder order);
}

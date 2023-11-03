package com.spring.action.tacocloud.repository;

import com.spring.action.tacocloud.domain.TacoOrder;

public interface OrderRepository {
    TacoOrder save(TacoOrder order);
}

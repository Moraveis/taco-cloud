package com.spring.action.tacocloud.repository;

import com.spring.action.tacocloud.domain.TacoOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OrderRepository extends CrudRepository<TacoOrder, UUID> {
}

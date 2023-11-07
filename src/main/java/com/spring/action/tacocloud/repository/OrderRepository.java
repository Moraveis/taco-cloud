package com.spring.action.tacocloud.repository;

import com.spring.action.tacocloud.domain.TacoOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<TacoOrder, Long> {
}

package com.spring.action.tacocloud.repository;

import com.spring.action.tacocloud.domain.Taco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacoRepository extends JpaRepository<Taco, Long> {
}

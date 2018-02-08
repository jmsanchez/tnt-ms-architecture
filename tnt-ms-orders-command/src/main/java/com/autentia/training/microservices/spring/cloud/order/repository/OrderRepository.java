package com.autentia.training.microservices.spring.cloud.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.autentia.training.microservices.spring.cloud.order.domain.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}

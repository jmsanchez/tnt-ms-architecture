package com.autentia.training.microservices.spring.cloud.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;

import com.autentia.training.microservices.spring.cloud.event.OrderCreationEvent;
import com.autentia.training.microservices.spring.cloud.order.domain.Order;
import com.autentia.training.microservices.spring.cloud.order.domain.OrderLine;
import com.autentia.training.microservices.spring.cloud.order.repository.OrderRepository;
import com.autentia.training.microservices.spring.cloud.order.vo.OrderResource;
import com.esotericsoftware.minlog.Log;

import lombok.extern.slf4j.Slf4j;

@Transactional
@Slf4j
public class OrderResourceService {

	private OrderRepository orderRepository;
	
	private Source pipe;
	
	public OrderResourceService(OrderRepository orderRepository, Source pipe) {
		this.orderRepository = orderRepository;
		this.pipe = pipe;
	}

	public Order create(OrderResource orderResource) {
		log.info("creating new order {}", orderResource);
		final Order orderCreated = orderRepository.save(mapOrder(orderResource));
		pipe.output().send(MessageBuilder.withPayload(OrderCreationEvent.builder().id(orderCreated.getId()).createdAt(orderCreated.getCreatedAt()).lines(orderResource.getLines()).build()).build());
		return orderCreated;
	}

	private Order mapOrder(OrderResource orderResource) {
		final List<OrderLine> lines = orderResource.getLines().stream()
				.map(line -> OrderLine.builder().build())
				.collect(Collectors.toList());
		return Order.builder().createdAt(LocalDateTime.now()).lines(lines).build();
	}
	
}

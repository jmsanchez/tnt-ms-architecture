package com.autentia.training.microservices.spring.cloud.order.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.autentia.training.microservices.spring.cloud.order.domain.Order;
import com.autentia.training.microservices.spring.cloud.order.repository.OrderRepository;
import com.autentia.training.microservices.spring.cloud.order.vo.OrderLineResource;
import com.autentia.training.microservices.spring.cloud.order.vo.OrderResource;

@RestController
public class OrderController {

	@Autowired
	private OrderRepository productRepository;
	
	@GetMapping("")
	public List<OrderResource> findAll() {
		return this.productRepository.findAll().stream().map(order -> mapToRessource(order))
				.collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public OrderResource findById(@PathVariable(name="id") long id) {
		return mapToRessource(this.productRepository.findOne(id));
	}

	private OrderResource mapToRessource(Order order) {
		
		final List<OrderLineResource> lines = order.getLines().stream()
				.map(line -> OrderLineResource.builder().orderLine(line).build())
				.collect(Collectors.toList());
		
		final OrderResource result = OrderResource.builder().orderId(order.getId()).createdAt(order.getCreatedAt()).lines(lines).build();
		return result;
	}

}

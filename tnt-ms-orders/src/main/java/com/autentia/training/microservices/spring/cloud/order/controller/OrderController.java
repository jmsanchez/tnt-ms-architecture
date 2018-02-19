package com.autentia.training.microservices.spring.cloud.order.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.autentia.training.microservices.spring.cloud.order.domain.Order;
import com.autentia.training.microservices.spring.cloud.order.repository.OrderRepository;
import com.autentia.training.microservices.spring.cloud.order.vo.OrderLineResource;
import com.autentia.training.microservices.spring.cloud.order.vo.OrderResource;
import com.autentia.training.microservices.spring.cloud.product.consumer.ProductConsumer;

@RestController
public class OrderController {

	@Autowired
	private OrderRepository productRepository;
	
	@Autowired
	private ProductConsumer productConsumer;

	@GetMapping("")
	public List<OrderResource> findAll() {
		return this.productRepository.findAll().stream().map(order -> mapOrderResource(order))
				.collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public OrderResource findById(@PathVariable(name="id") long id) {
		return mapOrderResource(this.productRepository.findById(id).get());
	}

	private OrderResource mapOrderResource(Order order) {
		final List<OrderLineResource> lines = order.getLines().stream()
				.map(line -> OrderLineResource.builder().product(productConsumer.findById(line.getProductId())).price(line.getPrice()).quantity(line.getQuantity()).build())
				.collect(Collectors.toList());
		return OrderResource.builder().id(order.getId()).createdAt(order.getCreatedAt()).lines(lines).build();
	}

}

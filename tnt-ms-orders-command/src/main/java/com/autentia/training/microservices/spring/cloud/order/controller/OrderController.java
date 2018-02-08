package com.autentia.training.microservices.spring.cloud.order.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.autentia.training.microservices.spring.cloud.order.domain.Order;
import com.autentia.training.microservices.spring.cloud.order.vo.OrderResource;
import com.autentia.training.microservices.spring.cloud.service.OrderResourceService;

@RestController
public class OrderController {

	@Autowired
	private OrderResourceService orderResourceService;
	
	@PostMapping("orders")
	public ResponseEntity<Void> create(@RequestBody OrderResource orderResource) {
		final Order order = orderResourceService.create(orderResource);
		final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{id}").buildAndExpand(order.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

}

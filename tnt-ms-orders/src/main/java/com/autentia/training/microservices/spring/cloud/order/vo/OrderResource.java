package com.autentia.training.microservices.spring.cloud.order.vo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import com.autentia.training.microservices.spring.cloud.order.controller.OrderController;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class OrderResource extends ResourceSupport{

	private Long orderId;
	
	private LocalDateTime createdAt;

	private List<OrderLineResource> lines;
	
	@Builder
	public OrderResource(Long orderId, LocalDateTime createdAt, List<OrderLineResource> lines) {
		super();
		this.orderId = orderId;
		this.createdAt = createdAt;
		this.lines = lines;
		add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(OrderController.class).findById(orderId)).withSelfRel());
	}

}

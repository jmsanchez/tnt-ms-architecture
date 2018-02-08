package com.autentia.training.microservices.spring.cloud.order.vo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Builder;

@Builder
public class OrderResource {

	private Long id;
	
	private LocalDateTime createdAt;

	@Builder.Default
	private List<OrderLineResource> lines = new ArrayList<OrderLineResource>();
	
	public Long getId() {
		return this.id;
	}
	
	public LocalDateTime getCreatedAt() {
		return this.createdAt;
	}

	public List<OrderLineResource> getLines() {
		return lines;
	}
}

package com.autentia.training.microservices.spring.cloud.event;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.autentia.training.microservices.spring.cloud.order.vo.OrderLineResource;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class OrderCreationEvent implements Serializable{

	private Long id;
	
	private LocalDateTime createdAt;
	
	private List<OrderLineResource> lines;
	
}

package com.autentia.training.microservices.spring.cloud.order.vo;

import java.math.BigDecimal;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import com.autentia.training.microservices.spring.cloud.order.domain.OrderLine;

import lombok.Builder;
import lombok.Getter;

@Getter
public class OrderLineResource extends ResourceSupport{

	private Long orderLineId;
	
	private Long productId;

	private Long quantity;
	
	private BigDecimal price;

	@Builder
	public OrderLineResource(OrderLine orderLine){
		this.orderLineId = orderLine.getId();
		this.productId = orderLine.getProductId();
		this.quantity = orderLine.getQuantity();
		this.price = orderLine.getPrice();
		this.add(new Link("/products/"+orderLine.getProductId(), "product"));
	}

}

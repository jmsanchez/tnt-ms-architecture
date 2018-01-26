package com.autentia.training.microservices.spring.cloud.order.vo;

import java.math.BigDecimal;

import com.autentia.training.microservices.spring.cloud.product.domain.Product;

import lombok.Builder;

@Builder
public class OrderLineResource {

	private Product product;

	private Long quantity;
	
	private BigDecimal price;
	
	public Product getProduct() {
		return this.product;
	}
	
	public Long getQuantity() {
		return quantity;
	}
	
	public BigDecimal getPrice() {
		return price;
	}

}

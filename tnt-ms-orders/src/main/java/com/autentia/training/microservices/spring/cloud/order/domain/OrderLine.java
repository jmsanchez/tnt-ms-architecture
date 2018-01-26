package com.autentia.training.microservices.spring.cloud.order.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name="order_line")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderLine {

	@Id
	private Long id;
	
	@Column(name="product_id")
	private Long productId;

	@ManyToOne
	private Order order;
	
	@Column
	private Long quantity;
	
	@Column
	private BigDecimal price;
	
	public Long getId() {
		return this.id;
	}
	
	public Long getProductId() {
		return this.productId;
	}
	
	public Long getQuantity() {
		return quantity;
	}
	
	public BigDecimal getPrice() {
		return price;
	}

}

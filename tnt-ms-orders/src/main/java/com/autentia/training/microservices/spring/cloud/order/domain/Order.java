package com.autentia.training.microservices.spring.cloud.order.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {

	@Id
	private Long id;
	
	@Column
	private LocalDateTime createdAt;

	@OneToMany(mappedBy="order")
	private List<OrderLine> lines;
	
	public Long getId() {
		return this.id;
	}
	
	public LocalDateTime getCreatedAt() {
		return this.createdAt;
	}

	public List<OrderLine> getLines() {
		return lines;
	}
}

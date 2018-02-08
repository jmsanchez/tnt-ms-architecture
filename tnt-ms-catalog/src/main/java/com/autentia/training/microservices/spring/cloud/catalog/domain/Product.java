package com.autentia.training.microservices.spring.cloud.catalog.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	private Integer code;
	
	@Column
	private String ean;

	@Column
	private String name;

	@Column
	private String description;
	

	@Column
	private Long quantity;

	public Integer getCode() {
		return this.code;
	}
	
	public String getEan() {
		return this.ean;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}
	
	public Long getQuantity() {
		return quantity;
	}

}

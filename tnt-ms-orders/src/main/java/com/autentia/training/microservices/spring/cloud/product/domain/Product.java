package com.autentia.training.microservices.spring.cloud.product.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	private Integer code;
	
	private String ean;

	private String name;

	public Integer getCode() {
		return this.code;
	}
	
	public String getEan() {
		return this.ean;
	}

	public String getName() {
		return this.name;
	}

}

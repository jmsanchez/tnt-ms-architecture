package com.autentia.training.microservices.spring.cloud.catalog.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;

@Document
@Builder
public class Product {

	@Id
	private Integer code;
	
	private String ean;

	private String name;

	private String description;

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

}

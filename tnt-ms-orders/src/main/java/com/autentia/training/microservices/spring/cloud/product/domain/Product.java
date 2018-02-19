package com.autentia.training.microservices.spring.cloud.product.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Product {

	private Integer code;
	
	private String ean;

	private String name;


}

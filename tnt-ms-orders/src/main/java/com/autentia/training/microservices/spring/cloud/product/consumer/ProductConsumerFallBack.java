package com.autentia.training.microservices.spring.cloud.product.consumer;

import com.autentia.training.microservices.spring.cloud.product.domain.Product;

public class ProductConsumerFallBack implements ProductConsumer{

	@Override
	public Product findById(Integer id) {
		return Product.builder().code(id).ean("NOT_AVAILABLE").name("NOT_AVAILABLE").build();
	}

}

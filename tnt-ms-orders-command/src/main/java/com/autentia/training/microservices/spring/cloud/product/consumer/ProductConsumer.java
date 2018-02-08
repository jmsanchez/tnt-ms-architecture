package com.autentia.training.microservices.spring.cloud.product.consumer;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.autentia.training.microservices.spring.cloud.product.domain.Product;


@FeignClient(name="tnt-ms-catalog" , fallback=ProductConsumerFallBack.class)
public interface ProductConsumer {

	  @GetMapping("/products/{id}")
	  Product findById(@PathVariable(name="id") Integer id);
	  
}

package com.autentia.training.microservices.spring.cloud.catalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.autentia.training.microservices.spring.cloud.catalog.domain.Product;
import com.autentia.training.microservices.spring.cloud.catalog.repository.ProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@RestController
public class ProductController {

  @Autowired
  private DiscoveryClient discoveryClient;
  
  @Autowired
  private ProductRepository repository;


  @GetMapping("/products")
  public Flux<Product> findAll() {
    return this.repository.findAll();
  }
  
  @GetMapping("/products/{id}")
  public Mono<Product> findById(@PathVariable Integer id) {
		return repository.findById(id)
				.map(p -> Product.builder().code(p.getCode()).description(p.getDescription()).ean(p.getEan()).name(p.getEan()).build());
  }
  
}

package com.autentia.training.microservices.spring.cloud.catalog.controller;

import java.util.List;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.autentia.training.microservices.spring.cloud.catalog.domain.Product;
import com.autentia.training.microservices.spring.cloud.catalog.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;



@RestController
@Slf4j
public class ProductController {

  private static final Marker BUSINESS = MarkerFactory.getMarker("BUSINESS");
	
  @Autowired
  private ProductRepository productRepository;


  @GetMapping("/products")
  public List<Product> findAll() {
	log.debug(BUSINESS, "Someone has executed a search command");
    return this.productRepository.findAll();
  }
  
  @GetMapping("/products/{id}")
  public Product findById(@PathVariable Integer id) {
	log.debug(BUSINESS, "Someone has lookup the product #{0}", id);
    return this.productRepository.findOne(id);
  }

}

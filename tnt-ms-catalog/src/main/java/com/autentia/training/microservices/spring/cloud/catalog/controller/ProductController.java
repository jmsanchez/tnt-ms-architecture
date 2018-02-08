package com.autentia.training.microservices.spring.cloud.catalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.autentia.training.microservices.spring.cloud.catalog.domain.Product;
import com.autentia.training.microservices.spring.cloud.catalog.repository.ProductRepository;



@RestController
public class ProductController {

  @Autowired
  private ProductRepository productRepository;


  @GetMapping("/products")
  public List<Product> findAll() {
    return this.productRepository.findAll();
  }
  
  @GetMapping("/products/{id}")
  public Product findById(@PathVariable Integer id) {
    return this.productRepository.findOne(id);
  }

}

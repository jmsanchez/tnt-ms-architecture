package com.autentia.training.microservices.spring.cloud.catalog.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.autentia.training.microservices.spring.cloud.catalog.domain.Product;


@Repository
public interface ProductRepository extends ReactiveCrudRepository<Product, Integer> {
}

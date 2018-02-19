package com.autentia.training.microservices.spring.cloud.catalog;

import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.autentia.training.microservices.spring.cloud.catalog.domain.Product;
import com.autentia.training.microservices.spring.cloud.catalog.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ProductsDataLoader implements CommandLineRunner {


    private ProductRepository repository;

    ProductsDataLoader(final ProductRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public void run(final String... args) throws Exception {
    		log.info("Repository contains {} entries.", repository.count().block());
    		if (repository.count().block() != 0L) {
    			return;
    		}
    		int max = 100000;
    		log.info("Loading {} entries.", max);
    		IntStream.range(0, max).parallel().forEach( i -> {
    			log.info("persisting {}", i);
    			repository.save(Product.builder().code(i).description("Product #" + i).ean("000000"+i).name("Product #" + i).build()).block();
    		});
        log.info("Repository contains now {} entries.", repository.count().block());
    }
    
}

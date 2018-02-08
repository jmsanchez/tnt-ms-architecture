package com.autentia.training.microservices.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.autentia.training.microservices.spring.cloud.event.OrderCreationEvent;
import com.autentia.training.microservices.spring.cloud.product.consumer.ProductConsumerFallBack;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients
@Configuration
@EnableBinding(Sink.class)
@Slf4j
public class OrdersApplication {
  public static void main(String[] args) {
    SpringApplication.run(OrdersApplication.class, args);
  }
  
  @Bean
  public ProductConsumerFallBack productConsumerFallBack(){
	  return new ProductConsumerFallBack();
  }
  
	@StreamListener(Processor.INPUT)
	public void transform(OrderCreationEvent playload) {
		log.info("order received {}", playload.getId());
	}

}

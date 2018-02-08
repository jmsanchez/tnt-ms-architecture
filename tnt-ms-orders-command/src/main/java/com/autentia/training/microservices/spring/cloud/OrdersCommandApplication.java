package com.autentia.training.microservices.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.autentia.training.microservices.spring.cloud.order.repository.OrderRepository;
import com.autentia.training.microservices.spring.cloud.product.consumer.ProductConsumerFallBack;
import com.autentia.training.microservices.spring.cloud.service.OrderResourceService;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients
@Configuration
@EnableBinding(Processor.class)
public class OrdersCommandApplication {
  public static void main(String[] args) {
    SpringApplication.run(OrdersCommandApplication.class, args);
  }
  
  @Bean
  public ProductConsumerFallBack productConsumerFallBack(){
	  return new ProductConsumerFallBack();
  }
  
  @Bean
  public OrderResourceService orderService(OrderRepository orderRepository, Source pipe){
	  return new OrderResourceService(orderRepository, pipe);
  }
  
}

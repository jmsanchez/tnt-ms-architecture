package com.autentia.training.microservices.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.autentia.training.microservices.spring.cloud.product.consumer.ProductConsumerFallBack;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableFeignClients
@Configuration
public class OrdersApplication {
  public static void main(String[] args) {
    SpringApplication.run(OrdersApplication.class, args);
  }
  
  @Bean
  public ProductConsumerFallBack productConsumerFallBack(){
	  return new ProductConsumerFallBack();
  }
  
}
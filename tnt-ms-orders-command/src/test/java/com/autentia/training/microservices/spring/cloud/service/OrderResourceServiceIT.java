package com.autentia.training.microservices.spring.cloud.service;


import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.BlockingQueue;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.Message;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.autentia.training.microservices.spring.cloud.OrdersCommandApplication;
import com.autentia.training.microservices.spring.cloud.event.OrderCreationEvent;
import com.autentia.training.microservices.spring.cloud.order.domain.Order;
import com.autentia.training.microservices.spring.cloud.order.vo.OrderResource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = OrdersCommandApplication.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
@DirtiesContext
@ActiveProfiles("development")
public class OrderResourceServiceIT {

	@Autowired
	private Processor channels;

	@Autowired
	private MessageCollector collector;
	
	@Autowired
	private OrderResourceService orderService;
	
	@Test
	public void shouldPropagateOrderCreationEvents() {
		
		// given
		final BlockingQueue<Message<?>> messages = this.collector.forChannel(channels.output());

		// when
		final Order order = orderService.create(OrderResource.builder().build());
		
		// then
		assertThat(messages, Matchers.hasSize(1));
		
		assertTrue(messages.stream().filter(o -> ( (OrderCreationEvent) o.getPayload()).getId() == order.getId()).findFirst().isPresent());
		
	}
	
}

package com.autentia.training.microservices.spring.cloud.service;


import static org.awaitility.Awaitility.await;
import static org.hamcrest.CoreMatchers.containsString;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.autentia.training.microservices.spring.cloud.OrdersApplication;
import com.autentia.training.microservices.spring.cloud.event.OrderCreationEvent;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = OrdersApplication.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
@DirtiesContext
@ActiveProfiles("development")
public class OrderCreationEventIT {

    @Rule
    public OutputCapture capture = new OutputCapture();
    
	@Autowired
	private Sink channels;

    @Before
    public void setup() {
        capture.flush();
    }
    
	@Test
	public void shouldConsumeOrderCreationEvents() {
		
		// when
		channels.input().send(MessageBuilder.withPayload(OrderCreationEvent.builder().id(1L).createdAt(LocalDateTime.now()).build()).build());
		
		// then
        await().atMost(10, TimeUnit.SECONDS).until(getCapturedContentAsString(), containsString("order received 1"));
		
	}
	
    private Callable<String> getCapturedContentAsString() {
        return new Callable<String>() {
            public String call() throws Exception {
                return capture.toString();
            }
        };
    }
    
	
}

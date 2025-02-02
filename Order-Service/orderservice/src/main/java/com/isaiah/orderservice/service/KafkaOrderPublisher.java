/**
 * This is the class responsible for serializing our order objects and publishing them to the Kafka server
 * Topic: orders
 */

package com.isaiah.orderservice.service;

import com.isaiah.common.models.Order;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class KafkaOrderPublisher {

	
	
	/*
	 * This template is how we can talk to our kafka server
	 */
	
	@Autowired
	private KafkaTemplate<String, Object> template;
	
	
	public void sendOrderToTopic(Order order) {
		CompletableFuture<SendResult<String, Object>> future = template.send("order-topic", order);
		future.whenComplete((result, ex) -> {
			if(ex == null) {
				System.out.println("Sent Order=[" + order + "] with offset=[" + result.getRecordMetadata().offset() + "]");
			} else {
				System.out.println("Unable to send message=[" + order + "] due to: " + ex.getMessage());
			}
		});
	}
}

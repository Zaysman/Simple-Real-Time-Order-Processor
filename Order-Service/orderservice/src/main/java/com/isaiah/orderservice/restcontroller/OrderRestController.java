package com.isaiah.orderservice.restcontroller;

//Import Order object from common module
import com.isaiah.common.models.Order;

import com.isaiah.orderservice.service.KafkaOrderPublisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderRestController {
	
	@Autowired
	private KafkaOrderPublisher publisher;
	
	@PostMapping("/publish")
	public ResponseEntity<?> publishOrder(@RequestBody Order order) {
		try {
			publisher.sendOrderToTopic(order);
			return ResponseEntity.ok("Message published successfully...");
			
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}

package com.isaiah.paymentservice.service;

import com.isaiah.common.models.Order;
import com.isaiah.common.models.Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderListener {
	
	@Autowired
	private PaymentPublisher paymentPublisher;
	
	@KafkaListener(topics = "orders", groupId = "order-consumer")
	public void consumeCustomer(Order order) {
		System.out.println("Order-Consumer consumes the following Order: [" + order.toString() + "]");
		Payment payment = new Payment(8675309, order.getCustomer(), order.getPrice());
		paymentPublisher.sendPaymentToTopic(payment);
	}

}

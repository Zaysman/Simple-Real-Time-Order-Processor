package com.isaiah.notificationservice.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.isaiah.common.models.Payment;


@Service
public class PaymentListener {

	@KafkaListener(topics = "payments", groupId = "payment-consumer")
	public void consumePayment(Payment payment) {
		System.out.println("Payment-Consumer consumes the following payment=[" + payment + "]");
		
	}
}

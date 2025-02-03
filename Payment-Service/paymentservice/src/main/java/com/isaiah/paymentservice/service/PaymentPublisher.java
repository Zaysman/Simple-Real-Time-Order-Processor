package com.isaiah.paymentservice.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.isaiah.common.models.Payment;

@Service
public class PaymentPublisher {
	
	
	@Autowired
	private KafkaTemplate<String, Payment> template;
	
	
	public void sendPaymentToTopic(Payment payment) {
		CompletableFuture<SendResult<String, Payment>> future = template.send("payments", payment);
		future.whenComplete((result, ex) -> {
			if(ex == null) {
				System.out.println("Sent Payment=[" + payment + "] with offset =[" + result.getRecordMetadata().offset() + "]");
			} else {
				System.out.println("Unable to send payment=[" + payment + "] due to: " + ex.getMessage());
			}
		});
	}
	
}

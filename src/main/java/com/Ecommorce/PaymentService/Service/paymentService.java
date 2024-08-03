package com.Ecommorce.PaymentService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommorce.PaymentService.PaymentGateway.PaymentGatewayAdapter;


public interface paymentService {


	public 	String createPayment(long orderId,long amount) throws Exception;
	
}

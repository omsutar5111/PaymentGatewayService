package com.Ecommorce.PaymentService.PaymentGateway;

import org.springframework.stereotype.Component;

@Component
public class RazorpayAdapter implements PaymentGatewayAdapter {

	@Override
	public String createPaymentLink(long orderId, long amount) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}

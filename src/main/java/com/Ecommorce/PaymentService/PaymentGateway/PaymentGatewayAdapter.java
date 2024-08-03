package com.Ecommorce.PaymentService.PaymentGateway;

public interface PaymentGatewayAdapter  {

	 public String createPaymentLink(long orderId, long amount) throws Exception;
	 
}

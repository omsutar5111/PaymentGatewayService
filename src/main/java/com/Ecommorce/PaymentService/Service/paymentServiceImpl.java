package com.Ecommorce.PaymentService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommorce.PaymentService.PaymentGateway.PaymentGatewayAdapter;

@Service
public class paymentServiceImpl implements paymentService  {
  PaymentGatewayAdapter paymentGatewayAdaopter;
  @Autowired
  public paymentServiceImpl(PaymentGatewayAdapter paymentGatewayAdapter) {
	  this.paymentGatewayAdaopter=paymentGatewayAdapter;
  }
	
	@Override
	public String createPayment(long orderId, long amount)throws Exception {
		// TODO Auto-generated method stub
		return paymentGatewayAdaopter.createPaymentLink(orderId, amount) ;
	}

}

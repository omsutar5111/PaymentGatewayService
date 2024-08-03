package com.Ecommorce.PaymentService.Controller;

import com.Ecommorce.PaymentService.Dtos.RequestPaymentDto;
import com.Ecommorce.PaymentService.Service.paymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
     paymentService service;
	 @Autowired
	 public PaymentController(paymentService service){
		 this.service=service;
	 }
	@PostMapping()
	public ResponseEntity<String> paymentLink(@RequestBody RequestPaymentDto requestPaymentDto){

		 try {
			 String url= service.createPayment(requestPaymentDto.getOrderId(),requestPaymentDto.getAmount());
           return  new ResponseEntity<>(url, HttpStatus.OK);
		 }
		catch (Exception e){
			return null;
		}
	}
}

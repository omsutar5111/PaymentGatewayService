package com.Ecommorce.PaymentService.Dtos;

import lombok.Data;

@Data
public class RequestPaymentDto {
  Long orderId;
  Long amount;
}

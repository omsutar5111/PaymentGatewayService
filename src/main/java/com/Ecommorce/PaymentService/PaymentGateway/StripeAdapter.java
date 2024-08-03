package com.Ecommorce.PaymentService.PaymentGateway;

import com.stripe.Stripe;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PaymentLinkCreateParams.SubmitType;
import com.stripe.param.PriceCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class StripeAdapter implements PaymentGatewayAdapter {
//   @Value("${stripe_api_key}")
	private  String secretKey="sk_test_51PjkFAP8GATQRGYgVcOWD1CvkznKZnlUOviNgFzNg4ChJtzwcWBddJoG1hBb419PjhyMK0xZXWz581vdxcs2kipz00y5jTCCCn";


	@Override
	public String createPaymentLink(long orderId, long amount) throws Exception {
		// TODO Auto-generated method stub
		Stripe.apiKey = secretKey;

		PriceCreateParams params =
				PriceCreateParams.builder()
						.setCurrency("inr")
						.setUnitAmount(amount*100)
//						.setRecurring(
//								PriceCreateParams.Recurring.builder()
//										.setInterval(PriceCreateParams.Recurring.Interval.MONTH)
//										.build()
//						)
						.setProductData(
								PriceCreateParams.ProductData.builder().setName("Mobile").build()
						)
						.build();

		Price price = Price.create(params);
		String priceId=price.getId();
//		Stripe.apiKey = "sk_test_51PjkFAP8GATQRGYgVcOWD1CvkznKZnlUOviNgFzNg4ChJtzwcWBddJoG1hBb419PjhyMK0xZXWz581vdxcs2kipz00y5jTCCCn";

		 PaymentLinkCreateParams paymentLinkparams =
	                PaymentLinkCreateParams.builder()
	                        .addLineItem(
	                                PaymentLinkCreateParams.LineItem.builder()
	                                        .setPrice(priceId)
	                                        .setQuantity(1L)
	                                        .build()
	                        )
	                        .setAfterCompletion(PaymentLinkCreateParams.AfterCompletion.builder()
	                                .setRedirect(
	                                        PaymentLinkCreateParams.AfterCompletion.Redirect.builder()
	                                        .setUrl("https://scaler.com")
	                                        .build()
	                                )
	                                .setType(PaymentLinkCreateParams.AfterCompletion.Type.REDIRECT)
	                                .build()
	                        )
	                        .build();
	        PaymentLink paymentLink = PaymentLink.create(paymentLinkparams);
	        return paymentLink.getUrl();
	}

}

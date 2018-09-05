package br.com.zup.camunda.application.integration.feign.payment;

import br.com.zup.camunda.application.domain.PaymentRequest;
import br.com.zup.camunda.application.domain.PaymentResponse;
import feign.Headers;
import feign.RequestLine;

public interface PaymentApi {
    @RequestLine("POST /payment")
    @Headers("Content-Type: application/json")
    PaymentResponse payment(PaymentRequest request);
}

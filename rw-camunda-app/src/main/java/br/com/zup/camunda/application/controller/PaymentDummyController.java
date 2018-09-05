package br.com.zup.camunda.application.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.camunda.application.domain.PaymentRequest;
import br.com.zup.camunda.application.domain.PaymentResponse;

@RestController
@RequestMapping("/payment")
public class PaymentDummyController {

    private static Logger logger = LoggerFactory.getLogger(PaymentDummyController.class);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PaymentResponse pay(@Valid @RequestBody PaymentRequest request) {
        logger.info("Paying customer: " + request.getCustomerId() +
                " externalId: " + request.getExternalId() +
                " amount: " + request.getAmount());

        PaymentResponse response = new PaymentResponse();
        response.setRequestId(UUID.randomUUID().toString());
        return response;
    }
}

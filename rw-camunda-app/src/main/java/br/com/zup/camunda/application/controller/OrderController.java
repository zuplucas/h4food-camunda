package br.com.zup.camunda.application.controller;


import java.math.BigDecimal;

import javax.validation.Valid;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.MessageCorrelationResult;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.variable.Variables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.camunda.application.Constants;
import br.com.zup.camunda.application.domain.CreateOrderRequest;

@RestController
@RequestMapping("/order")
public class OrderController {

    private static Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private RuntimeService runtimeService;

    @PostMapping()
    public String createOrder(@Valid @RequestBody CreateOrderRequest request) {
        logger.info("Creating order: " + request.getCustomerId() + " - " + request.getAmount());
        ProcessInstance processInstance = createProcess(request.getCustomerId(), request.getAmount());
        return processInstance.getId();
    }

    @GetMapping("/callback")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void callback(@RequestParam("instanceId") String instanceId) {
        logger.info("Callback for: " + instanceId);
        runtimeService.createMessageCorrelation("callback_" + instanceId)
                .processInstanceId(instanceId)
                .correlateWithResult();
    }

    private ProcessInstance createProcess(String customerId, BigDecimal amount) {
        return runtimeService.startProcessInstanceByKey(
                Constants.ProcessKey.ORDER.getKey(),
                Variables
                        .putValue(Constants.VarName.CUSTOMER_ID.getName(), customerId)
                        .putValue(Constants.VarName.AMOUNT.getName(), amount.doubleValue()));
    }
}

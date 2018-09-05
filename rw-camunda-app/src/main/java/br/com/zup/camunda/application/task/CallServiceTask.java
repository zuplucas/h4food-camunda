package br.com.zup.camunda.application.task;

import java.math.BigDecimal;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.zup.camunda.application.domain.PaymentRequest;
import br.com.zup.camunda.application.domain.PaymentResponse;
import br.com.zup.camunda.application.integration.feign.payment.PaymentApi;

@Component
public class CallServiceTask extends BaseTask implements JavaDelegate {

    private static Logger logger = LoggerFactory.getLogger(CallServiceTask.class);

    private PaymentApi paymentApi;

    @Autowired
    public CallServiceTask(PaymentApi paymentApi) {
        this.paymentApi = paymentApi;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) {
        PaymentRequest request = new PaymentRequest();
        request.setCustomerId(getCustomerId(delegateExecution));
        request.setAmount(new BigDecimal(getAmount(delegateExecution)));
        request.setExternalId(delegateExecution.getProcessInstanceId());
        PaymentResponse response = paymentApi.payment(request);

        logger.info("Payment sent: " + response.getRequestId());
    }
}

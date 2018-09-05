package br.com.zup.camunda.application.task;

import java.math.BigDecimal;

import org.camunda.bpm.engine.delegate.DelegateExecution;

import br.com.zup.camunda.application.Constants;

public abstract class BaseTask {

    protected String getCustomerId(DelegateExecution delegateExecution) {
        return (String)delegateExecution.getVariable(Constants.VarName.CUSTOMER_ID.getName());
    }

    protected Double getAmount(DelegateExecution delegateExecution) {
        return (Double) delegateExecution.getVariable(Constants.VarName.AMOUNT.getName());
    }
}

package br.com.zup.camunda.application.domain;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

public class CreateOrderRequest {
    @NotNull
    private String customerId;
    @NotNull
    private BigDecimal amount;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}

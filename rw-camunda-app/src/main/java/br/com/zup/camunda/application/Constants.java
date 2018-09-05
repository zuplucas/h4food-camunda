package br.com.zup.camunda.application;

public class Constants {
    public enum ProcessKey {
        ORDER("order");

        String key;

        ProcessKey(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }
    }

    public enum VarName {
        CUSTOMER_ID("customerId"),
        AMOUNT("amount"),
        NEED_PAYMENT("needPayment");

        String name;

        VarName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

}

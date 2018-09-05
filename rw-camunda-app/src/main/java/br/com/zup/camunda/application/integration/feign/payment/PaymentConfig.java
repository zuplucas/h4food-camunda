package br.com.zup.camunda.application.integration.feign.payment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.zup.camunda.application.conf.ObjectMapperUtils;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

@Configuration
public class PaymentConfig {

    @Bean
    public PaymentApi paymentApi() {
        return Feign.builder()
                .encoder(new JacksonEncoder(ObjectMapperUtils.getObjectMapper()))
                .decoder(new JacksonDecoder(ObjectMapperUtils.getObjectMapper()))
                .logLevel(feign.Logger.Level.FULL)
                .target(PaymentApi.class, "http://localhost:8080");

    }


}

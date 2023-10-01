package com.laptrinhjavaweb.config;

import com.laptrinhjavaweb.payment.PaymentGateway;
import com.laptrinhjavaweb.payment.nganluong.Client;
import com.laptrinhjavaweb.payment.nganluong.Config;
import com.laptrinhjavaweb.payment.nganluong.PaymentGatewayImpl;
import com.laptrinhjavaweb.payment.nganluong.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentConfig {
    @Autowired
    Config config;

    @Bean
    public Client client() {
        return new Client();
    }

    @Bean
    public PaymentGateway<ResponseData> paymentGatewayNganLuong(@Autowired Client client) {
        return new PaymentGatewayImpl<ResponseData>(this.config, client);
    }
}

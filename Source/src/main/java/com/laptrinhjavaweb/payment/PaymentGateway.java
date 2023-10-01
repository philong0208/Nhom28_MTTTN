package com.laptrinhjavaweb.payment;

import com.laptrinhjavaweb.payment.model.PaymentResponse;

import java.util.Map;

public interface PaymentGateway<T> {
    T purchase(Map<String, String> data);
    PaymentResponse queryDR(Map<String, String> data, String clientId) throws Exception;
    String refundOrder(Map<String, String> data, String clientId);
}

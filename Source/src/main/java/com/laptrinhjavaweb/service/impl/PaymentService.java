package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.dto.PaymentRequestDTO;
import com.laptrinhjavaweb.payment.PaymentGateway;
import com.laptrinhjavaweb.payment.model.PaymentRequest;
import com.laptrinhjavaweb.payment.nganluong.ResponseData;
import com.laptrinhjavaweb.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PaymentService implements IPaymentService {

    @Autowired
    private PaymentGateway<ResponseData> paymentGatewayNganLuong;

    public Map mapPay(PaymentRequest p) {
        Map data = new HashMap<>();
        data.put("payment_method", p.getPaymentMethod());
        data.put("bank_code", p.getBankCode());
        data.put("buyer_fullname", p.getBuyerFullname());
        data.put("buyer_email", p.getBuyerEmail());
        data.put("buyer_mobile", p.getBuyerMobile());
        data.put("order_code", p.getOrderId());
        data.put("total_amount", p.getTotalAmount());
        return data;
    }

    @Override
    public ResponseData createPayment(PaymentRequestDTO request) {
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        request.setOrderId(uuidAsString);
        ResponseData rs = paymentGatewayNganLuong.purchase(this.mapPay(request));
        System.out.println(rs.getCheckout_url());
        return rs;
    }
}

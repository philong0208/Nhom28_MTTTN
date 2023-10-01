package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.PaymentRequestDTO;
import com.laptrinhjavaweb.payment.nganluong.ResponseData;

public interface IPaymentService {
    ResponseData createPayment(PaymentRequestDTO request);
}

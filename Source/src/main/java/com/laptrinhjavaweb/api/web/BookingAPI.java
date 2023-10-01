package com.laptrinhjavaweb.api.web;

import com.laptrinhjavaweb.dto.PaymentRequestDTO;
import com.laptrinhjavaweb.payment.nganluong.ResponseData;
import com.laptrinhjavaweb.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/booking/payment")
public class BookingAPI {
    @Autowired
    private IPaymentService paymentService;

    @PostMapping
    public ResponseEntity<?> payment(@RequestBody PaymentRequestDTO paymentRequest) throws IOException {
        ResponseData rs = paymentService.createPayment(paymentRequest);
        return ResponseEntity.ok(rs);
    }
}

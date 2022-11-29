package com.example.demo.rest;

import com.example.demo.bean.Payment;
import com.example.demo.repository.PaymentRepo;
import com.example.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class PaymentRest {

    @Autowired
    PaymentService paymentService;

    @PostMapping("/add")
    public Payment addPayment(@RequestBody Payment payment){
        return paymentService.addPayment(payment);
    }
}

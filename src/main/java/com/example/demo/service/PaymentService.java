package com.example.demo.service;
import com.example.demo.bean.Payment;
import com.example.demo.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PaymentService {
    @Autowired
    PaymentRepo paymentRepo;

    public Payment addPayment(Payment payment){

        return paymentRepo.save(payment);
    }
}

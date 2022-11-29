package com.example.demo.repository;

import com.example.demo.bean.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepo extends MongoRepository<Payment, String> {

}

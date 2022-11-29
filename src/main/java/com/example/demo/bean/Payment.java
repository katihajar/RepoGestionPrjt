package com.example.demo.bean;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    private String id;

    @NonNull
    @Indexed(unique = true)
    private String paymentName;

    @NonNull
    private String paymentDescription;

    @NonNull
    private double amount;

    @NonNull
    private Project project;

    public Payment(@NonNull String paymentName,
                   @NonNull String paymentDescription,
                   @NonNull double amount,
                   @NonNull Project project) {
        this.paymentName = paymentName;
        this.paymentDescription = paymentDescription;
        this.amount = amount;
        this.project = project;
    }
}

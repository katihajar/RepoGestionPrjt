package com.example.demo.bean;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Document
@Data
public class Task {
    @Id
    String id;
    @NonNull
    private String nom;
    @NonNull
    private String TaskDescription;
    @NonNull
    private Date dateDebut;
    @NonNull
    private Date dateFin;
    @NonNull
    private float pourcentage;
    private String statutChef;
    private String statutDirect;
    @DBRef
    private Project project;

}
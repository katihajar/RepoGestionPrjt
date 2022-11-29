package com.example.demo.bean;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class Project {
    @Id
    String id;
    private String nomProjet;
    private String description;
    private double cout;
    private Date dateDebut;
    private Date dateFin;
    private boolean statutChef;
    private boolean statutDirect;
    @DBRef
    private User user;
    public Project() {
    }
    public String getNomProjet() {
        return nomProjet;
    }

    public void setNomProjet(String nomProjet) {
        this.nomProjet = nomProjet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCout() {
        return cout;
    }

    public void setCout(double cout) {
        this.cout = cout;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public boolean isStatutChef() {
        return statutChef;
    }

    public void setStatutChef(boolean statutChef) {
        this.statutChef = statutChef;
    }

    public boolean isStatutDirect() {
        return statutDirect;
    }

    public void setStatutDirect(boolean statutDirect) {
        this.statutDirect = statutDirect;
    }
}

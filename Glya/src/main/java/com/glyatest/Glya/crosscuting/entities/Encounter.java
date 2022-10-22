package com.glyatest.Glya.crosscuting.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Document("encounters")
public class Encounter {
    @Id
    private String id;
    private LocalDate fecha;
    private String vacuna;
    private int dosis;
    @DBRef
    private String patient_id;
    private LocalDateTime updated_at;
    private LocalDateTime created_at;

    public Encounter(){}

    public Encounter(String id, LocalDate fecha, String vacuna, int dosis, String patient_id, LocalDateTime updated_at, LocalDateTime created_at) {
        this.id = id;
        this.fecha = fecha;
        this.vacuna = vacuna;
        this.dosis = dosis;
        this.patient_id = patient_id;
        this.updated_at = updated_at;
        this.created_at = created_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getVacuna() {
        return vacuna;
    }

    public void setVacuna(String vacuna) {
        this.vacuna = vacuna;
    }

    public int getDosis() {
        return dosis;
    }

    public void setDosis(int dosis) {
        this.dosis = dosis;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}

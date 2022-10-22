package com.glyatest.Glya.crosscuting.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("patients")
public class Patient {
    @Id
    private String id;
    private String nombre;
    private String cedula;
    private LocalDateTime updated_at;
    private LocalDateTime created_at;

    public Patient(){

    }

    public Patient(String id, String nombre, String cedula, LocalDateTime updated_at, LocalDateTime created_at) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.updated_at = updated_at;
        this.created_at = created_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

package com.hospital.rama.app.model;

import org.springframework.stereotype.Component;

@Component
public class Patient {
    String id;
    String name;
    String hospital;
    String disease;
    public Patient() {
    }
    public Patient(String id, String name, String hospital, String disease) {
        this.id = id;
        this.name = name;
        this.hospital = hospital;
        this.disease = disease;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }





}

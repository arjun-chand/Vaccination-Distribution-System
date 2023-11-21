package com.vaccinationDistributionSystem.VaccinationdistributionSystem.Entity;

import jakarta.persistence.*;

@Entity
public class Certificates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cId;
    @OneToOne
    Patient patient;

    public Certificates() {
    }

    public Certificates(int cId, Patient patient) {
        this.cId = cId;
        this.patient = patient;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}

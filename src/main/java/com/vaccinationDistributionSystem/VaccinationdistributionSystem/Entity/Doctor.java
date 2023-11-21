package com.vaccinationDistributionSystem.VaccinationdistributionSystem.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dId;
    private String dName;
    private String dDegree;
    @ManyToOne
    VaccinationCenter vaccinationCenter;
    @OneToMany(mappedBy = "doctor")
    List<Patient> patients;

    private int patientCount;

    public Doctor() {
    }

    public Doctor(int dId, String dName, String dDegree, VaccinationCenter vaccinationCenter, int patientCount) {
        this.dId = dId;
        this.dName = dName;
        this.dDegree = dDegree;
        this.vaccinationCenter = vaccinationCenter;
        this.patientCount = patientCount;
    }

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getdDegree() {
        return dDegree;
    }

    public void setdDegree(String dDegree) {
        this.dDegree = dDegree;
    }

    public VaccinationCenter getVaccinationCenter() {
        return vaccinationCenter;
    }

    public void setVaccinationCenter(VaccinationCenter vaccinationCenter) {
        this.vaccinationCenter = vaccinationCenter;
    }

    public int getPatientCount() {
        return patientCount;
    }

    public void setPatientCount(int patientCount) {
        this.patientCount = patientCount;
    }
}

package com.vaccinationDistributionSystem.VaccinationdistributionSystem.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class VaccinationCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //it will create random id value
    private int vcId;
    private String centerName;
    private int covishieldDose;
    private int covaxineDose;
    private int sputnikDose;
    private String type;
    private String address;

    @OneToMany(mappedBy = "vaccinationCenter")
    List<Doctor> doctors;

    public VaccinationCenter(int vcId, String centerName, int covishieldDose, int covaxineDose, int sputnikDose, String type, String address) {
        this.vcId = vcId;
        this.centerName = centerName;
        this.covishieldDose = covishieldDose;
        this.covaxineDose = covaxineDose;
        this.sputnikDose = sputnikDose;
        this.type = type;
        this.address = address;
    }

    public VaccinationCenter() {

    }

    public int getVcId() {
        return vcId;
    }

    public void setVcId(int vcId) {
        this.vcId = vcId;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public int getCovishieldDose() {
        return covishieldDose;
    }

    public void setCovishieldDose(int covishieldDose) {
        this.covishieldDose = covishieldDose;
    }

    public int getCovaxineDose() {
        return covaxineDose;
    }

    public void setCovaxineDose(int covaxineDose) {
        this.covaxineDose = covaxineDose;
    }

    public int getSputnikDose() {
        return sputnikDose;
    }

    public void setSputnikDose(int sputnikDose) {
        this.sputnikDose = sputnikDose;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

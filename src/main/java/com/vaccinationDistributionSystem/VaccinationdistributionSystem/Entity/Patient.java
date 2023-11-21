package com.vaccinationDistributionSystem.VaccinationdistributionSystem.Entity;

import jakarta.persistence.*;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pId;

    private String pName;
    private String vaccinationPreference;
    private String centerPreference;
    @ManyToOne
    VaccinationCenter vaccinationCenter;
    @ManyToOne
    Doctor doctor;
    @Column(unique = true)
    private Long phoneNumber;
    @Column(name = "certificate_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use appropriate strategy
    private Long certificateId;
    @Column(unique = true)
    private String email;
    boolean isVaccinated;

    public Patient(int pId, String pName, String vaccinationPreference, String centerPreference, VaccinationCenter vaccinationCenter, Doctor doctor, Long phoneNumber, Long certificateId, String email, boolean isVaccinated) {
        this.pId = pId;
        this.pName = pName;
        this.vaccinationPreference = vaccinationPreference;
        this.centerPreference = centerPreference;
        this.vaccinationCenter = vaccinationCenter;
        this.doctor = doctor;
        this.phoneNumber = phoneNumber;
        this.certificateId = certificateId;
        this.email = email;
        this.isVaccinated = isVaccinated;
    }

    public Patient() {
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getVaccinationPreference() {
        return vaccinationPreference;
    }

    public void setVaccinationPreference(String vaccinationPreference) {
        this.vaccinationPreference = vaccinationPreference;
    }

    public String getCenterPreference() {
        return centerPreference;
    }

    public void setCenterPreference(String centerPreference) {
        this.centerPreference = centerPreference;
    }

    public VaccinationCenter getVaccinationCenter() {
        return vaccinationCenter;
    }

    public void setVaccinationCenter(VaccinationCenter vaccinationCenter) {
        this.vaccinationCenter = vaccinationCenter;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(Long certificateId) {
        this.certificateId = certificateId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        isVaccinated = vaccinated;
    }
}

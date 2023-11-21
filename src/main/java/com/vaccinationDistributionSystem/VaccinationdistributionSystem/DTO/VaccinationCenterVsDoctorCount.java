package com.vaccinationDistributionSystem.VaccinationdistributionSystem.DTO;

import lombok.*;
import lombok.experimental.FieldDefaults;


public class VaccinationCenterVsDoctorCount {
    private int vaccinationId;
    private int totalDocCount;
    public VaccinationCenterVsDoctorCount() {
    }

    public VaccinationCenterVsDoctorCount(int vaccinationId, int totalDocCount) {
        this.vaccinationId = vaccinationId;
        this.totalDocCount = totalDocCount;
    }

    public int getVaccinationId() {
        return vaccinationId;
    }

    public void setVaccinationId(int vaccinationId) {
        this.vaccinationId = vaccinationId;
    }

    public int getTotalDocCount() {
        return totalDocCount;
    }

    public void setTotalDocCount(int totalDocCount) {
        this.totalDocCount = totalDocCount;
    }
}

package com.vaccinationDistributionSystem.VaccinationdistributionSystem.DTO.ResponseDTO;

public class CenterNameDoseType {
    String centerName;
    String DoseType;
    int doseCount;

    public CenterNameDoseType() {
    }

    public CenterNameDoseType(String centerName, String doseType, int doseCount) {
        this.centerName = centerName;
        DoseType = doseType;
        this.doseCount = doseCount;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getDoseType() {
        return DoseType;
    }

    public void setDoseType(String doseType) {
        DoseType = doseType;
    }

    public int getDoseCount() {
        return doseCount;
    }

    public void setDoseCount(int doseCount) {
        this.doseCount = doseCount;
    }
}

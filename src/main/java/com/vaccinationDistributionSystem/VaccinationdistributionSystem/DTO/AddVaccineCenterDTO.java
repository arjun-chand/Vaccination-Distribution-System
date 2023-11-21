package com.vaccinationDistributionSystem.VaccinationdistributionSystem.DTO;

import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Enums.CenterPreference;

public class AddVaccineCenterDTO {
    private String address;
    private String centerName;
    private int covaxineDoses;
    private int covishieldDoses;
    private int sputnixDoses;
    CenterPreference type;

    public AddVaccineCenterDTO(String address, String centerName, int covaxineDoses, int covishieldDoses, int sputnixDoses, CenterPreference type) {
        this.address = address;
        this.centerName = centerName;
        this.covaxineDoses = covaxineDoses;
        this.covishieldDoses = covishieldDoses;
        this.sputnixDoses = sputnixDoses;
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public int getCovaxineDoses() {
        return covaxineDoses;
    }

    public void setCovaxineDoses(int covaxineDoses) {
        this.covaxineDoses = covaxineDoses;
    }

    public int getCovishieldDoses() {
        return covishieldDoses;
    }

    public void setCovishieldDoses(int covishieldDoses) {
        this.covishieldDoses = covishieldDoses;
    }

    public int getSputnixDoses() {
        return sputnixDoses;
    }

    public void setSputnixDoses(int sputnixDoses) {
        this.sputnixDoses = sputnixDoses;
    }

    public CenterPreference getType() {
        return type;
    }

    public void setType(CenterPreference type) {
        this.type = type;
    }


}

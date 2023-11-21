package com.vaccinationDistributionSystem.VaccinationdistributionSystem.DTO;

import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Enums.CenterPreference;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Enums.VaccinationPreference;

public class AddpatientDTO {
    String pName;
    CenterPreference centerPreference;
    VaccinationPreference vaccinationPreference;
    Long phoneNUmber;
    String email;

    public AddpatientDTO(String pName, CenterPreference centerPreference, VaccinationPreference vaccinationPreference, Long phoneNUmber, String email) {
        this.pName = pName;
        this.centerPreference = centerPreference;
        this.vaccinationPreference = vaccinationPreference;
        this.phoneNUmber = phoneNUmber;
        this.email = email;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public CenterPreference getCenterPreference() {
        return centerPreference;
    }

    public void setCenterPreference(CenterPreference centerPreference) {
        this.centerPreference = centerPreference;
    }

    public VaccinationPreference getVaccinationPreference() {
        return vaccinationPreference;
    }

    public void setVaccinationPreference(VaccinationPreference vaccinationPreference) {
        this.vaccinationPreference = vaccinationPreference;
    }

    public Long getPhoneNUmber() {
        return phoneNUmber;
    }

    public void setPhoneNUmber(Long phoneNUmber) {
        this.phoneNUmber = phoneNUmber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

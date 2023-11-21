package com.vaccinationDistributionSystem.VaccinationdistributionSystem.DTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

public class AddDoctorDTO {
    private String name;
    private String degree;


    public AddDoctorDTO() {
    }

    public AddDoctorDTO(String name, String degree ){
        this.name = name;
        this.degree = degree;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}

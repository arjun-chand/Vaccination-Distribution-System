package com.vaccinationDistributionSystem.VaccinationdistributionSystem.Controller;

import com.vaccinationDistributionSystem.VaccinationdistributionSystem.DTO.AddDoctorDTO;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {
    @Autowired
    DoctorService doctorService;
    @PostMapping("/api/doctor/add")
    public String addDocToDataBase(@RequestBody AddDoctorDTO doctorDTO){
        doctorService.createDoctor(doctorDTO);
        return "Doctor successfully added to DataBase";
    }
}

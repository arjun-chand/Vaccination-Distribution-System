package com.vaccinationDistributionSystem.VaccinationdistributionSystem.Controller;

import com.vaccinationDistributionSystem.VaccinationdistributionSystem.DTO.AddDoctorDTO;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Entity.Doctor;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Exception.VaccinationCenterIsNotPresentException;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {
    @Autowired
    DoctorService doctorService;
    @PostMapping("/api/doctor/add")
    public ResponseEntity addDocToDataBase(@RequestBody AddDoctorDTO doctorDTO){
        try {
            Doctor doctor = doctorService.createDoctor(doctorDTO);
            return new ResponseEntity<>(doctor, HttpStatus.CREATED);
        }catch (VaccinationCenterIsNotPresentException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}

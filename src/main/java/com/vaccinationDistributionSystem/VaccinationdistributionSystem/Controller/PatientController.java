package com.vaccinationDistributionSystem.VaccinationdistributionSystem.Controller;

import com.vaccinationDistributionSystem.VaccinationdistributionSystem.DTO.AddpatientDTO;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController {
    @Autowired
    PatientService patientService;

    @PostMapping("/api/patient/add")
    public String addPatient(@RequestBody AddpatientDTO patient){
        patientService.createPatient(patient);
        return "patient added successfully";
    }
    @GetMapping("/api/patient/get-dose")
    public String getDose(@RequestParam int pId){
        patientService.provideDoseTOPatient(pId);
        return "Patient got vaccinated";
    }

}

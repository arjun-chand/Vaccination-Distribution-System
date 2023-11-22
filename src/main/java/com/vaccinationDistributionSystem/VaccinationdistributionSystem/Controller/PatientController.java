package com.vaccinationDistributionSystem.VaccinationdistributionSystem.Controller;

import com.vaccinationDistributionSystem.VaccinationdistributionSystem.DTO.AddpatientDTO;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Entity.Patient;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Exception.AlreadyGotVaccinatedException;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Exception.DoctorDoesNotExistException;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Exception.PatientDoesNotExistException;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Exception.VaccinationCenterIsNotPresentException;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController {
    @Autowired
    PatientService patientService;

    @PostMapping("/api/patient/add")
    public ResponseEntity addPatient(@RequestBody AddpatientDTO patient){
        try {
            Patient obj = patientService.createPatient(patient);
            return new ResponseEntity<>(obj,HttpStatus.ACCEPTED);
        }catch (DoctorDoesNotExistException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }catch (VaccinationCenterIsNotPresentException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/patient/{pId}")
    public ResponseEntity getPatient(@PathVariable int pId){
        try {
            Patient obj = patientService.getPatientById(pId);
            return new ResponseEntity<>(obj,HttpStatus.FOUND);
        }catch (PatientDoesNotExistException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }
    @GetMapping("/api/patient/get-dose")
    public ResponseEntity<String> getDose(@RequestParam int pId){
        try {
            patientService.provideDoseTOPatient(pId);
            return new ResponseEntity<>("Patient got vaccinated", HttpStatus.CREATED);
        }catch (AlreadyGotVaccinatedException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }catch (PatientDoesNotExistException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_GATEWAY);
        }
    }

}

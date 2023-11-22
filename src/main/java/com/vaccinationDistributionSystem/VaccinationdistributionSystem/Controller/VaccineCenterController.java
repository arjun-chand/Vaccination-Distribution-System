package com.vaccinationDistributionSystem.VaccinationdistributionSystem.Controller;

import com.vaccinationDistributionSystem.VaccinationdistributionSystem.DTO.AddVaccineCenterDTO;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.DTO.ResponseDTO.CenterNameDoseType;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Entity.VaccinationCenter;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Exception.VaccinationCenterIsNotPresentException;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VaccineCenterController {
    @Autowired
    VaccinationCenterService vaccinationCenterService;
    @PostMapping("/api/vaccination-center/add")
    public ResponseEntity createVaccinationCenter(@RequestBody AddVaccineCenterDTO Obj){
        VaccinationCenter vaccinationCenter = vaccinationCenterService.createVaccinationCenter(Obj);
        return new ResponseEntity<>(vaccinationCenter,HttpStatus.CREATED);
    }
    @GetMapping("/api/vaccination-center/")
    public List<VaccinationCenter> getVaccinationCenter(@RequestParam String centerName){
        return vaccinationCenterService.searchByName(centerName);
    }
    @GetMapping("/api/vaccination-center/{centerName}")
    public ResponseEntity getParticularVaccinationCenterDoseCount(@PathVariable String centerName, @RequestParam String doseType){
        try {
            List<VaccinationCenter> data = vaccinationCenterService.getParticularVaccinationCenterDoseCount(centerName,doseType);
            return new ResponseEntity<>(data, HttpStatus.OK);
        }catch (VaccinationCenterIsNotPresentException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}

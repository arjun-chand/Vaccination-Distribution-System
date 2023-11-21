package com.vaccinationDistributionSystem.VaccinationdistributionSystem.Controller;

import com.vaccinationDistributionSystem.VaccinationdistributionSystem.DTO.AddVaccineCenterDTO;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.DTO.ResponseDTO.CenterNameDoseType;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Entity.VaccinationCenter;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VaccineCenterController {
    @Autowired
    VaccinationCenterService vaccinationCenterService;
    @PostMapping("/api/vaccination-center/add")
    public String createVaccinationCenter(@RequestBody AddVaccineCenterDTO Obj){
        vaccinationCenterService.createVaccinationCenter(Obj);
        return " Vaccination Center got created into Database";
    }
    @GetMapping("/api/vaccination-center/")
    public List<VaccinationCenter> getVaccinationCenter(@RequestParam String centerName){
        return vaccinationCenterService.searchByName(centerName);
    }
    @GetMapping("/api/vaccination-center/{centerName}")
    public List<CenterNameDoseType> getParticularVaccinationCenterDoseCount(@PathVariable String centerName, @RequestParam String doseType){
        return vaccinationCenterService.getParticularVaccinationCenterDoseCount(centerName,doseType);
    }
}

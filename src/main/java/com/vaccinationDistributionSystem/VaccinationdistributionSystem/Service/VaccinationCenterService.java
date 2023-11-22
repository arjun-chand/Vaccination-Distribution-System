package com.vaccinationDistributionSystem.VaccinationdistributionSystem.Service;

import com.vaccinationDistributionSystem.VaccinationdistributionSystem.DTO.AddVaccineCenterDTO;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.DTO.ResponseDTO.CenterNameDoseType;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Entity.VaccinationCenter;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Exception.VaccinationCenterIsNotPresentException;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VaccinationCenterService {
    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;
    public VaccinationCenter createVaccinationCenter(AddVaccineCenterDTO addVaccineCenterDetail){
        VaccinationCenter obj = new VaccinationCenter();
        obj.setCenterName(addVaccineCenterDetail.getCenterName());
        obj.setCovaxineDose(addVaccineCenterDetail.getCovaxineDoses());
        obj.setCovishieldDose(addVaccineCenterDetail.getCovishieldDoses());
        obj.setSputnikDose(addVaccineCenterDetail.getSputnixDoses());
        obj.setType(addVaccineCenterDetail.getType().toString());
        obj.setAddress(addVaccineCenterDetail.getAddress());
        vaccinationCenterRepository.save(obj);
        return obj;

    }
    public List<VaccinationCenter> searchByName(String centerName){
        List<VaccinationCenter> data = vaccinationCenterRepository.findByCenterName(centerName);
        if(data.isEmpty()){
            throw new VaccinationCenterIsNotPresentException(String.format("Vaccination center with the entered name '%s' does not Exist",centerName));
        }
        return data;
    }
    public VaccinationCenter getById(int vcId){
        return vaccinationCenterRepository.findById(vcId).orElse(null);
    }
    public List<VaccinationCenter> getParticularVaccinationCenterDoseCount(String centerName, String doseType){
        List<VaccinationCenter> allVaccinationCenterByName = vaccinationCenterRepository.findByCenterName(centerName);
        List<CenterNameDoseType> allVaccinationCenterParticularVaccineDetail = new ArrayList<>();
        for (VaccinationCenter obj : allVaccinationCenterByName){
            CenterNameDoseType dtoObj = new CenterNameDoseType();
            dtoObj.setCenterName(obj.getCenterName());
            dtoObj.setDoseType(obj.getType());

            if(dtoObj.getDoseType().equals("SPUTNIX")){
                dtoObj.setDoseCount(obj.getSputnikDose());
            }else if(dtoObj.getDoseType().equals("COVAXINE")){
                dtoObj.setDoseCount(obj.getCovaxineDose());
            }else if (dtoObj.getDoseType().equals("COVISHIELD")){
                dtoObj.setDoseCount(obj.getCovishieldDose());
            }
            allVaccinationCenterParticularVaccineDetail.add(dtoObj);
        }
        return allVaccinationCenterByName;
    }
}

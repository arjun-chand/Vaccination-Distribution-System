package com.vaccinationDistributionSystem.VaccinationdistributionSystem.Service;

import com.vaccinationDistributionSystem.VaccinationdistributionSystem.DTO.AddDoctorDTO;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.DTO.VaccinationCenterVsDoctorCount;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Entity.Doctor;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    VaccinationCenterService vaccinationCenterService;

    public void createDoctor(AddDoctorDTO dtObj) {
        List<Object[]> data = doctorRepository.getVaccinationCenterVsDoctorCount();

        Object[] minVcId = data.get(0);
        int minId = Integer.parseInt(minVcId[0].toString());
        Doctor doctor = new Doctor();
        doctor.setdName(dtObj.getName());
        doctor.setdDegree(dtObj.getDegree());
        doctor.setVaccinationCenter(vaccinationCenterService.getById(minId));

        // Save the doctor entity
        doctorRepository.save(doctor);
    }
}

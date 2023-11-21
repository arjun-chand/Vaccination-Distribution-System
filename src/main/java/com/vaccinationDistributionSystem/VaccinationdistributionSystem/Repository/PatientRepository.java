package com.vaccinationDistributionSystem.VaccinationdistributionSystem.Repository;

import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {


}

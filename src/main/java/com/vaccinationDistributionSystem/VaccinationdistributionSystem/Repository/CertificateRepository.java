package com.vaccinationDistributionSystem.VaccinationdistributionSystem.Repository;

import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Entity.Certificates;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepository extends JpaRepository<Certificates,Integer> {
    @Query(value = "select * from certificates where patient_p_id=:pId", nativeQuery = true)
    public Certificates findByPatient(int pId);
}

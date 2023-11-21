package com.vaccinationDistributionSystem.VaccinationdistributionSystem.Repository;

import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Entity.Certificates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepository extends JpaRepository<Certificates,Integer> {
}

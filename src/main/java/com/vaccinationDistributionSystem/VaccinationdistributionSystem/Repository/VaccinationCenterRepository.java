package com.vaccinationDistributionSystem.VaccinationdistributionSystem.Repository;

import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Entity.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter,Integer> {
    List<VaccinationCenter> findByCenterName(String centerName);
    @Query(value = "SELECT vc.vc_id, COUNT(*) FROM vaccination_center as vc LEFT JOIN patient p ON vc.vc_id = p.vaccination_center_vc_id WHERE vc.type = type GROUP BY vc.vc_id ORDER BY count asc", nativeQuery = true)
    List<Object[]> getMinimumPatientVaccinationCenter(String type);
}


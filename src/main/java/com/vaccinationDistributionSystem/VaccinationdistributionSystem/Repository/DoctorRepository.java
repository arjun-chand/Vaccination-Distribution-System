package com.vaccinationDistributionSystem.VaccinationdistributionSystem.Repository;

import com.vaccinationDistributionSystem.VaccinationdistributionSystem.DTO.VaccinationCenterVsDoctorCount;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    @Query(value = "SELECT vc.vc_id AS vaccination_center_vc_id, COUNT(*) FROM vaccination_center AS vc LEFT JOIN doctor d ON vc.vc_id = d.vaccination_center_vc_id GROUP BY vc.vc_id", nativeQuery = true)
    List<Object[]> getVaccinationCenterVsDoctorCount();
    @Query(value = "select doc.d_id,count(*) from doctor as doc left join patient p  on doc.d_id = p.doctor_d_id group by doc.d_id order by count asc;",nativeQuery = true)
    public List<Object[]> getDoctorVsPatientCount();
}

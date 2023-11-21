package com.vaccinationDistributionSystem.VaccinationdistributionSystem.Service;

import com.vaccinationDistributionSystem.VaccinationdistributionSystem.DTO.AddpatientDTO;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Entity.Certificates;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Entity.Doctor;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Entity.Patient;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Entity.VaccinationCenter;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Repository.CertificateRepository;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Repository.DoctorRepository;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Repository.PatientRepository;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    CertificateRepository certificateRepository;

    public void createPatient(AddpatientDTO addpatientDTO){
        Patient p = new Patient();
        p.setCenterPreference(addpatientDTO.getCenterPreference().toString());
        p.setEmail(addpatientDTO.getEmail());
        p.setpName(addpatientDTO.getpName());
        p.setPhoneNumber(addpatientDTO.getPhoneNUmber());
        p.setVaccinationPreference(addpatientDTO.getVaccinationPreference().toString());

        List<Object[]> doctorVsPatient = doctorRepository.getDoctorVsPatientCount();
        long minDocId = Integer.parseInt(doctorVsPatient.get(0)[0].toString());
        Doctor dObj = doctorRepository.findById(minDocId).orElse(null);
        p.setDoctor(dObj);
        p.setCenterPreference(addpatientDTO.getCenterPreference().toString());

        List<Object[]> vaccinationCenterVsPatient  =  vaccinationCenterRepository.getMinimumPatientVaccinationCenter(p.getVaccinationPreference());
        Object[] arr = vaccinationCenterVsPatient.get(0);
        int minId = Integer.parseInt(arr[0].toString());
        VaccinationCenter vcObj = vaccinationCenterRepository.findById(minId).orElse(null);
        p.setVaccinationCenter(vcObj);
        patientRepository.save(p);
    }

    public void provideDoseTOPatient(int pId){
        Patient obj = patientRepository.findById(pId).orElse(null);
        String email = obj.getEmail();
        String docName = obj.getDoctor().getdName();

        Certificates vaccineCertificate = new Certificates();
        vaccineCertificate.setPatient(obj);
        certificateRepository.save(vaccineCertificate);


        String text = "Hey "+obj.getpName()+", \n"+"Congratulations!!!! you got Vaccinated by the Doctor "+docName+" and your Vaccination certificate Id is "+vaccineCertificate.getcId();
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("spproacc3@gmail.com");
        simpleMailMessage.setTo(obj.getEmail());
        simpleMailMessage.setSubject("Covid Vaccination Success");
        simpleMailMessage.setText(text);

        javaMailSender.send(simpleMailMessage);
    }
}

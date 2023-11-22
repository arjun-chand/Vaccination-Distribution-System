package com.vaccinationDistributionSystem.VaccinationdistributionSystem.Service;

import com.vaccinationDistributionSystem.VaccinationdistributionSystem.DTO.AddpatientDTO;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Entity.Certificates;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Entity.Doctor;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Entity.Patient;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Entity.VaccinationCenter;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Exception.AlreadyGotVaccinatedException;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Exception.DoctorDoesNotExistException;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Exception.PatientDoesNotExistException;
import com.vaccinationDistributionSystem.VaccinationdistributionSystem.Exception.VaccinationCenterIsNotPresentException;
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

    public Patient createPatient(AddpatientDTO addpatientDTO){
        Patient p = new Patient();
        p.setCenterPreference(addpatientDTO.getCenterPreference().toString());
        p.setEmail(addpatientDTO.getEmail());
        p.setpName(addpatientDTO.getpName());
        p.setPhoneNumber(addpatientDTO.getPhoneNUmber());
        p.setVaccinationPreference(addpatientDTO.getVaccinationPreference().toString());

        List<Object[]> doctorVsPatient = doctorRepository.getDoctorVsPatientCount();
        if(doctorVsPatient.isEmpty()) {
            throw new DoctorDoesNotExistException("Hey you are trying to add Doctor but no doctor is present in database at the moment");
        }
        long minDocId = Integer.parseInt(doctorVsPatient.get(0)[0].toString());
        Doctor dObj = doctorRepository.findById(minDocId).orElse(null);
        p.setDoctor(dObj);
        p.setCenterPreference(addpatientDTO.getCenterPreference().toString());

        List<Object[]> vaccinationCenterVsPatient  =  vaccinationCenterRepository.getMinimumPatientVaccinationCenter(p.getVaccinationPreference());
        if(vaccinationCenterVsPatient.isEmpty()){
            throw new VaccinationCenterIsNotPresentException("Vaccination center is not present in our Databse that's why we are not able to add patient");
        }
        Object[] arr = vaccinationCenterVsPatient.get(0);
        int minId = Integer.parseInt(arr[0].toString());
        VaccinationCenter vcObj = vaccinationCenterRepository.findById(minId).orElse(null);
        p.setVaccinationCenter(vcObj);
        patientRepository.save(p);
        return p;
    }

    public void provideDoseTOPatient(int pId){
        Patient obj = patientRepository.findById(pId).orElse(null);
        if(obj == null){
            throw new PatientDoesNotExistException(String.format("Patient with %d ID that you are searching is not present in our Database",pId));
        }
        String email = obj.getEmail();
        String docName = obj.getDoctor().getdName();

        Certificates vaccineCertificate = new Certificates();
        vaccineCertificate.setPatient(obj);

        //if patient is already present is certificate table it means the patient is already vaccinated
        //that's why already got vaccinated error we are going to show
        if(certificateRepository.findByPatient(obj.getpId())!= null){
            throw new AlreadyGotVaccinatedException(String.format("patient with %d is already vaccinated",pId));
        }
        certificateRepository.save(vaccineCertificate);


        String text = "Hey "+obj.getpName()+", \n"+"Congratulations!!!! you got Vaccinated by the Doctor "+docName+" and your Vaccination certificate Id is "+vaccineCertificate.getcId();
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("spproacc3@gmail.com");
        simpleMailMessage.setTo(obj.getEmail());
        simpleMailMessage.setSubject("Covid Vaccination Success");
        simpleMailMessage.setText(text);

        try {
            javaMailSender.send(simpleMailMessage);
        }catch (Exception e){
            throw e;
        }

    }
    public Patient getPatientById(int pId){
        Patient p = patientRepository.findById(pId).orElse(null);
        if(p == null){
            throw new PatientDoesNotExistException(String.format("Patient with %d ID that you are searching is not present in our Database",pId));
        }
        return p;
    }
}

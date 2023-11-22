package com.vaccinationDistributionSystem.VaccinationdistributionSystem.Exception;

public class DoctorDoesNotExistException extends RuntimeException{
    public DoctorDoesNotExistException(String msgs){
        super(msgs);
    }
}

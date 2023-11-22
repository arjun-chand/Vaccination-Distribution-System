package com.vaccinationDistributionSystem.VaccinationdistributionSystem.Exception;

public class PatientDoesNotExistException extends RuntimeException{
    public PatientDoesNotExistException(String mssg){
        super(mssg);
    }
}

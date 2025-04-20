package com.saggy.HMS.services;


import com.saggy.HMS.models.Patient;
import com.saggy.HMS.repo.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private static final Logger logger= LoggerFactory.getLogger(PatientService.class);

    @Autowired
    private PatientRepository patientRepository;


    public Page<Patient> getAllPatients(int page , int size){
        try{
            System.out.println("Into the patient service");
            Pageable pageable= PageRequest.of(page,size); // object we require so that all the information are coming in right format
            return patientRepository.findAll(pageable);
            //interact with the repository layer
            //return null;
            //incase of any issues regarding the repository layer error will be shown here
        }
        catch(Exception e){
            System.out.println("Error Message : " +e.getMessage());
            logger.error("An error occured while facing all patients : {}",e.getMessage());
            return null;
        }
    }

    public Patient getPatientById(Long id){
        try{
            // findById function in JpaRepository interface returns a Optional value with it
            // container object may or may not contain non-null values
            Optional<Patient> patient= patientRepository.findById(id); // while accessing the values we won't get any null value exception
            return patient.orElse(null);
        }
        catch(Exception e){
            System.out.println("Error Message : " +e.getMessage());
            logger.error("An error occured while facing all patient with id {} : {}",id,e.getMessage());
            return null;
        }

    }
    public Patient createPatient(Patient patient){
        try{
            patientRepository.save(patient);
            return patient;
        }
        catch(Exception e){
            System.out.println("Error Message : " +e.getMessage());
            return null;
        }
    }
    public void deletePatient(Long id){
        try{
            logger.info("Deleting patient with id : {}",id);
            patientRepository.deleteById(id);
        }
        catch(Exception e){
            System.out.println("Error Message : " +e.getMessage());
        }
    }
    public Patient updatePatient(Long id,Patient updatedPatient){
        try{
            Optional<Patient> existingPatient=patientRepository.findById(id);
            if(existingPatient.isPresent()){
                Patient p=existingPatient.get();
                p.setName(updatedPatient.getName());
                p.setAge(updatedPatient.getAge());
                p.setGender(updatedPatient.getGender());
                patientRepository.save(p);
                return updatedPatient;
            }
            else{
                logger.error("Patient with id{} not found",id);
                return null;
            }
        }
        catch(Exception e){
            System.out.println("Error Message : " +e.getMessage());
            return null;
        }
    }
}

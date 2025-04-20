package com.saggy.HMS.services;


import com.saggy.HMS.models.Doctor;
import com.saggy.HMS.repo.DoctorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class DoctorService {

    private static  final Logger logger= LoggerFactory.getLogger(DoctorService.class);

    @Autowired
    private DoctorRepository doctorRepository;

    public Page<Doctor> getAllDoctors(int page , int size){
        try{
            System.out.println("Into the patient service");
            Pageable pageable= PageRequest.of(page,size); // object we require so that all the information are coming in right format
            return doctorRepository.findAll(pageable);
            //interact with the repository layer
            //return null;
            //incase of any issues regarding the repository layer error will be shown here
        }
        catch(Exception e){
            System.out.println("Error Message : " +e.getMessage());
            logger.error("An error occured while facing all doctors : {}",e.getMessage());
            return null;
        }
    }

    public Doctor getDoctorById(Long id) {
        try {
            // findById returns an Optional; helps avoid NullPointerException
            Optional<Doctor> doctor = doctorRepository.findById(id);
            return doctor.orElse(null); // return doctor if present, else null
        } catch (Exception e) {
            System.out.println("Error Message: " + e.getMessage());
            logger.error("An error occurred while fetching doctor with id {}: {}", id, e.getMessage());
            return null;
        }
    }

    public Doctor createDoctor(Doctor doctor){
        try{
            doctorRepository.save(doctor);
            return doctor;
        }
        catch(Exception e){
            System.out.println("Error Message : " +e.getMessage());
            return null;
        }
    }
    public void deleteDoctor(Long id){
        try{
            logger.info("Deleting doctor with id : {}",id);
            doctorRepository.deleteById(id);
        }
        catch(Exception e){
            System.out.println("Error Message : " +e.getMessage());
        }
    }
    public Doctor updateDoctor(Long id, Doctor updatedDoctor) {
        try {
            Optional<Doctor> existingDoctor = doctorRepository.findById(id);
            if (existingDoctor.isPresent()) {
                Doctor doctor = existingDoctor.get();
                doctor.setName(updatedDoctor.getName());
                doctor.setSpeciality(updatedDoctor.getSpeciality());
                doctorRepository.save(doctor);
                return doctor; // return the saved (updated) doctor
            } else {
                logger.error("Doctor with id {} not found", id);
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error Message: " + e.getMessage());
            return null;
        }
    }
}

package com.saggy.HMS.controllers;


import com.saggy.HMS.models.Patient;
import com.saggy.HMS.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientControllers {


    @Autowired
    private PatientService patientService;
    // patient service class object dependency injected through autowiring
    //spring framework will give the dependancy of that attribute when the instance of that class is created
    //component scan and auto config concept of spring framework



    @GetMapping
    public Page<Patient> getAllPatients(@RequestParam(defaultValue = "0") int page , @RequestParam(defaultValue = "2") int size){
        System.out.println("Fetching the patients");
        return patientService.getAllPatients(page,size);
    }

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient){
        System.out.println("Creating Patient");
        return patientService.createPatient(patient);
    }


    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id){
        System.out.println("Fetching details by id");

        return patientService.getPatientById(id);
    }
    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id){
        System.out.println("deleting  details by id");
        patientService.deletePatient(id);
    }

    @PutMapping("/{id}")
    public void updatePatient(@PathVariable Long id,@RequestBody Patient patient){
        System.out.println("deleting  details by id");
        patientService.updatePatient(id,patient);
    }
}

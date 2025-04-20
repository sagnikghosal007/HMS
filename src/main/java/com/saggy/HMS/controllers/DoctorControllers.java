package com.saggy.HMS.controllers;


import com.saggy.HMS.models.Doctor;
import com.saggy.HMS.models.Patient;
import com.saggy.HMS.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorControllers {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public Page<Doctor> getAllDoctors(@RequestParam(defaultValue = "0") int page , @RequestParam(defaultValue = "2") int size){
        System.out.println("Fetching the patients");
        return doctorService.getAllDoctors(page,size);
    }

    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor){
        System.out.println("Creating Doctors");
        return doctorService.createDoctor(doctor);
    }


    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id){
        System.out.println("Fetching details by id");

        return doctorService.getDoctorById(id);
    }


    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id){
        System.out.println("deleting  details by id");
        doctorService.deleteDoctor(id);

    }

    @PutMapping("/{id}")
    public void updateDoctor(@PathVariable Long id,@RequestBody Doctor doctor){
        System.out.println("deleting  details by id");
        doctorService.updateDoctor(id,doctor);
    }
}

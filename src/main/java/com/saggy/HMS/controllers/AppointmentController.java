package com.saggy.HMS.controllers;

import com.saggy.HMS.models.Appointment;
import com.saggy.HMS.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;
    // appointment service class object dependency injected through autowiring

    @GetMapping
    public List<Appointment> getAllAppointments() {
        System.out.println("Fetching all appointments");
        return appointmentService.getAllAppointments();
    }

    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        System.out.println("Creating appointment");
        return appointmentService.createAppointment(appointment);
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id) {
        System.out.println("Fetching appointment by ID");
        return appointmentService.getAppointmentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        System.out.println("Deleting appointment by ID");
        appointmentService.deleteAppointment(id);
    }

    @PutMapping("/{id}")
    public Appointment updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
        System.out.println("Updating appointment by ID");
        return appointmentService.updateAppointment(id, appointment);
    }
}

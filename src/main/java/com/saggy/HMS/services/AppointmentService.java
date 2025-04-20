package com.saggy.HMS.services;

import com.saggy.HMS.models.Appointment;
import com.saggy.HMS.repo.AppointmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private static final Logger logger = LoggerFactory.getLogger(AppointmentService.class);

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAllAppointments() {
        try {
            System.out.println("Into the appointment service");
            return appointmentRepository.findAll();
        } catch (Exception e) {
            System.out.println("Error Message : " + e.getMessage());
            logger.error("An error occurred while fetching all appointments: {}", e.getMessage());
            return null;
        }
    }

    public Appointment getAppointmentById(Long id) {
        try {
            Optional<Appointment> appointment = appointmentRepository.findById(id);
            return appointment.orElse(null);
        } catch (Exception e) {
            System.out.println("Error Message : " + e.getMessage());
            logger.error("An error occurred while fetching appointment with id {}: {}", id, e.getMessage());
            return null;
        }
    }

    public Appointment createAppointment(Appointment appointment) {
        try {
            appointmentRepository.save(appointment);
            return appointment;
        } catch (Exception e) {
            System.out.println("Error Message : " + e.getMessage());
            logger.error("An error occurred while creating an appointment: {}", e.getMessage());
            return null;
        }
    }

    public void deleteAppointment(Long id) {
        try {
            logger.info("Deleting appointment with id : {}", id);
            appointmentRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Error Message : " + e.getMessage());
            logger.error("An error occurred while deleting appointment with id {}: {}", id, e.getMessage());
        }
    }

    public Appointment updateAppointment(Long id, Appointment updatedAppointment) {
        try {
            Optional<Appointment> existingAppointment = appointmentRepository.findById(id);
            if (existingAppointment.isPresent()) {
                Appointment a = existingAppointment.get();
                a.setPatientId(updatedAppointment.getPatientId());
                a.setDoctorId(updatedAppointment.getDoctorId());
                a.setDate(updatedAppointment.getDate());
                appointmentRepository.save(a);
                return updatedAppointment;
            } else {
                logger.error("Appointment with id {} not found", id);
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error Message : " + e.getMessage());
            logger.error("An error occurred while updating appointment with id {}: {}", id, e.getMessage());
            return null;
        }
    }
}

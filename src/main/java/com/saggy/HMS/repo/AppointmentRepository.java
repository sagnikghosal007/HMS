package com.saggy.HMS.repo;

import com.saggy.HMS.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}

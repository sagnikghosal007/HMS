package com.saggy.HMS.repo;

import com.saggy.HMS.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;


@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

}

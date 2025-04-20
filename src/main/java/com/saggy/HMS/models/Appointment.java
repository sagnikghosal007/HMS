package com.saggy.HMS.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long patientId;
    private long doctorId;
    private String date;

    // Default constructor
    public Appointment() {}

    // Private constructor used by the Builder
    private Appointment(Builder builder) {
        this.id = builder.id;
        this.patientId = builder.patientId;
        this.doctorId = builder.doctorId;
        this.date = builder.date;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // Static inner Builder class
    public static class Builder {
        private Long id;
        private long patientId;
        private long doctorId;
        private String date;

        public Builder() {}

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder patientId(long patientId) {
            this.patientId = patientId;
            return this;
        }

        public Builder doctorId(long doctorId) {
            this.doctorId = doctorId;
            return this;
        }

        public Builder date(String date) {
            this.date = date;
            return this;
        }

        public Appointment build() {
            return new Appointment(this);
        }
    }
}

package com.saggy.HMS.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long patientId;
    private double amount;
    private String status;

    // Default constructor
    public Bill() {}

    // Private constructor for Builder
    private Bill(Builder builder) {
        this.id = builder.id;
        this.patientId = builder.patientId;
        this.amount = builder.amount;
        this.status = builder.status;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Static inner Builder class
    public static class Builder {
        private Long id;
        private long patientId;
        private double amount;
        private String status;

        public Builder() {}

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder patientId(long patientId) {
            this.patientId = patientId;
            return this;
        }

        public Builder amount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Bill build() {
            return new Bill(this);
        }
    }
}

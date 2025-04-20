package com.saggy.HMS.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String speciality;



    // Default constructor
    public Doctor() {}

    // Private constructor to be used by the Builder
    private Doctor(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.speciality = builder.speciality;

    }

    // Getters and Setters


    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String gender) {
        this.speciality = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Static Builder class
    public static class Builder {
        private Long id;
        private String name;
        private String speciality;


        public Builder() {}

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder speciality(String speciality) {
            this.speciality = speciality;
            return this;
        }


        public Doctor build() {
            return new Doctor(this);
        }
    }
}

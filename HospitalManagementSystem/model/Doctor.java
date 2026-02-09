package com.Hospitalmanagement.HospitalManagementSystem.model;

public class Doctor {

    private int doctorId;
    private String doctorName;
    private String specialization;
    private String phone;
    private String email;
    private int experience;
    private String availability;

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    // ✅ ADD THIS METHOD
    @Override
    public String toString() {
        return "Doctor ID: " + doctorId +
               ", Name: " + doctorName +
               ", Specialization: " + specialization +
               ", Phone: " + phone +
               ", Email: " + email +
               ", Experience: " + experience +
               ", Availability: " + availability;
    }
}

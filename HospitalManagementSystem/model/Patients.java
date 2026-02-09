package com.Hospitalmanagement.HospitalManagementSystem.model;

import java.sql.Date;

public class Patients {

    private int patientId;
    private String patientName;
    private int age;
    private String gender;
    private String phone;
    private String bloodGroup;
    private String disease;
    private Date registrationDate;

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    // ✅ ADD THIS
    @Override
    public String toString() {
        return "Patient ID: " + patientId +
               ", Name: " + patientName +
               ", Age: " + age +
               ", Gender: " + gender +
               ", Phone: " + phone +
               ", Blood Group: " + bloodGroup +
               ", Disease: " + disease +
               ", Registered On: " + registrationDate;
    }
}

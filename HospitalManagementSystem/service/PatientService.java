package com.Hospitalmanagement.HospitalManagementSystem.service;

import java.util.List;
import com.Hospitalmanagement.HospitalManagementSystem.model.Patients;

public interface PatientService {
    boolean addPatient(Patients patient);
    Patients getPatientById(int patientId);
    List<Patients> getAllPatients();
    boolean updatePatient(Patients patient);
    boolean deletePatient(int patientId);
}

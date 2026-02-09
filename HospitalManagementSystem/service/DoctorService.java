



package com.Hospitalmanagement.HospitalManagementSystem.service;

import java.util.List;
import com.Hospitalmanagement.HospitalManagementSystem.model.Doctor;

public interface DoctorService {
    boolean addDoctor(Doctor doctor);
    Doctor getDoctorById(int doctorId);
    List<Doctor> getAllDoctors();
    boolean updateDoctor(Doctor doctor);
    boolean deleteDoctor(int doctorId);
}
